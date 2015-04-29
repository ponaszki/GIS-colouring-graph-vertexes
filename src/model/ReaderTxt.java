package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderTxt implements Reader {

	@Override
	public UndirectedGraph readTXT(String filePath) throws IOException {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(filePath));
			UndirectedGraph ug = null;
			NeighbourhoodMatrix nm = null;
			String line;
			boolean isFirstLine = true;
			ArrayList<Vertex> vl = null;
			while((line = inputStream.readLine()) != null){
				if(isFirstLine){
					vl = parseFirstLine(line);
					isFirstLine = false;				
					ug = new UndirectedGraph(vl);
					nm = new NeighbourhoodMatrix(ug.getNodes().size());
				}else{
					parseOtherLine(line);
					
				}
				
			}
			
		}finally{
			if(inputStream != null){
				inputStream.close();
			}
		}
		
		return null;
	}
	
	private ArrayList<Vertex> parseFirstLine(String line){
		String[] data = line.split(";");
		ArrayList<Vertex> result = new ArrayList<Vertex>(data.length-1);
		
		for(int i = 1; i<data.length; i++){
			result.add(i-1, new Vertex(Integer.parseInt(data[i])));
		}
		return result;
		
	}
	private ArrayList<Vertex> parseOtherLine(String line){
		String[] data = line.split(";");
		ArrayList<Vertex> result = new ArrayList<Vertex>(data.length-1);
		
		for(int i = 1; i<data.length; i++){
			result.add(i-1, new Vertex(Integer.parseInt(data[i])));
		}
		return result;
		
	}

}
