import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode_18_4sum {
	public static List<List<Integer>> fourSum(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashMap<Integer, List<Pair>> map = new HashMap<Integer, List<Pair>>();
		HashSet<String> visited = new HashSet<String>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
					if (map.containsKey(target - (num[i] + num[j]))) {
						List<Pair> others = map.get(target - (num[i] + num[j]));
						for (Pair other : others) {
							if (other.x != i && other.y != i && other.x != j
									&& other.y != j) {
								ArrayList<Integer> res = new ArrayList<Integer>();
								res.add(num[i]);
								res.add(num[j]);
								res.add(num[other.x]);
								res.add(num[other.y]);
								Collections.sort(res);
								StringBuilder sb = new StringBuilder();
								for (int x : res) {
									sb.append(x);
									sb.append(',');
								}
								if (!visited.contains(sb.toString())) {
									result.add(res);
									visited.add(sb.toString());
								}
							}
					}
					if (map.containsKey(num[i] + num[j]))
						map.get(num[i] + num[j]).add(new Pair(i, j));
					else {
						ArrayList<Pair> list = new ArrayList<Pair>();
						list.add(new Pair(i, j));
						map.put(num[i] + num[j], list);
					}
				}
			}
		}
		return result;
	}

	private static final class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> result = fourSum(new int[] { 1, 0, -1, 0, -2, 2 },
				0);
		System.out.println();
	}
}
