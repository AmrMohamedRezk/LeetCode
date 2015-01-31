import java.util.ArrayList;
import java.util.List;


public class LeetCode_77_Combinations {
	   public static List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        combine(n,k,1,result,new ArrayList<Integer>());
	        return result;
	    }

		private static void combine(int n, int k, int index,
				List<List<Integer>> result, ArrayList<Integer> arrayList) {
			if(arrayList.size()==k){
				result.add(new ArrayList<Integer>());
				for(int i:arrayList)
					result.get(result.size()-1).add(i);
				return;
			}
			if(index>n)
				return;
			arrayList.add(index);
			combine(n, k, index+1, result, arrayList);
			arrayList.remove(arrayList.size()-1);
			combine(n, k, index+1, result, arrayList);
		}
	public static void main(String[] args) {
		combine(4, 2);
	}
}
