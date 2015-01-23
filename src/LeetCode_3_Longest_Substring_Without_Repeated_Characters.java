import java.util.HashSet;

public class LeetCode_3_Longest_Substring_Without_Repeated_Characters {
	public static int lengthOfLongestSubstring(String s) {
		if(s==null)
			return 0;
		if(s.length()==0)
			return 0;
		HashSet<Character> set = new HashSet<Character>();
		int start = 0;
		int end =0;
		int maxLength = 0;
		while(end<s.length()){
			if(set.contains(s.charAt(end))){
				while(s.charAt(start)!=s.charAt(end)){
					set.remove(s.charAt(start++));
				}
				set.remove(s.charAt(start++));
			}else{
				set.add(s.charAt(end));
				end++;
				maxLength = Math.max(maxLength, end-start);
			}
		}
		return maxLength;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

}
