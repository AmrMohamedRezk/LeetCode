import java.util.Stack;

public class LeetCode_66_Plus_One {
	public static int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<Integer>();
		int carry = 1;
		for (int i=digits.length-1;i>=0;i--) {
			int result = digits[i] + carry;
			carry = result / 10;
			result = result % 10;
			stack.push(result);
		}
		if (carry > 0)
			stack.push(1);
		int[] result = new int[stack.size()];
		for (int i = 0; i < result.length; i++)
			result[i] = stack.pop();
		return result;
	}
	
	public static void main(String[] args) {
		plusOne(new int [] {1,0});
	}
}
