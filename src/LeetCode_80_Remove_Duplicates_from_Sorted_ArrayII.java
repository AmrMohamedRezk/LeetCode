
public class LeetCode_80_Remove_Duplicates_from_Sorted_ArrayII {
    public static int removeDuplicates(int[] A) {
        int slow = 0;
        for(int i=0;i<A.length;i++){
        	if(!(i+2<A.length&&A[i]==A[i+2]))
        		A[slow++]=A[i];
        }
        return slow;
    }
    public static void main(String[] args) {
		removeDuplicates(new int [] {1,1,1,2,2,3});
	}

}
