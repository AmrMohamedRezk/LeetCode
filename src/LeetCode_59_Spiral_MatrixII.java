public class LeetCode_59_Spiral_MatrixII {
	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int num = 1;
		for (int layer = 0; layer < n / 2; layer++) {
			for (int i = layer; i < n - layer - 1; i++)
				result[layer][i] = num++;
			for (int i = layer; i < n - layer - 1; i++)
				result[i][n - layer - 1] = num++;
			for (int i = n - layer - 1; i > layer; i--)
				result[n - layer - 1][i] = num++;
			for (int i = n - layer - 1; i > layer; i--)
				result[i][layer] = num++;

		}
		if(n%2==1)
			result[n/2][n/2]=num;
		return result;
	}

	public static void main(String[] args) {
		generateMatrix(4);
	}

}
