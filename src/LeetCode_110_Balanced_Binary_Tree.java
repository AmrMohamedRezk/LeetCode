public class LeetCode_110_Balanced_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return getHeight(root) == -1 ? false : true;
	}

	private int getHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(left==-1||right==-1)
			return -1;
		if(Math.abs(left-right)>1)
			return -1;
		return Math.max(left, right)+1;
	}

}
