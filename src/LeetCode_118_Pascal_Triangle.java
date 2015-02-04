import java.util.ArrayList;
import java.util.List;


public class LeetCode_118_Pascal_Triangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0)
        	return result;
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        result.add(first);
        for(int i=1;i<numRows;i++){
        	List<Integer> currentRow = new ArrayList<Integer>();
        	result.add(currentRow);
        	for(int j=0;j<=i;j++){
        		int current = 0;
        		if(j-1>=0)
        			current+=result.get(i-1).get(j-1);
        		if(j<result.get(i-1).size())
        			current+=result.get(i-1).get(j);
        		result.get(result.size()-1).add(current);
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		generate(5);
	}
}
