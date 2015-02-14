import java.util.HashMap;
import java.util.Map;

public class LeetCode_166_Fraction_to_Reccuring_Decimal {
	public static String fractionToDecimal(int numerator, int denominator) {
		if (denominator == 0)
			return "";
		if (numerator == 0)
			return "0";
		String res = "";
		if (numerator < 0 ^ denominator < 0)
			res = "-";

		long num = Math.abs((long)numerator);
		long denom = Math.abs((long)denominator);

		long intPart = num / denom;
		long left = num % denom;
		res = res.concat(Long.toString(intPart));
		Map<Long, Integer> posMap = new HashMap<Long, Integer>();
		if (left != 0)
			res = res.concat(".");
		while (left != 0) {
			long digit = left * 10 / denom;
			posMap.put(left, res.length());
			res = res.concat(Long.toString(digit));
			left = left * 10 % denom;
			if (posMap.containsKey(left)) {
				int pos = posMap.get(left);
				res = res.substring(0, pos) + "("
						+ res.substring(pos, res.length()) + ")";
				left = 0;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-2147483648, 1));
	}
}
