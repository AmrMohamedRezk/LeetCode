
public class LeetCode_189_Rotate_Array {
    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
    	reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public static void reverse(int [] nums,int i,int j){
    	while(i<j){
    		int temp = nums[i];
    		nums[i] = nums[j];
    		nums[j] = temp;
    		i++;
    		j--;
    	}
    }
    public static void main(String[] args) {
		rotate(new int [] {1,2,3,4,5,6,7}, 3);
	}
}
