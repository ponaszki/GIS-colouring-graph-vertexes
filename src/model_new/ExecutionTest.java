package model_new;
import java.io.FileWriter;
import java.io.IOException;
public class ExecutionTest {
	private String pathStart;
	private int vertexNum;
	private int edgeNum;
	private SetTimer timer;
	private long durationSM;
	private long durationLF;
	private GenerateGraphInput graph;
	private static final String DELIMITER = ";";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	public ExecutionTest(int v, int e, String pathStart){
		// pathString = "C:\\studia\\GIS\\projekt\\GIS-colouring-graph-vertexes\\testFiles\\"
		this.vertexNum = v;
		this.edgeNum = e;
		this.pathStart = pathStart;
		GenerateGraphInput();
		ColorGraph();
		WriteInputGraphToCsv();
	}
	public long GetDurationLF(){
		return this.durationLF;
	}
	public long GetDurationSM(){
		return this.durationSM;
	}
	private void StartTimer(){
		this.timer = new SetTimer();
	}
	private long EndTimer(){
		long duration = this.timer.getDuration()/1000000;
		return duration;
	}
	private void GenerateGraphInput(){
		this.graph = new GenerateGraphInput(this.vertexNum, this.edgeNum, this.pathStart);
	}

	private void ColorGraph(){
		String path = this.pathStart + "graph_v" + this.vertexNum + "_e" + this.edgeNum + ".csv";
		ReaderCsv reader = new ReaderCsv();
		WriterCsv writer = new WriterCsv();
		try {
			UndirectedGraph graph = reader.readTXT(path);
			UndirectedGraph graph2 = reader.readTXT(path);
			AlgorithmSM asm = new AlgorithmSM(graph);
			AlgorithmLF alf = new AlgorithmLF(graph2);
			StartTimer();
			// mierze czas wykoniania SM
			asm.process();
			this.durationSM = EndTimer();
			StartTimer();
			alf.process();
			this.durationLF = EndTimer();
			String outPathASM = null, outPathALF = null;
			outPathASM = writer.makeOutPathFromInPath(path, "SM");
			outPathALF = writer.makeOutPathFromInPath(path, "LF");
			writer.write(outPathASM, graph);
			writer.write(outPathALF, graph2);
			System.out.println(asm);
			System.out.println(alf);
			
		} catch (IOException e) {	
			e.printStackTrace();
			System.err.println("Nieprawidlowe wczytanie");
			return;
		}
	}
	
	private void WriteInputGraphToCsv(){
		FileWriter fileWriter = null;
		String fileName = this.pathStart + "times.csv";
		try {
			fileWriter = new FileWriter(fileName, true);
			// write Verticles
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append("SM: ");
			fileWriter.append(Long.toString(this.durationSM));
			fileWriter.append(", LF: ");
			fileWriter.append(Long.toString(this.durationLF));
			fileWriter.append(", E: ");
			fileWriter.append(Integer.toString(this.edgeNum));
			fileWriter.append(", V: ");
			fileWriter.append(Integer.toString(this.vertexNum));
			System.out.println("CSV file TIMES was created successfully !!!");
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
