public class LeetCode_7_Reverse_Integer {
	private static final int OVERFLOW = 214748364;

	public static int reverse(int x) {
		boolean flag = x > 0 ? false : true;
		x = x > 0 ? x : -x;
		int result = 0;
		while (x > 0) {
			if(result > OVERFLOW)
				return 0;
			if(result ==OVERFLOW &&x%10>7)
				return 0;
			result = result * 10 + x % 10;
			x = x / 10;
		}
		return flag == true ? -result : result;
	}

	public static void main(String[] args) {
		System.out.println(reverse(1463847412));
	}
}
