public class LeetCode_79_Word_Search {
	public static boolean exist(char[][] board, String word) {
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (exist(i, j, board, word, 0, used))
						return true;
				}
			}
		}
		return false;
	}

	private static boolean exist(int i, int j, char[][] board, String word,
			int index, boolean[][] used) {
		if (!used[i][j] && board[i][j] == word.charAt(index)) {
			if (index+1 == word.length())
				return true;
			used[i][j] = true;
			if (validMove(i - 1, j, board)&&exist(i - 1, j, board, word, index + 1, used))
				return true;
			if (validMove(i + 1, j, board)&&exist(i + 1, j, board, word, index + 1, used))
				return true;
			if (validMove(i, j - 1, board)&&exist(i, j - 1, board, word, index + 1, used))
				return true;
			if (validMove(i, j + 1, board)&&exist(i, j +1, board, word, index + 1, used))
				return true;
			used[i][j] = false;
		}
		return false;
	}

	private static boolean validMove(int i, int j, char[][] board) {
		return i >= 0 && i < board.length && j >= 0 && j < board[i].length;
	}

	public static void main(String[] args) {
//		exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' },
//				new char[] { 'S', 'F', 'C', 'S' },
//				new char[] { 'A', 'D', 'E', 'E' } }, "ABCCED");
		exist(new char [][]{new char[]{'A'}}, "A");
	}

}
