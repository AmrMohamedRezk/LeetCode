
public class LeetCode_154_Find_Minimum_in_Rotated_Sorted_ArrayII {
    public static int findMin(int[] num) {
    	 if(num == null || num.length==0)  
    	        return 0;  
    	    int start = 0;  
    	    int end = num.length-1;  
    	    int min = num[0];  
    	    while(start<end-1)  
    	    {  
    	        int mid = (start+end)/2;  
    	        if(num[start]<num[mid])  
    	        {  
    	            min = Math.min(num[start],min);  
    	            start = mid+1;  
    	        }  
    	        else if(num[start]>num[mid])  
    	        {  
    	            min = Math.min(num[mid],min);  
    	            end = mid-1;  
    	        }  
    	        else  
    	        {  
    	            start++;  
    	        }  
    	    }  
    	    min = Math.min(num[end],min);  
    	    min = Math.min(num[start],min);  
    	    return min;  
    	}  
    public static void main(String[] args) {
		System.out.println(findMin(new int [] {3,3,1,3}));
	}
}
