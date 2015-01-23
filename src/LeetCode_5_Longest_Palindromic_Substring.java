public class LeetCode_5_Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
	    if(s==null)
	        return null;
	    if(s.equals(""))
	        return "";
		StringBuilder sb = new StringBuilder();
		sb.append('#');
		for (char c : s.toCharArray()) {
			sb.append(c);
			sb.append('#');
		}
		String modified = sb.toString();
		int start = -1;
		int maxLength = 0;
		for (int i = 0; i < modified.length(); i++) {
			int length = 0;
			while ((i - length - 1) >= 0
					&& (i + length + 1) < modified.length()) {
				if (modified.charAt(i - length - 1) == modified.charAt(i
						+ length + 1)) {
					length++;
					if (length > maxLength) {
						maxLength = length;
						start = i;
					}
				} else {
					break;
				}
			}
		}
		StringBuilder middle = new StringBuilder();
		if (modified.charAt(start) != '#') {
			middle.append(modified.charAt(start));
		}
		StringBuilder right = new StringBuilder();
		for (int i = 1; i <maxLength; i++) {
			if (modified.charAt(start + i) != '#') {
				right.append(modified.charAt(start + i));
			}
		}
		StringBuilder left = new StringBuilder(right.subSequence(0, right.length()));
		StringBuilder result = left.reverse();
		result.append(middle);
		result.append(right);
		return result.toString();
	}

}
