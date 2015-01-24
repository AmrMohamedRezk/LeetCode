public class LeetCode_8_String_to_Integer {
	private static final int OVERFLOW = 214748364;

	public static int atoi(String str) {
		if (str == null || str.equals(""))
			return 0;
		int i = 0;
		for (; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				break;
		}
		if (i == str.length())
			return 0;
		boolean isNegative = false;
		if (str.charAt(i) == '-') {
			isNegative = true;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		int result = 0;
		for (; i < str.length(); i++) {
			if (isNumerical(str.charAt(i))) {
				if (doOverflow(result, str.charAt(i))) {
					return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
				result = result * 10 + str.charAt(i) - '0';
			}else{
				break;
			}
		}
		return isNegative ? -result:result;
	}

	private static boolean doOverflow(int result, char current) {
		return result > OVERFLOW || (result == OVERFLOW && current - '0' > 7);
	}

	private static boolean isNumerical(char c) {
		return c >= '0' && c <= '9';
	}
	public static void main(String[] args) {
		System.out.println(atoi("-1"));
	}
}
