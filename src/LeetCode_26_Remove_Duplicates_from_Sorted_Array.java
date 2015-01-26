public class LeetCode_26_Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] A) {
		int slow = 1;
		int removed = 0;
		for(int i=1;i<A.length;i++){
			if(A[i-1]!=A[i])
				A[slow++]=A[i];
			else
				removed++;
		}
		return A.length-removed;
	}
	public static void main(String[] args) {
		removeDuplicates(new int [] {1,2});
	}
}
