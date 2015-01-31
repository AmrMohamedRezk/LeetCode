import java.util.ArrayList;
import java.util.List;

public class LeetCode_68_Text_Justification {
	public static List<String> fullJustify(String[] words, int L) {
		List<List<StringBuilder>> lines = new ArrayList<List<StringBuilder>>();
		int currentLength = 0;
		List<Integer> lineLength = new ArrayList<Integer>();
		for (String currentWord : words) {
			if (currentLength == 0
					|| currentLength + 1 + currentWord.length() > L) {
				lines.add(new ArrayList<StringBuilder>());
				lineLength.add(currentWord.length());
				currentLength = currentWord.length();
			} else {
				currentLength = currentLength + 1 + currentWord.length();
				lineLength.set(lineLength.size() - 1, currentLength);
			}
			lines.get(lines.size() - 1).add(new StringBuilder(currentWord));
		}
		List<String> result = new ArrayList<String>();
		for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
			int currentlineLength = lineLength.get(lineIndex);
			int wordIndex = 0;
			if (lineIndex == lines.size() - 1) {
				while (currentlineLength < L) {
					lines.get(lineIndex).get(lines.get(lineIndex).size()-1).append(' ');
					currentlineLength++;
				}
			} else {
				while (currentlineLength < L) {
					lines.get(lineIndex).get(wordIndex).append(' ');
					wordIndex = (wordIndex + 1)
							% (Math.max(1, lines.get(lineIndex).size() - 1));
					currentlineLength++;
				}
			}
			StringBuilder line = new StringBuilder();
			int i = 0;
			for (; i < lines.get(lineIndex).size() - 1; i++) {
				line.append(lines.get(lineIndex).get(i));
				line.append(' ');
			}
			line.append(lines.get(lineIndex).get(i));
			result.add(line.toString());
		}
		return result;
	}

	public static void main(String[] args) {
		fullJustify(new String[] { "What", "must", "be", "shall", "be." }, 12);
	}
}
