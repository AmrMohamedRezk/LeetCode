
public class LeetCode_168_Excel_Sheet_Column_Title {
    public static String convertToTitle(int n) {
     StringBuilder sb = new StringBuilder();
     while(n>0){
    	 n--;
    	 int current = n%26;
    	 n=n/26;
    	 sb.append((char)(current+'A'));
     }
     return sb.reverse().toString();
    }
    public static void main(String[] args) {
	convertToTitle(27);	
	}
}
