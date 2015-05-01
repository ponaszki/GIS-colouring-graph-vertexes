package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class UndirectedGraph {
	private ArrayList<Vertex> nodes;
	public ArrayList<Vertex> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Vertex> nodes) {
		this.nodes = nodes;
	}

	private NeighbourhoodMatrix neighbourhoodMatrix;
	
	public UndirectedGraph(ArrayList<Vertex> vl) {
		this.nodes = vl;
	}
	
	public void setNeighbourhoodMatrix(NeighbourhoodMatrix nm){
		this.neighbourhoodMatrix = nm;
	}
	
	public String toString(){
		String result = new String();
		result = nodes.toString() + "\n"+ neighbourhoodMatrix.toString();
		return result;
	}
}
