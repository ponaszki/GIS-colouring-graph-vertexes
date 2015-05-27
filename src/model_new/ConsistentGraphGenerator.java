package model_new;

import java.util.ArrayList;
import java.util.Random;
public class ConsistentGraphGenerator {
	// lista wygenerowanych wierzcholkow bedacych w grafie
	private ArrayList<Integer> vertexes;
	private ArrayList<ArrayList<Integer>> edges; 
	private int vertexNum;
	private int edgeNum;
	public ConsistentGraphGenerator(int vertexNum, int edgeNum){
		this.vertexNum = vertexNum;
		this.edgeNum = edgeNum;
		// inicjuje pusta lista wykorzystanych juz wierzcholkow
		vertexes = new ArrayList<Integer>();
		edges = new ArrayList<ArrayList<Integer>>();
		// wpisuje wierzcholki do listy wierzcholkow
		CreateVertexInitialList();
		// tworze graf z vertexNum wierzcholkow
		CreateConsistentGraph();
		// dodaje krawedzie pozostale
		AddUnusedEdges();
		System.out.print("");
	}
	public ArrayList<Integer> GetVertexes(){
		return this.vertexes;
	}
	public ArrayList<ArrayList<Integer>> GetEdges(){
		return this.edges;
	}
	private void CreateVertexInitialList(){
		for(int i=1; i <= this.vertexNum; ++i){
			this.vertexes.add(i);
		}
	}
	// metoda do losowania randomowego indexu
	private static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	// wartosc liczby krawedzi dla grafu pelnego
	public int getMaxEdgesValue(int vnum){
		return (int)(vnum * (vnum - 1) * 0.5);
	}
	// tworz spojny graf z pierwszych wierzcholkow;
	private void CreateConsistentGraph(){
		ArrayList<Integer> tempV;
		for(int i = 0; i < this.vertexNum - 1; ++i){
			tempV = new ArrayList<Integer>();
			tempV.add(this.vertexes.get(i));
			tempV.add(this.vertexes.get(i + 1));
			edges.add(tempV);
		}
	}
	private Boolean isEdge(int v1, int v2){
		Boolean exists = false;
		for(int i=0; i < edges.size(); ++i){
			if ((edges.get(i).get(0) == v1 && edges.get(i).get(1) == v2) || (edges.get(i).get(0) == v2 && edges.get(i).get(1) == v1)){
				exists = true;
			}
		}
		return exists;
	}
	private Boolean addEdge(){
		ArrayList<Integer> tempList;
		int i = randInt(1, this.vertexNum);
		int j;
		do{
			j = randInt(1, this.vertexNum);
		} while (i == j);
		Boolean isSuccess = false;
		if (!isEdge(i, j)){
			isSuccess = true;
			tempList = new ArrayList<Integer>();
			tempList.add(i);
			tempList.add(j);
			this.edges.add(tempList);
		}
		return isSuccess;
	}
	private void AddUnusedEdges(){
		if (this.edgeNum + 1 > this.vertexNum){
			int diff = this.edgeNum - this.vertexNum + 1;
			Boolean isAdded;
			for (int i=0; i < diff; ++i){
				isAdded  = false;
				do{
					isAdded = addEdge();
				} while (isAdded == false);
			}
			
		}
	}
	
	// warunki: edgeNum >= vertexNum && edgeNum <= getMaxEdgesValue(vertexNum);
	
	
	
}
