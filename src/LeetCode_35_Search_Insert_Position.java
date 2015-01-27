public class LeetCode_35_Search_Insert_Position {
	public static int searchInsert(int[] A, int target) {
		int start = 0;
		int end = A.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target)
				return mid;
			if (mid > 0 && A[mid - 1] < target && A[mid] > target)
				return mid;
			if(mid==0 && target<A[mid])
				return 0; 
			if (mid < A.length - 1 && A[mid] < target && A[mid + 1] > target)
				return mid+1;
			if(mid ==A.length-1 && A[mid]<target)
				return A.length;
			if (A[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(searchInsert(new int [] {1,3}, 2));
	}
}
