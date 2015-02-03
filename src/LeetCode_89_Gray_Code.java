import java.util.ArrayList;
import java.util.List;


public class LeetCode_89_Gray_Code {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>((int)Math.pow(2, n));
    	result.add(0);
        for(int i=0;i<n;i++){
        	int size = result.size();
        	for(int j=size-1;j>=0;j--){
        		result.add(result.get(j)+size);
        	}
        }
    	return result;
    }
}
