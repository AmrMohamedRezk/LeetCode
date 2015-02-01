import java.util.Stack;

public class LeetCode_85_Maximal_Rectangle {
	public static int maximalRectangle(char[][] matrix) {
		int[] hist = new int[matrix[0].length];
		int maxArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1')
					hist[j] += 1;
				else
					hist[j] = 0;
			}
			maxArea = Math.max(maxArea, maxAreaHistogram(hist));
		}
		return maxArea;
	}

	private static int maxAreaHistogram(int[] hist) {
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while (i < hist.length) {
			if (stack.isEmpty() || hist[stack.peek()] <= hist[i])
				stack.push(i++);
			else {
				maxArea = Math
						.max(maxArea,
								hist[stack.pop()]
										* (stack.isEmpty() ? i : (i
												- stack.peek() - 1)));
			}
		}
		while (!stack.isEmpty())
			maxArea = Math.max(maxArea, hist[stack.pop()]
					* (stack.isEmpty() ? i : (i - stack.peek() - 1)));
		return maxArea;
	}

	public static void main(String[] args) {
		maximalRectangle(new char[][] { new char[] { '1', '1', '0', '0' },
				new char[] { '1', '1', '0', '0' },
				new char [] {'1','1','0','0'},
				new char [] {'1','1','0','0'}});
	}

}
