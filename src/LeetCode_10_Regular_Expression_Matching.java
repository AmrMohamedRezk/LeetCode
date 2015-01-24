public class LeetCode_10_Regular_Expression_Matching {
	public static boolean isMatch(String s, String p) {
		return isMatch(s, 0, p, 0);
	}

	private static boolean isMatch(String s, int i, String pattern, int j) {
		if (i == s.length() && j == pattern.length())
			return true;
		if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
			while (i < s.length()
					&& (s.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.')) {
				if (isMatch(s, i, pattern, j + 2)) {
					return true;
				}
				i++;
			}
			return isMatch(s, i, pattern, j + 2);
		} else {
			if ((j + 1 <= pattern.length() && pattern.charAt(j) == '.'))
				return isMatch(s, i + 1, pattern, j + 1);
			else {
				if (i < s.length() && j < pattern.length()
						&& s.charAt(i) == pattern.charAt(j))
					return isMatch(s, i + 1, pattern, j + 1);
				else
					return false;
			}
		}
	}

	public static void main(String[] args) {
		/*
		 * isMatch("aa","a") → false isMatch("aa","aa") → true
		 * isMatch("aaa","aa") → false isMatch("aa", "a*") → true isMatch("aa",
		 * ".*") → true isMatch("ab", ".*") → true isMatch("aab", "c*a*b") →
		 * true
		 */
		System.out.println(isMatch("aab", "c*a*b*"));

	}

}
