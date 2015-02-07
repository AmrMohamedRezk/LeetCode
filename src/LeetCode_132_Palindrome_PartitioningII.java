
public class LeetCode_132_Palindrome_PartitioningII {
    public static int minCut(String s) {
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            palindrome[i][i] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 2 || palindrome[i + 1][j - 1])
                        palindrome[i][j] = true;
                }
            }
        }
        int[] minCut = new int[s.length() + 1];
        for (int i = s.length(); i >= 0; i--)
            minCut[i] = s.length() - 1 - i;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (palindrome[i][j]) {
                    minCut[i] = Math.min(minCut[i], 1 + minCut[j + 1]);
                }
            }
        }
        return minCut[0];
    }
		
	public static void main(String[] args) {
		minCut("aab");
	}
}
