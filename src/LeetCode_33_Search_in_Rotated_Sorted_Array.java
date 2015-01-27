
public class LeetCode_33_Search_in_Rotated_Sorted_Array {
	public static int search(int[] A, int target) {
		if (A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length-1;
		while(start<=end){
			int mid = start + (end-start)/2;
			if(A[mid]==target)
				return mid;
			//first half sorted
			if(A[start]<=A[mid]){
				if(A[start]<=target&&A[mid]>target){
					end =mid-1;
				}else{
					start = mid+1;
				}
			}else{
				if(A[mid]<target&&A[end]>=target){
					start =mid+1;
				}else{
					end = mid-1;
				}

			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		search(new int [] {3,1}, 1);
	}
}
