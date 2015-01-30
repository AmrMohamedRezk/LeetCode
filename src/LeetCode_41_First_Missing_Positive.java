
public class LeetCode_41_First_Missing_Positive {
	public static int firstMissingPositive(int[] A) {
		for(int i=0;i<A.length;){
			if(A[i]!=i+1&&A[i]>0 && A[i]<=A.length-1 &&A[A[i]-1]!=A[i]){
				int temp = A[A[i]-1];
				A[A[i]-1]=A[i];
				A[i]= temp;
			}else{
				i++;
			}
		}
		for(int i=0;i<A.length;i++)
			if(A[i]!=i+1)
				return i+1;
		return A.length+1;
	}
	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int [] {2,1}));
	}
}
