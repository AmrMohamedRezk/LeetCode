public class LeetCode_14_Longest_Common_Prefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return null;
		StringBuilder sb = new StringBuilder();
		int index = 0;
		while (true) {
			String first = strs[0];
			for (String s : strs) {
				if (index >= s.length()
						|| s.charAt(index) != first.charAt(index))
					return sb.toString();
			}
			sb.append(first.charAt(index++));
		}
	}
}
