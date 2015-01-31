import java.util.ArrayList;
import java.util.List;

public class LeetCode_54_Spiral_Matrix {
	public static List<Integer> spiralOrder(int[][] array) {
		List<Integer> result = new ArrayList<Integer>();
		if(array ==null||array.length==0)
			return result;
		int row = array.length;
		int column = array[0].length;
		int x = 0;
		int y = 0;
		while(row>0 && column>0){
			if(row==1){
				for(int i=0;i<column;i++)
					result.add(array[x][y++]);
			}else if(column==1){
				for(int i=0;i<row;i++)
					result.add(array[x++][y]);
			}
			if(row==1||column==1)
				break;
			for(int i=0;i<column-1;i++)
				result.add(array[x][y++]);
			for(int i=0;i<row-1;i++)
				result.add(array[x++][y]);
			for(int i=0;i<column-1;i++)
				result.add(array[x][y--]);
			for(int i=0;i<row-1;i++)
				result.add(array[x--][y]);
			x++;
			y++;
			row-=2;
			column-=2;
		}
		return result;
	}
}
