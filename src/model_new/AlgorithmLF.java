package model_new;

import java.util.ArrayList;
import java.util.Collections;

public class AlgorithmLF implements GraphAlgorithm {
	private UndirectedGraph graph;
	public AlgorithmLF(UndirectedGraph g){
		graph = g;
	}
	@Override
	public boolean process() throws NullPointerException {
		ArrayList<Vertex> vxs = sortVertexes(this.graph.getNodes());
		
		for(Vertex v : vxs){
			ArrayList<Integer> cl = graph.getPosibleVertexColors(v);
			if(cl.size()==0){
				int color = graph.addNewColor();
				v.setColor(color);
			}else{
				v.setColor(cl.get(0));
			}
		}
		return false;
	}
	
	private ArrayList<Vertex> sortVertexes(ArrayList<Vertex> vertexList){
		if(vertexList.get(0).getAdjacentVertexes().size() == 0){
			return null;
		}
		
		Collections.sort(vertexList);
		
		return vertexList;
	}
}
