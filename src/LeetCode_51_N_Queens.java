import java.util.ArrayList;
import java.util.List;

public class LeetCode_51_N_Queens {
	public static List<String[]> solveNQueens(int n) {
		int[] columnsOfQueens = new int[n];
		List<String[]> result = new ArrayList<String[]>();
		solveNQueens(0, columnsOfQueens, result);
		return result;
	}

	private static void solveNQueens(int index, int[] columnsOfQueens,
			List<String[]> result) {
		if (index == columnsOfQueens.length) {
			String [] array = new String [columnsOfQueens.length];
			for(int i=0;i<columnsOfQueens.length;i++)
			{
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<columnsOfQueens.length;j++)
				{
					if(columnsOfQueens[i]==j)
						sb.append('Q');
					else
						sb.append('.');
				}
				array[i] = sb.toString();
			}
			result.add(array);
			return;
		}
		for(int column=0;column<columnsOfQueens.length;column++)
		{
			columnsOfQueens[index] = column;
				if(isValidMove(index,columnsOfQueens)){
					solveNQueens(index+1, columnsOfQueens, result);
				}
		}
	}

	private static boolean isValidMove(int index, int[] columnsOfQueens) {
		for(int i=0;i<index;i++){
			int diff = Math.abs(columnsOfQueens[i] - columnsOfQueens[index]);
			 if (diff == 0 || diff == index - i) 
				 return false;
			
		}
		return true;
	}
	public static void main(String[] args) {
		solveNQueens(4);
	}
}
