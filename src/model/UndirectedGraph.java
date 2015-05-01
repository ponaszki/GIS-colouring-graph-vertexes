package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class UndirectedGraph {
	private ArrayList<Vertex> nodes;
	private NeighbourhoodMatrix neighbourhoodMatrix;

	public NeighbourhoodMatrix getNeighbourhoodMatrix() {
		return neighbourhoodMatrix;
	}

	public ArrayList<Vertex> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<Vertex> nodes) {
		this.nodes = nodes;
	}

	public UndirectedGraph(ArrayList<Vertex> vl) {
		this.nodes = vl;
	}

	public void setNeighbourhoodMatrix(NeighbourhoodMatrix nm) {
		this.neighbourhoodMatrix = nm;
	}

	public String toString(){
		String result = new String();
		result = "Nodes:\n" + nodes.toString() + "NeigbourhoodMatrix\n"+ neighbourhoodMatrix.toString();
		return result;
	}
}
