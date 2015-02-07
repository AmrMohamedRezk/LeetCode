import java.util.ArrayList;
import java.util.List;

public class LeetCode_129_Sum_Root_to_Leaf_Numbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sumNumbers(root, root.val, 0);
	}

	public int sumNumbers(TreeNode root, int path, int sum) {
		if (root.left == null && root.right == null) {
			return sum + path;
		}

		if (root.left != null) {
			sum = sumNumbers(root.left, path * 10 + root.left.val, sum);
		}
		if (root.right != null) {
			sum = sumNumbers(root.right, path * 10 + root.right.val, sum);
		}

		return sum;
	}

}
