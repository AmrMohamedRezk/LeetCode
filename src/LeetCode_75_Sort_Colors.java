
public class LeetCode_75_Sort_Colors {
	public void sortColors(int[] A) {
		int endRed = 0;
		for(int i=0;i<A.length;i++){
			if(A[i]==0){
				int temp = A[i];
				A[i]=A[endRed];
				A[endRed] = temp;
				endRed++;
			}
		}
		int startBlue = A.length-1;
		for(int i=A.length-1;i>=endRed;i++){
			if(A[i]==2){
				int temp = A[i];
				A[i] = A[startBlue];
				A[startBlue] = temp;
				startBlue--;
			}
		}
	}
}
