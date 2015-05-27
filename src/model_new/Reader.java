package model_new;

import java.io.IOException;

public interface Reader {
	public UndirectedGraph readTXT(String filePath) throws IOException;
}
