public class LeetCode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int index;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length == 0
				|| postorder.length == 0 || inorder.length != postorder.length)
			return null;
		index = postorder.length - 1;
		return buildTree(inorder, 0, inorder.length - 1, postorder);
	}

	private TreeNode buildTree(int[] inorder, int start, int end,
			int[] postorder) {
		if (start > end) {
			return null;
		}
		int currentIndex = index--;
		TreeNode root = new TreeNode(postorder[currentIndex]);
		for (int i = start; i <= end; i++) {
			if (inorder[i] == postorder[currentIndex]) {
				root.right = buildTree(inorder, i + 1, end, postorder);
				root.left = buildTree(inorder, start, i - 1, postorder);
				break;
			}

		}

		return root;
	}

}
