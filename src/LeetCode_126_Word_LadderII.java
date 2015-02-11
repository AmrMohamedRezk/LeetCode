import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode_126_Word_LadderII {

	public static List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (dict.size() == 0)
			return result;
		int minLength = getMinLength(start, end, dict);
		dfs(start, end, dict, result, new HashSet<String>(), minLength, new ArrayList<String>());
		return result;
	}
	private static void dfs(String start,String end,Set<String> dict,List<List<String>> result,Set<String> visited,int min,List<String> list){
		if(visited.size()==min && start.equals(end)){
			result.add(new ArrayList<String>(list));
			result.get(result.size()-1).add(end);
			return;
		}else if(visited.size()==min)
			return;
		visited.add(start);
		list.add(start);
		for (int i = 0; i < start.length(); i++) {
			for (int j = 'a'; j <= 'z'; j++) {
				char[] array = start.toCharArray();
				array[i] = (char) j;
				String next = new String(array);
				if(!visited.contains(next)&&dict.contains(next))
				{
					dfs(next, end, dict, result, visited, min, list);
				}
			}
		}
		list.remove(list.size()-1);
		visited.remove(start);
	}

	private static int getMinLength(String start, String end, Set<String> dict) {
		Queue<String> currentLevel = new LinkedList<String>();
		Queue<String> nextLevel = new LinkedList<String>();
		Set<String> used = new HashSet<String>();
		used.add(start);
		currentLevel.add(start);
		int level = 0;
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
		return level + 1;
	}

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("hit");
		set.add("cog");
		set.add("log");
		set.add("lot");
		set.add("dog");
		set.add("dot");
		set.add("hot");
		System.out.println(findLadders("hit", "cog", set));
	}
}
