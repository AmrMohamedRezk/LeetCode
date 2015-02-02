public class LeetCode_98_Validate_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
	}

	private static boolean isValidBST(long minValue, long maxValue, TreeNode root) {
		if (root == null)
			return true;
		if (!(root.val > minValue && root.val < maxValue))
			return false;
		else
			return isValidBST(minValue, root.val, root.left)
					&& isValidBST(root.val, maxValue, root.right);
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(Integer.MIN_VALUE);
		TreeNode two = new TreeNode(Integer.MAX_VALUE);
		one.right = two;
		isValidBST(one);

	}
}
