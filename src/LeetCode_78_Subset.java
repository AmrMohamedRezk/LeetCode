import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode_78_Subset {
	public static List<List<Integer>> subsets(int[] S) {
		List<Integer> empty = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(empty);
		for (int j=S.length-1;j>=0;j--) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> copy = new ArrayList<Integer>(result.get(i));
				copy.add(S[j]);
				Collections.sort(copy, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return (o1-o2);
					}
				});
				result.add(copy);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		subsets(new int [] {1,2});
	}
}
