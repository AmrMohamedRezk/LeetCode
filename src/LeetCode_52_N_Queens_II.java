
public class LeetCode_52_N_Queens_II {
	private static int count = 0;
    public static int totalNQueens(int n) {
    	int [] columnsOfQueens = new int [n];
    	 countQueens(0,columnsOfQueens);   
    	 return count;
    }

	private static void countQueens(int index, int [] columnsOfQueens) {
		if(index ==columnsOfQueens.length){
			count++;
			return;
		}
		for(int column=0;column<columnsOfQueens.length;column++){
			columnsOfQueens[index]=column;
			if(isValid(index,columnsOfQueens))
				 countQueens(index+1, columnsOfQueens);
		}
	}

	private static boolean isValid(int index, int[] columnsOfQueens) {
		for(int i=0;i<index;i++)
		{
			int diff = Math.abs(columnsOfQueens[index]-columnsOfQueens[i]);
			if(diff==0||diff == index - i)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(totalNQueens(2));
	}
}
