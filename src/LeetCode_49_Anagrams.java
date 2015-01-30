import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_49_Anagrams {
	public List<String> anagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> result = new ArrayList<String>();
		for (String current : strs) {
			char[] array = current.toCharArray();
			Arrays.sort(array);
			String sorted = new String(array);
			if (map.containsKey(sorted)) {
				map.get(sorted).add(current);
			} else {
				List<String> value = new ArrayList<String>();
				value.add(current);
				map.put(sorted, value);
			}
		}
		for (List<String> anagrams : map.values()) {
			if (anagrams.size() > 1)
				result.addAll(anagrams);
		}
		return result;
	}
}
