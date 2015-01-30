import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_39_Combination_Sum {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum(candidates, target, 0, result,new ArrayList<Integer>());
		return result;
	}

	private static void combinationSum(int[] candidates, int target, int index,
			List<List<Integer>> result,ArrayList<Integer> currentSet) {
		if(target == 0){
			result.add(new ArrayList<Integer>());
			for(int i:currentSet)
				result.get(result.size()-1).add(i);
			Collections.sort(result.get(result.size()-1));
			return;
		}
		if(index==candidates.length)
			return;
		if(target<0){
			return;
		}
		combinationSum(candidates, target, index+1, result, currentSet);
		currentSet.add(candidates[index]);
		combinationSum(candidates, target-candidates[index], index, result, currentSet);
		currentSet.remove(currentSet.size()-1);
	}
	public static void main(String[] args) {
		combinationSum(new int []{2,3,6,7}, 7);
	}
}
