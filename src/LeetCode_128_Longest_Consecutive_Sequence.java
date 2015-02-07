import java.util.HashSet;

public class LeetCode_128_Longest_Consecutive_Sequence {
	public static int longestConsecutive(int[] num) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : num)
			set.add(i);
		int max = 1;
		for(int i:num){
			int count = 1;
			if(set.contains(i)){
				int counter = 1;
				while(set.contains(i-counter)){
					set.remove(i-counter);
					counter++;
					count++;
				}
				counter = 1;
				while(set.contains(i+counter)){
					set.remove(i+counter);
					counter++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out
				.println(longestConsecutive(new int[] { 0,-1 }));
	}
}
