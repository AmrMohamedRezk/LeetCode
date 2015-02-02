
public class LeetCode_73_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
    	if(matrix==null||matrix.length==0)
    		return;
        boolean [] rows = new boolean[matrix.length];
        boolean [] columns = new boolean[matrix[0].length];
        for(int i=0;i<matrix.length;i++)
        {
        	for(int j=0;j<matrix[i].length;i++){
        		if(matrix[i][j]==0){
        			rows[i]=true;
        			columns[j]=true;
        		}
        	}
        }
        for(int i=0;i<matrix.length;i++)
        {
        	for(int j=0;j<matrix[i].length;i++){
        		if(rows[i]||columns[j]){
        			matrix[i][j]=0;
        		}
        	}
        }
        
    }
}
