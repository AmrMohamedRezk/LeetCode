import java.util.HashMap;


public class LeetCode_1_Two_Sum {
    public static int[] twoSum(int[] numbers, int target) {
    	if(numbers ==null)
    		return null;
    	if(numbers.length==0)
    		return null;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i=0;i<numbers.length;i++){
    		if(map.containsKey(target-numbers[i])){
    			return new int [] {map.get(target-numbers[i])+1,i+1};
    		}else{
    			map.put(numbers[i], i);
    		}
    	}
    	return null;
    }
    public static void main(String[] args) {
		System.out.println(twoSum(new int [] {2, 7, 11, 15}, 9));
	}
}
