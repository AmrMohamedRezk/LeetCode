import java.math.BigInteger;
import java.util.Random;

public class LeetCode_28_Implement_strStr {
	public int strStr(String haystack, String needle) {
		if (needle.length() > haystack.length())
			return -1;
		long hashCode = 0L;
		long RM = 1L;
		long R = 256L;
		long Q = BigInteger.probablePrime(40, new Random()).longValue();
		for (int i = 0; i < needle.length(); i++) {
			hashCode = (R * hashCode + needle.charAt(i)) % Q;
			if (i != 0)
				RM = (RM * R) % Q;
		}
		long currentCode = 0L;
		for (int i = 0; i < needle.length(); i++) {
			currentCode = (R * currentCode + haystack.charAt(i)) % Q;
		}
		if (currentCode == hashCode && check(haystack, needle, 0)) {
			return 0;
		}
		for (int i = needle.length(); i < haystack.length(); i++) {
			currentCode = (currentCode + Q - RM
					* haystack.charAt(i - needle.length()) % Q)
					% Q;
			currentCode = (currentCode * R + haystack.charAt(i)) % Q;
			if (currentCode == hashCode
					&& check(haystack, needle, i - needle.length() + 1)) {
				return i - needle.length() + 1;
			}
		}

		return -1;
	}

	private boolean check(String haystack, String needle, int i) {
		for (int j = 0; j < needle.length(); j++, i++) {
			if (needle.charAt(j) != haystack.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
