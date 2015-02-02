import java.util.Stack;


public class LeetCode_84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
        if(height ==null ||height.length==0)
       	 return 0;
        int maxArea = 0;
        int i=0;
        Stack<Integer> stack = new Stack<Integer>();
        while(i<height.length){
        	if(stack.isEmpty()||height[stack.peek()]>=height[i])
        		stack.push(i++);
        	else{
        		maxArea = Math.max(maxArea, height[stack.pop()]*(stack.isEmpty()? i:i-stack.peek()-1));
        	}
        }
        while(!stack.isEmpty())
    		maxArea = Math.max(maxArea, height[stack.pop()]*(stack.isEmpty()? i:i-stack.peek()-1));
        return maxArea;
    }
}
