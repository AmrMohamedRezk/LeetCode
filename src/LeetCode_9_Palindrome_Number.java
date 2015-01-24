public class LeetCode_9_Palindrome_Number {
	public static boolean isPalindrome(int x) {
		int copy = x;
		x = x>0 ? x:-x;
		int result = 0;
		while(x>0){
			result = result *10 + x%10;
			x=x/10;
		}
		return result ==copy;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome(98));
	}
}
