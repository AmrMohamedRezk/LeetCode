import java.util.Arrays;

public class LeetCode_31_Next_Permutation {
	public static void nextPermutation(int[] num) {
	    if(num==null ||num.length == 0||num.length ==1)
	        return ;
		int i = num.length - 1;
		for (; i > 0; i--) {
			if (num[i] > num[i - 1]) {
				i--;
				break;
			}
		}
		if (num[i] >= num[i + 1]) {
			Arrays.sort(num);
			return;
		}
		int j = num.length - 1;
		for (; j > i; j--) {
			if (num[j] > num[i])
				break;
		}
		swap(i, j, num);
		reverse(i + 1, num.length - 1, num);
	}

	private static void swap(int i, int j, int[] num) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

	private static void reverse(int start, int end, int[] num) {
		while (start < end) {
			swap(start++, end--, num);
		}
	}

	public static void main(String[] args) {
		int[] num = new int[] {2,3,1 };
		nextPermutation(num);
		System.out.println();
	}
}
