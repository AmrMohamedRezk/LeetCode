
public class LeetCode_67_Add_Binary {
    public static String addBinary(String a, String b) {
     int overflow = 0;
     StringBuilder result = new StringBuilder();
     int length = Math.max(a.length(), b.length());
     for(int i=0;i<length;i++)
     {
    	 int add = 0;
    	 add+=overflow;
    	 if(a.length()-i-1 >=0)
    		 add+=(a.charAt(a.length()-i-1)-'0');
    	 if(b.length()-i-1 >=0)
    		 add+=(b.charAt(b.length()-i-1)-'0');
    	 result.append(add%2);
    	 overflow = add/2;
     }
     if(overflow >0)
    	 result.append(overflow);
     return result.reverse().toString();
    }
    public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));
	}
}
