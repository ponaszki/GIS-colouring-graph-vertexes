package model;

import java.util.LinkedList;

public class UndirectedGraph {
	private LinkedList<Vertex> nodes;
	private NeighbourhoodMatrix neighbourhoodMatrix;
	
	public UndirectedGraph(LinkedList<Vertex> nodes) {
		this.nodes = nodes;
	}
	
}
