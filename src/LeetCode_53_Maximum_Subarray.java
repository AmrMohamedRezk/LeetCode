public class LeetCode_53_Maximum_Subarray {
	public int maxSubArray(int[] A) {
		int maxSum = Integer.MIN_VALUE;
		int maxSoFar = 0;
		for (int i = 0; i < A.length; i++) {
			if (maxSoFar < 0)
				maxSoFar = 0;
			maxSoFar += A[i];
			if (maxSum < maxSoFar)
				maxSum = maxSoFar;
		}
		return maxSum;
	}
}
