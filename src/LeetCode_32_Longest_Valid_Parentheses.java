import java.util.Stack;

public class LeetCode_32_Longest_Valid_Parentheses {
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int lastMatched = -1;
		int maxLength = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='('){
				stack.push(i);
			}else{
				if(stack.isEmpty())
					lastMatched = i;
				else{
					stack.pop();
					int matched = -1;
					if(stack.isEmpty()){
					matched = lastMatched;
					}else{
						matched = stack.peek();
					}
					maxLength = Math.max(maxLength, i-matched);
				}
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		longestValidParentheses("))()()(()()()()");
	}
}
