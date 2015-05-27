package model_new;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerateGraphInput {
	private ArrayList<Integer> vertexes;
	private ArrayList<ArrayList<Integer>> edges; 
//	private int vertexNum;
//	private int edgeNum; 
	private int maxEdges;
	private static final String DELIMITER = ";";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	public GenerateGraphInput(int vertexesNum, int edgesNum, String pathStart){
		// @pathStart = "C:\\studia\\GIS\\projekt\\GIS-colouring-graph-vertexes\\testFiles\\";
		ConsistentGraphGenerator graphGen = new ConsistentGraphGenerator(vertexesNum, edgesNum);
		this.vertexes = new ArrayList<Integer>(graphGen.GetVertexes());
		this.edges = new ArrayList<ArrayList<Integer>>(graphGen.GetEdges());
		this.maxEdges = graphGen.getMaxEdgesValue(vertexesNum);
		WriteInputGraphToCsv(vertexesNum, edgesNum, pathStart);
	}
	public int getMaxEdges(){
		return this.maxEdges;
	}
	private void WriteInputGraphToCsv(int vertexesNum, int edgesNum, String pathStart){
		FileWriter fileWriter = null;
		String fileName = pathStart + "graph_v" + vertexesNum + "_e" + edgesNum + ".csv";
		try {
			fileWriter = new FileWriter(fileName);
			// write Verticles
			fileWriter.append("W");
			fileWriter.append(DELIMITER);
			for(int i=0; i < this.vertexes.size(); ++i){
				fileWriter.append(Integer.toString(this.vertexes.get(i)));
				if (i != this.vertexes.size() - 1){
					fileWriter.append(DELIMITER);
				}
				else{
					fileWriter.append(NEW_LINE_SEPARATOR);
				}
			}
			// write Edges
			for(int i=0; i < this.edges.size(); ++i){
				fileWriter.append("K");
				fileWriter.append(DELIMITER);
				fileWriter.append(Integer.toString(this.edges.get(i).get(0)));
				fileWriter.append(DELIMITER);
				fileWriter.append(Integer.toString(this.edges.get(i).get(1)));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("CSV file was created successfully !!!");
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
		e.printStackTrace();
		}finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			}catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		
		}
	}

}
