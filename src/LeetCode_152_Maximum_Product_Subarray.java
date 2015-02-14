public class LeetCode_152_Maximum_Product_Subarray {
	public static int maxProduct(int[] A) {
		int maxProd = Integer.MIN_VALUE;
		int prod = 1;
		for (int i = 0; i < A.length; i++) {
			prod = prod * A[i];
			maxProd = Math.max(maxProd, prod);
			if (A[i] == 0)
				prod = 1;
		}

		prod = 1;
		for (int i = A.length - 1; i >= 0; i--) {
			prod = prod * A[i];
			maxProd = Math.max(maxProd, prod);
			if (A[i] == 0)
				prod = 1;
		}

		return maxProd;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));

	}
}
