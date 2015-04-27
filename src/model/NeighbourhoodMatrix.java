package model;


public class NeighbourhoodMatrix {
	public int COLUMNS_NUMBER = 0;
	public int ROWS_NUMBER = 0;
	private int matrix[][];

	public NeighbourhoodMatrix() {
		COLUMNS_NUMBER = 0;
		ROWS_NUMBER = 0;
		this.matrix = new int[COLUMNS_NUMBER][ROWS_NUMBER];
	}
	public NeighbourhoodMatrix(int size) {
		COLUMNS_NUMBER = size;
		ROWS_NUMBER = size;
		this.matrix = new int[COLUMNS_NUMBER][ROWS_NUMBER];
	}
	public NeighbourhoodMatrix(int cols, int rows) {
		COLUMNS_NUMBER = cols;
		ROWS_NUMBER = rows;
		this.matrix = new int[COLUMNS_NUMBER][ROWS_NUMBER];
	}
	
	
	//getters
	public int getElement(int row, int col) throws ArrayIndexOutOfBoundsException{
		try{
			return this.matrix[row][col];
		}catch(ArrayIndexOutOfBoundsException e){
			throw e;
		}
	}
	
	//setters
	public void setElement(int row, int col, int vertexNumber) throws ArrayIndexOutOfBoundsException{
		try{
			this.matrix[row][col] = vertexNumber;
		}catch(ArrayIndexOutOfBoundsException e){
			throw e;
		}
	}
	
	public String toString(){
		String result = new String();
		result += "{";
		for(int [] row : matrix){
			result += "{";
			int count = 0;
			for(int elem : row){
				result += elem;
				if(count != row.length-1){
					result += ",";
				}
				count++;
			}
			result += "}\n";
		}
		result += "}";
		return result;
	}
}
