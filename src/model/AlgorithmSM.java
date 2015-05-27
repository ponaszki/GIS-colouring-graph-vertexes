package model;

import java.util.ArrayList;


public class AlgorithmSM {
	private SimilarityMatrix c;
	private UndirectedGraph graph;
	public AlgorithmSM(UndirectedGraph ug) {
		graph = ug;
	}
	
	public boolean process() throws NullPointerException{
		NeighbourhoodMatrix nm = graph.getNeighbourhoodMatrix();
		if(nm == null){
			throw new NullPointerException(new String("Nacierz sąsiedztwa jest pusta(null)."));
		}
		this.c = new SimilarityMatrix(nm);
		
		System.out.println(this.c);
		
		int p = findMaximalMatrixElement(this.c);
		System.out.println("p= "+p);

		while(p>=0){
			for(int row = 0; row <this.c.MATRIX_SIZE; row++){
				for(int col = 0; col <this.c.MATRIX_SIZE; col++){
					if(c.getElement(row, col)==p){
						Vertex v1 = graph.getNode(row);
						Vertex v2 = graph.getNode(col);
						boolean isV1coloured = v1.isColoured();
						boolean isV2coloured = v2.isColoured();
						if(isV1coloured && isV2coloured){	//oba już pokolorowane
							continue;
						}else if(!isV1coloured && isV2coloured || isV1coloured && !isV2coloured){	//jeden z nich nie pokolorowany
							if(!v1.isColoured()){	//jezeli nie pokolorowany v1
								ArrayList<Integer> pc = graph.getPosibleVertexColors(v1);
								if (!pc.isEmpty()){
									v1.setColor(pc.get(0));
								}
							}else{	//jezeli nie pokolorowany v2
								ArrayList<Integer> pc = graph.getPosibleVertexColors(v2);
								if (!pc.isEmpty()){
									v2.setColor(pc.get(0));
								}
							}
						}else if(!isV1coloured && !isV2coloured){	//oba nie pokolorowane
							ArrayList<Integer> pc = graph.getPosibleVertexexColors(v1, v2);
							if(!pc.isEmpty()){
								v1.setColor(pc.get(0));
								v2.setColor(pc.get(0));
							}else{
								int newC = graph.addNewColor();
								v1.setColor(newC);
								v2.setColor(newC);
							}
						}
					}
				}
			}
			p--;
		}
		
		return true;
	}
	/**
	 * Metoda zwraca maksymalny element macierzy
	 * @return zwraca wartość maksymalnego elementu macierzy.
	 */
	private int findMaximalMatrixElement(SimilarityMatrix m){
		int result = 0;
		for(int row = 0; row <this.c.MATRIX_SIZE; row++){
			for(int col = 0; col <this.c.MATRIX_SIZE; col++){
				if(result < c.getElement(row, col)){
					result = c.getElement(row, col);
				}
			}
		}
		return result;
	}
	
 	public String toString(){
		String result = "SimilarityMatrix:\n";
		if(this.c == null){
			result += "{}\n";
		}else{
			result+= c.toString();
		}
		return result;
	}

	public UndirectedGraph getGraph() {
		return graph;
	}

	public void setGraph(UndirectedGraph g) {
		this.graph = g;
	}
	
}
