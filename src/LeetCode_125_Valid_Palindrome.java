
public class LeetCode_125_Valid_Palindrome {
	 public boolean isPalindrome(String s) {
	    	if(s.length()==0)
	    		return true;
	    	StringBuilder sb = new StringBuilder();
	    	for(char c :s.toCharArray()){
	    		if(c>=48 && c<=57)
	    			sb.append(c);
	    		else if(c>=65&&c<=90)
	    			sb.append((char)(c+32));
	    		else if(c>=97&&c<=122)
	    			sb.append(c);
	    	}
	    	s=sb.toString();
	    	int start = 0;
	    	int end = s.length()-1;
	    	while(start<end){
	    		if(s.charAt(start++)!=s.charAt(end--))
	    			return false;
	    	}
	    	return true;
	    }
}
