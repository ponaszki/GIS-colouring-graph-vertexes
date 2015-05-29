package model;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		if(args.length <1){
			System.err.println("Za malo argumentow");
		    
			return;
		}else if(args.length ==1){
			ReaderCsv reader = new ReaderCsv();
			WriterCsv writer = new WriterCsv();
			try {
				String path = new String(args[0]);
				//String path = new String("");
				UndirectedGraph graph = reader.readTXT(path);
				UndirectedGraph graph2 = reader.readTXT(path);
				AlgorithmSM asm = new AlgorithmSM(graph);
				AlgorithmLF alf = new AlgorithmLF(graph2);
				asm.process();
				alf.process();
				String outPathASM = null, outPathALF = null;
				outPathASM = writer.makeOutPathFromInPath(path, "SM");
				outPathALF = writer.makeOutPathFromInPath(path, "LF");
				writer.write(outPathASM, graph);
				writer.write(outPathALF, graph2);
	//			System.out.println(asm);
	//			System.out.println(alf);
				
			} catch (IOException e) {	
				e.printStackTrace();
				System.err.println("Nieprawidłowe wczytanie");
				return;
			}
			
		}
		System.out.println("Zaczete");

	}

}