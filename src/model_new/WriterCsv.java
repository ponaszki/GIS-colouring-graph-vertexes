package model_new;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterCsv implements Writer {
	public void write(String path, UndirectedGraph g) throws IOException{
		BufferedWriter outputStream = null;
		try{
			outputStream =new BufferedWriter(new FileWriter(path));
			String firstLine =new String("W;");
			for(Vertex v : g.getNodes()){
				firstLine+= v.getVertexNumber() + ";";
			}
			firstLine.substring(0, firstLine.length()-1);	//usuniecie ostatniego srednika
			firstLine += "\n";
			outputStream.write(firstLine);
			
			NeighbourhoodMatrix nm = g.getNeighbourhoodMatrix();
			for(int row = 0; row <nm.MATRIX_SIZE; row++){
				for(int col = row+1; col <nm.MATRIX_SIZE; col++){
					if(nm.getElement(row, col)==1){
						String edge = new String("K;");
						Vertex v1 = g.getNode(row);
						Vertex v2 = g.getNode(col);
						if(v1.getVertexNumber() < v2.getVertexNumber()){
							edge+=v1.getVertexNumber() + ";" + v2.getVertexNumber() + "\n";
						}else{
							edge+=v2.getVertexNumber() + ";" + v1.getVertexNumber() + "\n";
						}
						outputStream.write(edge);
					}
				}
			}
			
			for(Vertex v : g.getNodes()){
				String vc = new String("W;");
				vc+=v.getVertexNumber() + ";" + v.getColor() + "\n";
				outputStream.write(vc);
			}
			
			String numOfCols = new String();
			numOfCols+=g.getColorSpace().size() + "\n";
			outputStream.write(numOfCols);
		}finally{
			if(outputStream != null){
				outputStream.close();
			}
		}
		
	}
	
	public String makeOutPathFromInPath(String path, String algorithmName){
		String ext = path.substring(path.lastIndexOf(".")+1);
		String pth = path.substring(0,path.lastIndexOf("."));

		pth+= algorithmName + "Out." + ext;
		return pth;
	}
}
