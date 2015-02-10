public class LeetCode_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (inorder == null || preorder == null || inorder.length == 0
				|| preorder.length == 0 || inorder.length != preorder.length)
			return null;
		return buildTree(inorder, 0, inorder.length - 1, preorder);
	}
	int index=0;
	private TreeNode buildTree(int[] inorder, int start, int end, int[] preorder) {
		if(start>end)
			return null;
		int currentIndex = index++;
		TreeNode current = new TreeNode(preorder[currentIndex]);
		for(int i=start;i<=end;i++){
			if(inorder[i]==preorder[currentIndex]){
				current.left = buildTree(inorder, start, i-1, preorder);
				current.right = buildTree(inorder, i+1, end, preorder);
				return current;
			}
		}
		return current;
	}
}
