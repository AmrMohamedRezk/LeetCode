public class LeetCode_34_Search_for_a_Range {
	public static int[] searchRange(int[] A, int target) {
		if (A == null || A.length ==0)
			return null;
		int first = searchFirstOccurence(A, target);
		int second = searchLastOccurence(A, target);
		return new int[] { first, second };
	}

	private static int searchLastOccurence(int[] a, int target) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == a.length - 1 && a[mid] == target)
				return mid;
			if (mid < a.length - 1 && a[mid] == target && a[mid + 1] > target)
				return mid;
			else if (a[mid] <= target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;
	}

	private static int searchFirstOccurence(int[] a, int target) {
		int start = 0;
		int end = a.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid == 0 && a[mid] == target)
				return mid;
			if (mid > 0 && a[mid] == target && a[mid - 1] < target)
				return mid;
			else if (a[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		searchRange(new int []{5, 7, 7, 8, 9, 10}, 8);
	}
}
