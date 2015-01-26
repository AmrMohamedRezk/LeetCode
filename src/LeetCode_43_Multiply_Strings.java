import java.util.ArrayList;
import java.util.List;

public class LeetCode_43_Multiply_Strings {
	public static String multiply(String num1, String num2) {
		StringBuilder trailingZeros = new StringBuilder();
		List<String> intermediateResults = new ArrayList<String>();
		int maxLength = 0;
		for (int i = num2.length() - 1; i >= 0; i--) {
			StringBuilder intermdiate = new StringBuilder();
			intermdiate.append(trailingZeros.toString());
			trailingZeros.append('0');
			int overflow = 0;
			for (int j = num1.length() - 1; j >= 0; j--) {
				int result = (num2.charAt(i) - '0') * (num1.charAt(j) - '0')
						+ overflow;
				intermdiate.append(result % 10);
				overflow = result / 10;
			}
			if(overflow>0)
				intermdiate.append(overflow);
			maxLength = Math.max(maxLength, intermdiate.length());
			intermediateResults.add(intermdiate.reverse().toString());
		}
		StringBuilder result = new StringBuilder();
		int overflow = 0;
		for(int i=0;i<maxLength;i++)
		{
			int add = 0;
			add+=overflow;
			for(String s : intermediateResults){
				if(s.length()-i-1>=0)
				{
					add+=(s.charAt(s.length()-i-1)-'0');
				}
			}
			result.append(add%10);
			overflow = add / 10;
		}
		if(overflow>0)
			result.append(overflow);
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("253", "0"));
	}
}
