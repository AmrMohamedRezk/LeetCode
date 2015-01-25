import java.util.Stack;

public class LeetCode_42_Trapping_Rain_Water {
	public static int trap(int[] A) {
		Stack<Integer> stack = new Stack<Integer>();
		int totalWater = 0;
		for (int i = 0; i < A.length; i++) {
			if ((stack.isEmpty() || A[stack.peek()] > A[i]))
				stack.push(i);
			else {
				while (stack.size() > 1 && A[stack.peek()] <= A[i]) {
					int k = stack.pop();
					int width = (Math.abs(i - stack.peek()) - 1);
					int height = (Math.min(A[i], A[stack.peek()]) - A[k]);
					if(width>0&&height>0)
						totalWater+=width*height;
				}
				stack.push(i);
			}
		}
		return totalWater;
	}

	public static void main(String[] args) {
		trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1});
	}

}
