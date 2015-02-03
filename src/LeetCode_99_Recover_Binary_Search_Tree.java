public class LeetCode_99_Recover_Binary_Search_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode first = null;
	TreeNode last = null;

	public void recoverTree(TreeNode root) {
		inorderTraverse(root);
		int tmp = first.val;
		first.val = last.val;
		last.val = tmp;
	}

	TreeNode previous = null;

	private void inorderTraverse(TreeNode root) {
		if (root == null)
			return;
		inorderTraverse(root.left);
		if (previous != null) {
			if (root.val <= previous.val) {
				if (first == null)
					first = previous;
				last = root;
			}
		}
		previous = root;
		inorderTraverse(root.right);
	}
}
