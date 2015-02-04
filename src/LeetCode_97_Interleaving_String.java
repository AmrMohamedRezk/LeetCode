import java.util.Arrays;

public class LeetCode_97_Interleaving_String {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;
		int dp[][][] = new int[s1.length()][s2.length()][s3.length()];
		for (int i = 0; i < dp.length; i++)
			for (int j = 0; j < dp[i].length; j++)
				Arrays.fill(dp[i][j], -1);
		return isInterleave(s1, 0, s2, 0, s3, 0, dp);
	}

	public boolean isInterleave(String s1, int index1, String s2, int index2,
			String s3, int index3, int[][][] dp) {
		if (index3 == s3.length())
			return true;
		if (index1 < s1.length() && index2 < s2.length()
				&& index3 < s3.length())
			if (dp[index1][index2][index3] != -1)
				return dp[index1][index2][index3] == 0 ? false : true;
		if (index1 < s1.length() && index2 < s2.length()) {
			if (s1.charAt(index1) == s2.charAt(index2)
					&& s1.charAt(index1) == s3.charAt(index3)) {
				dp[index1][index2][index3] = (isInterleave(s1, index1 + 1, s2,
						index2, s3, index3 + 1, dp) || isInterleave(s1, index1,
						s2, index2 + 1, s3, index3 + 1, dp)) ? 1 : 0;
			} else if (s1.charAt(index1) == s3.charAt(index3)) {
				dp[index1][index2][index3] = (isInterleave(s1, index1 + 1, s2,
						index2, s3, index3 + 1, dp)) ? 1 : 0;
			} else if (s2.charAt(index2) == s3.charAt(index3)) {
				dp[index1][index2][index3] = (isInterleave(s1, index1, s2,
						index2 + 1, s3, index3 + 1, dp)) ? 1 : 0;
			} else {
				dp[index1][index2][index3] = 0;
			}
			return dp[index1][index2][index3] == 0 ? false : true;
		}
		while (index1 < s1.length()) {
			if (s1.charAt(index1++) != s3.charAt(index3++)) {
				return false;
			}
		}
		while (index2 < s2.length()) {
			if (s2.charAt(index2++) != s3.charAt(index3++)) {
				return false;
			}
		}
		return true;
	}

}
