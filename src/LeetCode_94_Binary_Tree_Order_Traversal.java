import java.util.ArrayList;
import java.util.List;

public class LeetCode_94_Binary_Tree_Order_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		inorderTraversal(root,result);
		return result;
	}

	private void inorderTraversal(TreeNode root, List<Integer> result) {
		if(root==null)
			return;
		inorderTraversal(root.left, result);
		result.add(root.val);
		inorderTraversal(root.right,result);
	}
}

