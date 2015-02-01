
public class LeetCode_81_Search_in_Rotated_Sorted_ArrayII {
    public static boolean search(int[] A, int target) {
    	return search(A,target,0,A.length-1);
    }
    private static boolean search(int [] A,int target,int start,int end){
    	if(start>end)
    		return false;
    	int mid = start+ (end-start)/2;
    	if(A[mid]==target)
    		return true;
    	//First half sorted
    	if(A[start]<A[mid]){
    		if(A[start]<=target && target<A[mid])
    			return search(A,target,start,mid-1);
    		else
    			return search(A,target,mid+1,end);
    	}
    	//Second half sorted
    	else if(A[end]>A[mid]){
    		if(A[end]>=target && target>A[mid])
    			return search(A,target,mid+1,end);
    		else
    			return search(A,target,start,mid-1);
    	}else{
    		return search(A,target,start,mid-1) || search(A,target,mid+1,end);
    	}
    }
    
    public static void main(String[] args) {
		System.out.println(search(new int [] {2,2,2,3,4,2},5));
	}
}
