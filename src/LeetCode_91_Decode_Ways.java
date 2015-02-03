import java.util.Arrays;

public class LeetCode_91_Decode_Ways {
	public static int numDecodings(String s) {
		if (s == null || s.equals(""))
			return 0;
		int[] dp = new int[s.length()];
		Arrays.fill(dp, -1);
		return numDecodings(s, 0, dp);
	}

	private static int numDecodings(String s, int index, int[] dp) {
		if (index == s.length())
			return 1;
		if (dp[index] != -1)
			return dp[index];
		if ((s.charAt(index) == '1' && index + 1 < s.length())
				|| (s.charAt(index) == '2' && index + 1 < s.length() && s
						.charAt(index + 1) <= '6'))
			return dp[index]=numDecodings(s, index + 2,dp) + numDecodings(s, index + 1,dp);
		else if(s.charAt(index)!='0')
			return dp[index]=  numDecodings(s, index + 1,dp);
		else
			return dp[index]=0;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("10"));
	}
}
