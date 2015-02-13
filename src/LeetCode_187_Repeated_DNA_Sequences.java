import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LeetCode_187_Repeated_DNA_Sequences {
	public static List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<String>();
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String sub = s.substring(i, i + 10);
			int key = getKey(sub);
			if (nums.containsKey(key)) {
				if (nums.get(key) == 1)
					result.add(sub);
				nums.put(key, nums.get(key) + 1);
			}
			else if (nums.containsKey(key))
				nums.put(key, nums.get(key) + 1);
			else
				nums.put(key, 1);
		}
		return result;
	}

	private static int getKey(String s) {
		int result = 0;
		for (char c : s.toCharArray()) {
			switch (c) {
			case 'A':
				result = result | 0;
				break;
			case 'C':
				result = result | 1;
				break;
			case 'G':
				result = result | 2;
				break;
			case 'T':
				result = result | 3;
				break;
			default:
				break;
			}
			result = result << 2;
		}
		return result;
	}

}
