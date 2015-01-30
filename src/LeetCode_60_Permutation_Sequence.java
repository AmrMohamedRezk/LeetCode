
public class LeetCode_60_Permutation_Sequence {
	private static String numbers = "123456789";
	public static String getPermutation(int n, int k) {
		String current = numbers.substring(0, n);
		if(n==1)
			return current;
		int [] factorials = new int [n];
		int [] index = new int [n];
		calculateFactorials(factorials);
		k=k-1;
		k=k%(factorials[n-1]*n);
		for(int i=0;i<n-1;i++)
		{
			int currentIndex=k/factorials[n-i-1];
			k=k-currentIndex*factorials[n-i-1];
			index[i]=currentIndex;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<index.length;i++){
			sb.append(current.charAt(index[i]));
			current = current.substring(0,index[i])+current.substring(index[i]+1,current.length());
		}
		return sb.toString();
	}
	private static void calculateFactorials(int[] factorials) {
		factorials[0]=0;
		factorials[1]=1;
		for(int i=2;i<factorials.length;i++)
			factorials[i]=i*factorials[i-1];
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=4;i++)
			System.out.println(getPermutation(2, i));
	}
	
}
