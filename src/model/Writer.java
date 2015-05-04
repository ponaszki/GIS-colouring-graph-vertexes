package model;

import java.io.IOException;

public interface Writer {
	/**
	 * Funkcja zapisująca graf do pliku csv w formacie określonym w sparawozdaniu 2
	 * @param path - ścieżka do pliku w którym ma być zapisywany graf g
	 * @param g - graf który ma być zapisany do pliku
	 */
	public void write(String path, UndirectedGraph g) throws IOException;
	public String makeOutPathFromInPath(String path, String algorithmName);
}
