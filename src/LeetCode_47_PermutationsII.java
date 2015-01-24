import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_47_PermutationsII {
	public static List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		permuteUnique(num, 0, result);
		return result;
	}

	private static void permuteUnique(int[] num, int i,
			List<List<Integer>> result) {
		if (i == num.length) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int current : num) {
				list.add(current);
			}
				result.add(list);
			return;

		}
		for (int j = i; j < num.length; j++) {
			if (!containsDuplicate(num, i, j)) {
				swap(i, j, num);
				permuteUnique(num, i + 1, result);
				swap(i, j, num);
			}
		}
	}

	private static boolean containsDuplicate(int[] arr, int start, int end) {
		for (int i = start; i <= end - 1; i++) {
			if (arr[i] == arr[end]) {
				return true;
			}
		}
		return false;
	}

	private static void swap(int i, int j, int[] num) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;

	}

	public static void main(String[] args) {
		permuteUnique(new int[] { 1,1,2 });
	}

}
