
public class LeetCode_58_Length_Of_Last_Word {
    public static int lengthOfLastWord(String s) {
    	int currentIndex = s.length()-1;
    	while(currentIndex>=0&&s.charAt(currentIndex)==' ')
    		currentIndex--;
    	int length = 0;
    	while(currentIndex>=0&&s.charAt(currentIndex)!=' ')
    	{
    		length++;
    		currentIndex--;
    	}
    	return currentIndex==0&&s.charAt(0)!=' ' ? 0:length; 
    }
    public static void main(String[] args) {
		System.out.println(lengthOfLastWord(" a"));
	}
}
