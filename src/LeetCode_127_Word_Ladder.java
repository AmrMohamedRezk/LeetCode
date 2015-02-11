import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LeetCode_127_Word_Ladder {
	public static int ladderLength(String start, String end, Set<String> dict) {
		 if (dict.size() == 0)  
	            return 0; 
		Queue<String> currentLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		Set<String> used = new HashSet<String>();
		used.add(start);
		currentLevel.add(start);
		int level = 1;
		while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				String current = currentLevel.poll();
				for (int i = 0; i < current.length(); i++) {
					for (int j = 'a'; j <= 'z'; j++) {
						char[] array = current.toCharArray();
						array[i] = (char) j;
						String next = new String(array);
						if (next.equals(end))
							return level + 1;
						if (dict.contains(next) && !used.contains(next)) {
							nextLevel.add(next);
							used.add(next);
						}
					}
				}
			}
			currentLevel = nextLevel;
			nextLevel = new LinkedList<String>();
			level++;

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
