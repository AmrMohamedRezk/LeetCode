
public class LeetCode_63_Unique_PathsII {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int [] [] paths = new int [obstacleGrid.length][obstacleGrid[0].length];
    	for(int i=0;i<obstacleGrid.length;i++){
    		if(obstacleGrid[i][0]!=1)
    			paths[i][0]=1;
    		else
    			break;
    	}
    	for(int i=0;i<obstacleGrid[0].length;i++){
    		if(obstacleGrid[0][i]!=1)
    			paths[0][i]=1;
    		else
    			break;
    	}
    	for(int i=1;i<obstacleGrid.length;i++){
    		for(int j=1;j<obstacleGrid[0].length;j++){
    			if(obstacleGrid[i][j]!=1){
    				paths[i][j]=paths[i-1][j]+paths[i][j-1];
    			}
    		}
    	}
    	return paths[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
    public static void main(String[] args) {
	uniquePathsWithObstacles(new int [][]{new int [] {0,0},new int [] {1,1},new int [] {0,0}});	
	}
}
