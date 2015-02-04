import java.util.ArrayList;
import java.util.List;


public class LeetCode_119_Pascal_TriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> previous = new ArrayList<Integer>();
        List<Integer>  current = new ArrayList<Integer>();
        current.add(1);
        for(int i=1;i<rowIndex;i++){
        	previous = current;
        	current = new ArrayList<Integer>();
        	for(int j=0;j<=i;j++){
        		int currentNum = 0;
        		if(j-1>=0)
        			currentNum+=previous.get(j-1);
        		if(j<previous.size())
        			currentNum+=previous.get(j);
        		current.add(currentNum);
        	}
        }
        return current;
    }
    
    public static void main(String[] args) {
		getRow(5);
	}
}
