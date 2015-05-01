package model;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		if(args.length <1){
			System.err.println("Za mało argumentów");
		    
			return;
		}else if(args.length ==1){
			ReaderTxt reader = new ReaderTxt();
			try {
				UndirectedGraph graph = reader.readTXT(new String(args[0]));
				String s = graph.toString();
				System.out.println(graph);
			} catch (IOException e) {	
				e.printStackTrace();
				System.err.println("Nieprawidłowe wczytanie");
				return;
			}
			
		}
		System.out.println("Zaczete");

	}

}
