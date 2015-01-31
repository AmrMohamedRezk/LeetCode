import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_179_Largest_Number {
	public static String largestNumber(int[] num) {
		String[] array = new String[num.length];
		for (int i = 0; i < num.length; i++)
			array[i] = String.valueOf(num[i]);
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String o1o2 = o1 + o2;
				String o2o1 = o2 + o1;
				return -1*o1o2.compareTo(o2o1);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String currentNum : array){
			sb.append(currentNum);
		}
		int start = 0;
		while(start+1<sb.toString().length()&&sb.toString().charAt(start)=='0'&&sb.toString().charAt(start+1)=='0')
			start++;
		return sb.toString().substring(start);
	}

	public static void main(String[] args) {
		largestNumber(new int[] {0,0 });
	}
}
