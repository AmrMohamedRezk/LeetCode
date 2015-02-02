public class LeetCode_73_Set_Matrix_Zeroes {
	public static void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		boolean row = false;
		boolean column = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				column = true;
				break;
			}
		}
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				row = true;
				break;
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = matrix.length - 1; i >0; i--) {
			for (int j = matrix[i].length - 1; j > 0; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (row) {
			for (int i = 0; i < matrix[0].length; i++)
				matrix[0][i] = 0;
		}
		if (column) {
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		}
	}

	public static void main(String[] args) {
		setZeroes(new int[][] { new int[] {1,1,1 },
				new int[] { 0,1,2}});
	}
}
