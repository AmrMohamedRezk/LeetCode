
public class LeetCode_11_Container_With_Most_Water {
	public static int maxArea(int[] height) {
		if (height == null)
			return -1;
		if (height.length == 0)
			return -1;
		int maxArea = 0;
		int start = 0;
		int end = height.length - 1;
		while (start < end) {
			maxArea = Math.max(maxArea, Math.min(height[start], height[end])
					* (end - start));
			if(height[start]>height[end])
				end --;
			else
				start++;
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1,  1 }));
	}
}
