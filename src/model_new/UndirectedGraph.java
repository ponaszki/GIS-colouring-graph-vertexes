package model_new;

import java.util.ArrayList;

public class UndirectedGraph {
	private ArrayList<Vertex> nodes;
	private NeighbourhoodMatrix neighbourhoodMatrix;
	private ArrayList<Integer> colorSpace;
	
	public UndirectedGraph(){
		nodes = new ArrayList<Vertex>();
		neighbourhoodMatrix = new NeighbourhoodMatrix();
		colorSpace = new ArrayList<Integer>();
	}

	public UndirectedGraph(ArrayList<Vertex> vl) {
		this();
		this.nodes = vl;
		
	}
	
	/**
	 * Funkcja obliczająca liste kolorów (spośród kolorów już istniejących w puli) na które można pokolorować wierzchołek v.
	 * Kolory są wyznaczane na podstawie kryterium przyległości(Kolor v muis być inny niż kolory jego sąsiadów). 
	 * @param v - Wierzchołek, który należy pokolorować
	 * @return Zwraca ArrayList kolorów (spośród kolorów już istniejących w puli) na które można pokolorować wierzchołek v
	 */
	public ArrayList<Integer> getPosibleVertexColors(Vertex v){
		//tworzenie głębokiej kopii przestrzenie już istniejących barw
		ArrayList<Integer> cs = new ArrayList<Integer>();
		for(Integer i : colorSpace){
			cs.add(i);
		}
		//wysnaczenie wierzchołków adjacentnych do v
		ArrayList<Vertex> adjVertexes = this.getAdjacentVertexes(v);
		
		//biore kolejno wszystkie wierzchołki adjacentne i dla każdego 
		for(Vertex vx : adjVertexes){
			//sprawdzam czy jest pokoloworany, jeżeli tak, to
			if(vx.isColoured()){
				//pobieram jego kolor
				int nColor = vx.getColor();
				//i jeżeli ten kolor występuje w przestrzeni kolorów to usuwam go z niej
				//ponieważ nie moge na taki kolor pomalować v.
				for(int i=0; i<cs.size() ; i++){
					if(nColor == cs.get(i)){
						cs.remove(i);
						break;
					}
				}
			}
		}
		
		return cs;
	}
	/**
	 * Funkcja, która uzupełnia listy sąsiedztwa we wszystkich przekazanych wierzchołkach na podstawie przekazanej macierzy sąsiedztwa
	 * @param vertexList - lista wierzchołków w której są uzupełniane listy sąsiedztwa
	 * @param nm - macież sąsiedztwa na podstawie które są uzupełniane listy sąciedztwa
	 */
	public void setAdjacentForAllVertexes(ArrayList<Vertex> vertexList, NeighbourhoodMatrix nm){
		
		for(int row = 0; row< nm.MATRIX_SIZE ; row++){
			for(int col = row ; col< nm.MATRIX_SIZE ; col++){
				if(nm.getElement(row, col)==1){
					Vertex v1=null, v2=null;
					for(Vertex v : vertexList){
						if(v.getMatrixIndex()==col){
							v1 = v;
						}else if(v.getMatrixIndex()==row){
							v2 = v;
						}
					}
					v1.addAdjacentVertex(v2);
					v2.addAdjacentVertex(v1);
				}
			}
		}
	}
	
	/**
	 * Funkcja która uzupełnia listy sąsiedztwa we wszystkich wierzchołkach na podstawie macierzy sąsiedztwa.
	 * W związku z tym konieczne jest wcześniejsze zainicjalizowanie grafu tą macierzą i listą vierzchołków grafu
	 * @throws NullPointerException jeżeli w grafie nie jest zainicjalizowana lista wierzchołków lub macierz sąsiedztwa.
	 */
	public void setAdjacentForAllVertexes() throws NullPointerException{
		if(this.nodes.isEmpty() || this.neighbourhoodMatrix.MATRIX_SIZE==0){
			throw new NullPointerException("Zle zainicjalizowany graf");
		}else{
			setAdjacentForAllVertexes(this.nodes, this.neighbourhoodMatrix);
		}
	}
	
	/**
	 *  Funkcja zwracająca możliwe kolory, na które można pokolorować parę woerzchołków 
	 * @param v1
	 * @param v2
	 * @return
	 */
	public ArrayList<Integer> getPosibleVertexexColors(Vertex v1, Vertex v2){
		ArrayList<Integer> possibleColorsV1=getPosibleVertexColors(v1);
		ArrayList<Integer> possibleColorsV2=getPosibleVertexColors(v2);

		possibleColorsV1.retainAll(possibleColorsV2);
		return possibleColorsV1;
	}
	
	/**
	 * Funkcja dodająca nowy kolor do puli kolorów
	 * @return - wartość int odpowiadająca nowemu kolorowi
	 */
	public int addNewColor() {
		int color = colorSpace.size()+1;
		colorSpace.add(color);
		return color;
	}

	public String toString(){
		String result = new String();
		result = "Nodes:\n" + nodes.toString() + "\nNeigbourhoodMatrix\n"+ neighbourhoodMatrix.toString();
		return result;
	}
	
	/**
	 * Funkcja przeszukująca listę wierzchołków w grafie i i zwracająca referencje 
	 * do tego, który jest usytuowany na indeksie tablicy matrixIndex.
	 * Jest to zabezpieczenie przed sytuacją, w której z pliku został wczytany graf, z 
	 * nie kolejnymi numerami weirzchołków (np: 1,2,3,6,7,8).
	 * @param matrixIndex - index tablicy, dla którego pragniemy znaleźć skorelowany wierzchołek.
	 * @return - wierzchołek o numerze indeksu tablicy matrixIndex
	 */
	public Vertex getNode(int matrixIndex) {
		for(Vertex x : nodes){
			if(x.getMatrixIndex()==matrixIndex){
				return x;
			}
		}
		return null;
	}
	
	/**
	 * Funkcja która znajduje wszystkie adjacentne wierzchołki do wierzchołka v;
	 * @param v - wieszchołek , którego sąsiadów chcemy wyznaczyć
	 * @return - zwraca listę wierzchołków sąsiadujących
	 */
	private ArrayList<Vertex> getAdjacentVertexes(Vertex v){
		return v.getAdjacentVertexes();
	}
	
	public NeighbourhoodMatrix getNeighbourhoodMatrix() {
		return neighbourhoodMatrix;
	}

	public ArrayList<Vertex> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Vertex> nodes) {
		this.nodes = nodes;
	}

	public ArrayList<Integer> getColorSpace() {
		return colorSpace;
	}

	public void setColorSpace(ArrayList<Integer> colorSpace) {
		this.colorSpace = colorSpace;
	}
	
	public void setNeighbourhoodMatrix(NeighbourhoodMatrix nm) {
		this.neighbourhoodMatrix = nm;
		for(Vertex v : this.nodes){
			v.eraseAllAdjacentNodes();
		}
		setAdjacentForAllVertexes();
	}
}
