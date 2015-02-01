import java.util.HashMap;

public class LeetCode_76_Minimum_Window_Substring {
	public static String minWindow(String S, String T) {
		int start = 0;
		String minWindow = "";
		HashMap<Character, Integer> tOriginalCharFrequencies = new HashMap<Character, Integer>();
		HashMap<Character, Integer> tLeftCharFrequencies = new HashMap<Character, Integer>();
		HashMap<Character, Integer> sCurrentWindowCharFrequencies = new HashMap<Character, Integer>();
		for (char c : T.toCharArray()) {
			if (tOriginalCharFrequencies.containsKey(c)) {
				int count = tOriginalCharFrequencies.get(c);
				tOriginalCharFrequencies.put(c, count + 1);
				tLeftCharFrequencies.put(c, count + 1);
			} else {
				tOriginalCharFrequencies.put(c, 1);
				tLeftCharFrequencies.put(c, 1);
			}
		}
		for (int i = 0; i < S.length(); i++) {
			char currentCharacter = S.charAt(i);
			if (tOriginalCharFrequencies.containsKey(currentCharacter)) {
				if (sCurrentWindowCharFrequencies.containsKey(currentCharacter))
					sCurrentWindowCharFrequencies
							.put(currentCharacter,
									sCurrentWindowCharFrequencies
											.get(currentCharacter) + 1);
				else
					sCurrentWindowCharFrequencies.put(currentCharacter, 1);
				if (tLeftCharFrequencies.containsKey(currentCharacter)) {
					if (tLeftCharFrequencies.get(currentCharacter) == 1)
						tLeftCharFrequencies.remove(currentCharacter);
					else
						tLeftCharFrequencies.put(currentCharacter,
								tLeftCharFrequencies.get(currentCharacter) - 1);
				}
			}
			while (start < i
					&& (!tOriginalCharFrequencies.containsKey(S.charAt(start)) || sCurrentWindowCharFrequencies
							.get(S.charAt(start)) > tOriginalCharFrequencies
							.get(S.charAt(start)))) {
				if (sCurrentWindowCharFrequencies.containsKey(S.charAt(start)))
					sCurrentWindowCharFrequencies
							.put(S.charAt(start), sCurrentWindowCharFrequencies
									.get(S.charAt(start)) - 1);
				start++;
			}
			if (tLeftCharFrequencies.isEmpty()) {
				if (minWindow.equals("")
						|| (i - start + 1) < minWindow.length())
					minWindow = S.substring(start, i + 1);
			}

		}
		return minWindow;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));
	}
}
