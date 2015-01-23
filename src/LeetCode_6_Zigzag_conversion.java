import java.util.ArrayList;
import java.util.List;


public class LeetCode_6_Zigzag_conversion {
	public String convert(String s, int nRows) {
		StringBuilder[] array = new StringBuilder[nRows];
		for (int i = 0; i < nRows; i++) {
			array[i] = new StringBuilder();
		}
		List<Integer> sequence = new ArrayList<Integer>();
		for(int i = 0 ;i<nRows;i++){
			sequence.add(i);
		}
		for(int i = nRows-2;i>0;i--){
			sequence.add(i);
		}
		int sequenceIndex = 0;
		for (char c : s.toCharArray()) {
			array[sequence.get(sequenceIndex)].append(c);		
			sequenceIndex =(sequenceIndex+1)% sequence.size();
		}
		StringBuilder result = new StringBuilder();
		for (StringBuilder sb : array) {
			result.append(sb.toString());
		}
		return result.toString();
	}
}
