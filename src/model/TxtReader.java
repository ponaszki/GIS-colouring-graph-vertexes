package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class TxtReader implements Reader {

	@Override
	public UndirectedGraph readTXT(String filePath) throws IOException {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(filePath));
			
			String line;
			boolean isFirstLine = true;
			ArrayList<Integer> vl = null;
			while((line = inputStream.readLine()) != null){
				if(isFirstLine){
					vl = parseFirstLine(line);
					isFirstLine = false;
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
	
	private ArrayList<Integer> parseFirstLine(String line){
		return new ArrayList<Integer>();
		// TODO finishMe
	}
	private ArrayList<Integer> parseOtherLine(String line){
		return new ArrayList<Integer>();
		// TODO finishMe
	}

}
