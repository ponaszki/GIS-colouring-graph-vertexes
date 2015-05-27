package model_new;

import java.io.IOException;
import java.util.Set;
public class MainClassTest {

	public static void main(String[] args) {
				String pathStart = "C:\\studia\\GIS\\projekt\\GIS-colouring-graph-vertexes\\testFiles\\";
				// wywolujesz tylko ta klaske, gdzie pierwsze dwa parametry to liczba wierszy i liczba kolumn
				ExecutionTest ex = new ExecutionTest(100, 2200, pathStart);
				System.out.println("Execution time: LF: " + ex.GetDurationLF() + "  SM: " + ex.GetDurationSM());
		}
	}
