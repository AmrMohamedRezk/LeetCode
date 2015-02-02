
public class LeetCode_74_Search_a_2D_Matrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null ||matrix.length==0)
    		return false;
    	int row = 0;
    	int column = matrix[0].length-1;
    	while(row<matrix.length&&column>=0){
    		if(matrix[row][column]==target)
    			return true;
    		else if(matrix[row][column]<target){
    			row++;
    		}else{
    			column--;
    		}
    	}
    	return false;   
    }
    public static void main(String[] args) {
		searchMatrix(new int [][]{new int [] {1,3}}, 1);
	}
    
}
