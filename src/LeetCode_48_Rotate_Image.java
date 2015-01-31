public class LeetCode_48_Rotate_Image {
	public static void rotate(int[][] matrix) {
		for (int layer = 0; layer < matrix.length / 2; layer++) {
			for (int i = layer; i < matrix.length - layer - 1; i++) {
				int first = matrix[layer][i];
				matrix[layer][i] = matrix[matrix.length - i - 1][layer];
				matrix[matrix.length - i - 1][layer] = matrix[matrix.length
						- layer - 1][matrix.length - i - 1];
				matrix[matrix.length - layer - 1][matrix.length - i - 1] = matrix[i][matrix.length
						- layer - 1];
				matrix[i][matrix.length - layer - 1] = first;
			}
		}
	}

	public static void main(String[] args) {
		rotate(new int[][] { new int[] { 1, 2, 3, 4 },
				new int[] { 5, 6, 7, 8 }, new int[] { 9, 10, 11, 12 },
				new int[] { 13, 14, 15, 16 } });
	}
}
