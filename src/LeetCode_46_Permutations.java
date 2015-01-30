import java.util.ArrayList;
import java.util.List;


public class LeetCode_46_Permutations {
  	 public static List<List<Integer>> permute(int[] num) {
  	 List<List<Integer>> result = new ArrayList<List<Integer>>();
  	 permute(num,0,result);
  	 return result;
  	 }

	private static void permute(int[] num, int index, List<List<Integer>> result) {
		if(index == num.length){
			result.add(new ArrayList<Integer>());
			for(int i:num)
				result.get(result.size()-1).add(i);
		}
		for(int i=index;i<num.length;i++){
			swap(i,index,num);
			permute(num,index+1,result);
			swap(i,index,num);
		}
	}

	private static void swap(int i, int index, int[] num) {
		int temp = num[i];
		num[i]=num[index];
		num[index]=temp;
	}
	public static void main(String[] args) {
		permute(new int [] {1,2,3});
	}
}
