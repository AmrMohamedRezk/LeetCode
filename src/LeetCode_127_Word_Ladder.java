import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LeetCode_127_Word_Ladder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		 if (dict.size() == 0)  
	            return 0; 
	 
	        LinkedList<String> queue = new LinkedList<String>();
	        LinkedList<Integer> distance = new LinkedList<Integer>();
	 
	        queue.add(start);
	        distance.add(1);
	 
	 
	        while(!queue.isEmpty()){
	            String current = queue.pop();
	            int shortest = distance.pop();
	 
	            if(current.equals(end)){
	                return shortest;
	            }
	 
	            for(int i=0; i<current.length(); i++){
	                char[] currCharArr = current.toCharArray();
	                for(char c='a'; c<='z'; c++){
	                    currCharArr[i] = c;
	 
	                    String nextWord = new String(currCharArr);
	                    if(dict.contains(nextWord)){
	                        queue.add(nextWord);
	                        distance.add(shortest+1);
	                        dict.remove(nextWord);
	                    }
	                }
	            }
	        }
	 
	        return 0;
	}

	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(ladderLength("hit", "cog", set));
	}
}
