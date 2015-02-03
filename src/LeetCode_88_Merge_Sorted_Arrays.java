public class LeetCode_88_Merge_Sorted_Arrays {
	public static void merge(int A[], int m, int B[], int n) {
		int last = m+n-1;
		m--;
		n--;
		for(;last>=0&&m>=0&&n>=0;last--){
			if(A[m]>B[n]){
				A[last]=A[m--];
			}else{
				A[last]=B[n--];
			}
		}
		while(last>=0 && n>=0)
			A[last--]=B[n--];
	}
	public static void main(String[] args) {
		int [] A = new int [1];
		int [] B = new int [] {1};
		merge(A, 0, B,1);
	}

}
