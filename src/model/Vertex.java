package model;

import java.util.ArrayList;

public class Vertex {
	private int nodeNumber;
	private ArrayList <Vertex> adjNodes;
	/**
	 * Constructor creating graph node unrelated to other vertexes.
	 * @param number - vertex number
	 */
	public Vertex(int number){
		this.nodeNumber = number;
		adjNodes = new ArrayList<Vertex>();
	}
	
	/**
	 * Constructor create graph node and fills its adjacency list with the one passed in aggument adj.
	 * @param number - vertex number
	 * @param adj - adjacency list
	 */
	public Vertex(int number, ArrayList<Vertex> adj){
		this.nodeNumber = number;
		adjNodes = adj;
	}
	/**
	 * Function that add adjacent vertex to 
	 * @param node
	 */
	public void addNeighbour(Vertex node){
		adjNodes.add(node);
	}
	
	public void setVertexNumber(int number){
		nodeNumber = number;
	}
	
	int getVertex(){
		return this.nodeNumber;
	}
	
	
}
