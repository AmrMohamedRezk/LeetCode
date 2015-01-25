import java.util.HashMap;
import java.util.Stack;

public class LeetCode_20_Valid_Parentheses {
	public static boolean isValid(String s) {
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(isOpen(c))
				stack.push(c);
			else if(stack.isEmpty()||map.get(stack.pop())!=c)
				return false;
		}
		return stack.isEmpty();
	}

	private static boolean isOpen(char c) {
		return c == '(' || c == '{' || c == '[';
	}
	public static void main(String[] args) {
		System.out.println(isValid("([)]"));
	}
}
