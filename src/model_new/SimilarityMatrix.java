package model_new;

public class SimilarityMatrix extends model_new.NeighbourhoodMatrix {
	
	public SimilarityMatrix(model_new.NeighbourhoodMatrix nm) {
		super(nm.MATRIX_SIZE);
		createSimilarityMatrix(nm);
	}
	
	private void createSimilarityMatrix(model_new.NeighbourhoodMatrix nm){
		for(int row =0; row<nm.MATRIX_SIZE; row++){
			for(int col =0; col<nm.MATRIX_SIZE; col++){
				if(row==col){
					this.setElement(row, col, 0);			
				}else if(nm.getElement(row, col)==1){
					this.setElement(row, col, -1);
				}else if(nm.getElement(row, col)==0){
					int sum=0;
					for (int k = 0; k<nm.MATRIX_SIZE; k++){
						sum+=nm.getElement(row, k)*nm.getElement(k, col);
					}
					this.setElement(row, col, sum);
				}
			}
		}
		return;
	}
}
