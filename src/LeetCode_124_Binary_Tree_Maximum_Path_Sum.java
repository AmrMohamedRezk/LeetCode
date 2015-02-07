public class LeetCode_124_Binary_Tree_Maximum_Path_Sum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	 static int max;

	public static int maxPathSum(TreeNode root) {
		if(root==null)
			max = 0;
		else
			max = root.val;
		findMax(root);
		return max;
	}

	private static int findMax(TreeNode node) {
		if (node == null)
			return 0;

		int left = Math.max(findMax(node.left), 0);
		int right = Math.max(findMax(node.right), 0);

		max = Math.max(node.val + left + right, max);

		return node.val + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(2);
		TreeNode two = new TreeNode(-1);
		TreeNode three = new TreeNode(-2);
		one.left = two;
		one.right = three;

	}
}
