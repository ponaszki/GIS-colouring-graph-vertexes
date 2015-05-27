package model_new;


public class NeighbourhoodMatrix {
	public int MATRIX_SIZE = 0;
	private int matrix[][];

	public NeighbourhoodMatrix() {
		MATRIX_SIZE=0;
		this.matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
	}
	public NeighbourhoodMatrix(int size) {
		MATRIX_SIZE = size;
		this.matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
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
	public void setElement(int row, int col, int value) throws ArrayIndexOutOfBoundsException{
		try{
			this.matrix[row][col] = value;
		}catch(ArrayIndexOutOfBoundsException e){
			throw e;
		}
	}
	
	public String toString(){
		String result = new String();
		result += "{\n";
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
