import java.util.BitSet;

public class LeetCode_36_Valid_Sudoku {
	private static final int SUDOKO_CONSTANT = 9;

	public static boolean isValidSudoku(char[][] board) {
		BitSet[] squares = new BitSet[SUDOKO_CONSTANT];
		BitSet[] columns = new BitSet[SUDOKO_CONSTANT];
		BitSet[] rows = new BitSet[SUDOKO_CONSTANT];
		for(int i=0;i<SUDOKO_CONSTANT;i++)
		{
			squares[i] = new BitSet(SUDOKO_CONSTANT);
			columns[i] = new BitSet(SUDOKO_CONSTANT);
			rows[i] = new BitSet(SUDOKO_CONSTANT);
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != '.') {
					int number = board[i][j] - '0';
					int square = ((i / 3)) * 3 + j / 3;
					if (squares[square].get(number) || columns[j].get(number)
							|| rows[i].get(number)) {
						return false;
					} else {
						squares[square].set(number);
						columns[j].set(number);
						rows[i].set(number);
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		isValidSudoku(new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } });
	}
}
