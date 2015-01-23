public class LeetCode_4_Median_of_Two_Sorted_Arrays {
	public double findMedianSortedArrays(int A[], int B[]) {
		if ((A.length + B.length) % 2 != 0)
			return findKthElement(A, 0, A.length - 1, B, 0, B.length - 1,
					(A.length + B.length) / 2);
		else
			return (findKthElement(A, 0, A.length - 1, B, 0, B.length - 1,
					(A.length + B.length) / 2) + findKthElement(A, 0,
					A.length - 1, B, 0, B.length - 1, (A.length + B.length) / 2 - 1)) *0.5;
	}

	public int findKthElement(int[] a, int startA, int endA, int[] b,
			int startB, int endB, int k) {
		int lengthA = endA - startA + 1;
		int lengthB = endB - startB + 1;
		if (lengthA == 0)
			return b[startB + k];
		if (lengthB == 0)
			return a[startA + k];
		if (k == 0)
			return a[startA] < b[startB] ? a[startA] : b[startB];
		int midA = k * lengthA / (lengthA + lengthB);
		int midB = k - midA - 1;
		midA = startA + midA;
		midB = startB + midB;
		if (a[midA] > b[midB]) {
			k = k - (midB - startB + 1);
			endA = midA;
			startB = midB + 1;
		} else {
			k = k - (midA - startA + 1);
			endB = midB;
			startA = midA + 1;
		}
		return findKthElement(a, startA, endA, b, startB, endB, k);
	}
}
