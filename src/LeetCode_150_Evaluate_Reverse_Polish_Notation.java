import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class LeetCode_150_Evaluate_Reverse_Polish_Notation {
    public static int evalRPN(String[] tokens) {
     Set<String> operators = new HashSet<String>();
     operators.add("+");
     operators.add("-");
     operators.add("*");
     operators.add("/");
     Stack<String> stack = new Stack<String>();
     for(String token:tokens){
    	 if(operators.contains(token)){
    		 char operator = token.charAt(0);
        	 calculate(stack, stack.pop(),stack.pop(),operator);
    	 }else{
    		 stack.push(token);
    	 }
     }
     return Integer.valueOf(stack.pop());
    }
    private static void calculate(Stack<String> stack,String first,String second,char c){
  		 switch (c) {
			case '+':
				stack.push(String.valueOf(Integer.valueOf(first)+Integer.valueOf(second)));
			break;
			case '-':
				stack.push(String.valueOf(Integer.valueOf(second)-Integer.valueOf(first)));
			break;
			case '/':
				stack.push(String.valueOf(Integer.valueOf(second)/Integer.valueOf(first)));
			break;
			case '*':
				stack.push(String.valueOf(Integer.valueOf(first)*Integer.valueOf(second)));
			break;			
			}
    }
    public static void main(String[] args) {
		evalRPN(new String [] {"4", "13", "5", "/", "+"});
	}
}
