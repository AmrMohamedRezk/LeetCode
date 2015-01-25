import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_40_Combination_SumII {
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combinationSum2(num, target, result, new ArrayList<Integer>(), 0);
		return result;
	}

	private static void combinationSum2(int[] num, int target,
			List<List<Integer>> result, List<Integer> current, int i) {

		if (target < 0)
			return;
		if (target == 0) {
			result.add(new ArrayList<Integer>());
			for (int match : current)
				result.get(result.size() - 1).add(match);
			return;
		}
		if (i == num.length)
			return;
		current.add(num[i]);
		combinationSum2(num, target - num[i], result, current, i + 1);
		current.remove(current.size() - 1);
		i++;
		while (i<num.length&&num[i-1] == num[i])
			i++;
		combinationSum2(num, target, result, current, i);

	}

	public static void main(String[] args) {
		combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);
	}

}
