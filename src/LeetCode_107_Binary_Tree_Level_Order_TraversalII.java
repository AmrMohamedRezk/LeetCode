import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_107_Binary_Tree_Level_Order_TraversalII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
			result.add(0, new ArrayList<Integer>());
			while (!currentLevel.isEmpty()) {
				TreeNode current = currentLevel.poll();
				result.get(0).add(current.val);
				if (current.left != null)
					nextLevel.add(current.left);
				if (current.right != null)
					nextLevel.add(current.right);
			}
			currentLevel = nextLevel;
			nextLevel = new LinkedList<TreeNode>();
		}
		return result;
	}

}
