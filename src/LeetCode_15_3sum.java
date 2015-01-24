import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_15_3sum {
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			// handle duplicate
			if (i == 0 || num[i] > num[i - 1]) {
				int start = i + 1;
				int end = num.length - 1;
				while (start < end) {
					int sum = num[i] + num[start] + num[end];
					if (sum == 0) {
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[start]);
						list.add(num[end]);
						result.add(list);
						start++;
						end--;
						//handle duplicate
						while (start < end && num[start] == num[start - 1])
							start++;
						//handle duplicate
						while (start < end && num[end] == num[end + 1])
							end--;
					} else if (sum > 0) {
						end--;
					} else {
						start++;
					}
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		threeSum(new int []{-2,0,1,1,2});
	}
}
