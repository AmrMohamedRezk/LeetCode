
public class LeetCode_27_Remove_Element {
    public int removeElement(int[] A, int elem) {
     int slow = 0;
     for(int i=0;i<A.length;i++){
    	 if(A[i]!=elem)
    		 A[slow++]=A[i];
     }
     return slow;
    }
}
