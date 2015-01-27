public class LeetCode_55_Jump_Game {
	public static boolean canJump(int[] A) {
		if (A == null || A.length == 0)
			return true;
		int steps = 1;
		int maxReached = 0;
		for(int i=0;i<A.length;i++){
			steps --;
			if(i+A[i]>maxReached){
				steps = A[i];
				maxReached = i+A[i];
			}
			if(maxReached>=A.length)
				return true;
			if(steps <=0)
				return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(canJump(new int [] {3,2,1,0,4}));
	}
}
