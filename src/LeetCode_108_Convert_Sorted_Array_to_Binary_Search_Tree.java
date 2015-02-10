public class LeetCode_108_Convert_Sorted_Array_to_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] num) {
		return sortedArrayToBST(num,0,num.length-1);
	}

	private TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if(start>end)
			return null;
		int mid = start+(end-start)/2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start,mid-1);
		root.right = sortedArrayToBST(num, mid+1, end);
		return root;
	}
	
}
