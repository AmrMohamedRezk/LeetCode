
public class LeetCode_64_Minimum_Path_Sum {
    public static int minPathSum(int[][] grid) {
        int[][] minCost = new int [grid.length][grid[0].length];
        minCost[0][0]=grid[0][0];
        for(int i=1;i<minCost.length;i++)
        	minCost[i][0]=minCost[i-1][0]+grid[i][0];
        for(int i=1;i<minCost[0].length;i++)
        	minCost[0][i]=minCost[0][i-1]+grid[0][i];
        for(int i=1;i<minCost.length;i++){
        	for(int j=1;j<minCost[0].length;j++)
        		minCost[i][j]=grid[i][j]+Math.min(minCost[i-1][j],minCost[i][j-1]);
        }
        return minCost[grid.length-1][grid[0].length-1];
    }
    public static void main(String[] args) {
		minPathSum(new int [][]{new int [] {1,2},new int [] {1,1}});
	}
}
