import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LeetCode_90_SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        subsetsWithDup(num,0,result,new ArrayList<Integer>());
        return result;
    }

	private static void subsetsWithDup(int[] num, int index,List<List<Integer>> result,List<Integer> currentSubset) {
		if(index==num.length){
			result.add(new ArrayList<Integer>());
			for(int currentInteger:currentSubset)
				result.get(result.size()-1).add(currentInteger);
			return;
		}
		currentSubset.add(num[index]);
		subsetsWithDup(num, index+1, result, currentSubset);
		currentSubset.remove(currentSubset.size()-1);
		index++;
		while(index<num.length&&num[index-1]==num[index])
			index++;
		subsetsWithDup(num, index, result, currentSubset);		
	}
	public static void main(String[] args) {
		subsetsWithDup(new int [] {1,2,2});
	}

}
