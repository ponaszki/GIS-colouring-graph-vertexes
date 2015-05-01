package model;

public class SMAlgorithm {
	private SimilarityMatrix c;
	public SMAlgorithm(UndirectedGraph ug) {
		c = new SimilarityMatrix(ug.getNeighbourhoodMatrix());
		System.out.println(c);
	}
	public String toString(){
		String result = "SimilarityMatrix:\n" + c.toString();
		return result;
	}
}
