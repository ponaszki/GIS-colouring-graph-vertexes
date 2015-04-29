package model;

public class NMAlgorithm {
	private int c[][];
	public NMAlgorithm(NeighbourhoodMatrix nm) {
		c = new int[nm.ROWS_NUMBER][nm.COLUMNS_NUMBER];
		createSimilariryMatrixFromBNM(nm);
	}
	
	private void createSimilariryMatrixFromBNM(NeighbourhoodMatrix r){
		for (int row = 0; row < r.COLUMNS_NUMBER ; row++){
			for(int col = 0; col < r.COLUMNS_NUMBER ; col++){
				if(row == col){
					c[row][col] = 0;
				} else if(r.getElement(row, col) == 1){
					c[row][col] = -1;
				} else if (r.getElement(row, col) == 0){
					int suma = 0;
					for(int k =0; k<r.COLUMNS_NUMBER; k++){
						suma+= (r.getElement(row, k)*r.getElement(k, col));
					}
					c[row][col]= suma;
				}
			}
		}
	}
}
