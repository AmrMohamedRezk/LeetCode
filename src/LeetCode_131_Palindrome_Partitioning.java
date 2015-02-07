import java.util.ArrayList;
import java.util.List;

public class LeetCode_131_Palindrome_Partitioning {
	public static List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		partition(s, 0, result, new ArrayList<String>());
		return result;
	}

	private static void partition(String s, int index,
			List<List<String>> result, ArrayList<String> arrayList) {
		if (index == s.length()) {
			result.add(new ArrayList<String>(arrayList));
			return;
		}
		for (int i = index+1; i <= s.length(); i++) {
			String sub = s.substring(index,i);
			if (isPalindrome(sub)) {
				arrayList.add(sub);
				partition(s, i ,result, arrayList);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		partition("aab");
	}
}
