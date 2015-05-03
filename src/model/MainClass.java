package model;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		if(args.length <1){
			System.err.println("Za mało argumentów");
		    
			return;
		}else if(args.length ==1){
			ReaderCsv reader = new ReaderCsv();
			WriterCsv writer = new WriterCsv();
			try {
				String path = new String(args[0]);
				UndirectedGraph graph = reader.readTXT(path);
				System.out.println(graph);
				SMAlgorithm sma = new SMAlgorithm(graph);
				sma.process();
				String outPath = null;
				//nowa sciezka
				outPath = writer.makeOutPathFromInPath(path);
				writer.write(outPath, graph);
				System.out.println(sma);
				
			} catch (IOException e) {	
				e.printStackTrace();
				System.err.println("Nieprawidłowe wczytanie");
				return;
			}
			
		}
		System.out.println("Zaczete");

	}

}