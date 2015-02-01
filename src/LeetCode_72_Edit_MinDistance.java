public class LeetCode_72_Edit_MinDistance {
	public int minDistance(String word1, String word2) {
		int[][] minDistance = new int[word1.length() + 1][word1.length() + 1];
		for (int i = 0; i < minDistance.length; i++)
			minDistance[i][0] = i;
		for (int i = 0; i < minDistance[0].length; i++)
			minDistance[0][i] = i;
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j))
					minDistance[i + 1][j + 1] = minDistance[i - 1][j - 1];
				else
					minDistance[i + 1][j + 1] = Math.min(minDistance[i][j],
							Math.min(minDistance[i][j + 1],
									minDistance[i + 1][j]) + 1);
			}
		}
		return minDistance[word1.length()][word2.length()];
	}
}
