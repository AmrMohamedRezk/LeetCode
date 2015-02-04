
public class LeetCode_87_Scramble_String {
	   public static boolean isScramble(String s1, String s2) {
	        if (s1.length() != s2.length())
	            return false;
	        if (s1.equals(s2))
	            return true;
	            
	        int L = s1.length();
	        for (int i = 1; i < L; i++) {
	            String s11 = s1.substring(0, i);
	            String s12 = s1.substring(i, L);
	            String s21 = s2.substring(0, i);
	            String s22 = s2.substring(i, L);
	            if (isScramble(s11, s21) && isScramble(s12, s22))
	                return true;
	            s21 = s2.substring(0, L - i);
	            s22 = s2.substring(L - i, L);
	            if (isScramble(s11, s22) && isScramble(s12, s21))
	                return true;
	        }
	        return false;
	   }
	   
	public static void main(String[] args) {
		System.out.println(isScramble("abc","bca"));
	}
}
