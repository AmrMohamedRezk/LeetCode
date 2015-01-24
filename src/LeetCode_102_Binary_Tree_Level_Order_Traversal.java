import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LeetCode_102_Binary_Tree_Level_Order_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
		Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
			result.add(new ArrayList<Integer>());
			while (!currentLevel.isEmpty()) {
				TreeNode current = currentLevel.poll();
				result.get(result.size() - 1).add(current.val);
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

	public static void main(String[] args) {
		TreeNode one = new TreeNode(3);
		TreeNode two = new TreeNode(9);
		TreeNode three = new TreeNode(20);
		TreeNode four = new TreeNode(15);
		TreeNode five = new TreeNode(7);
		one.left = two;
		one.right = three;
		three.left = four;
		three.right = five;
		new LeetCode_102_Binary_Tree_Level_Order_Traversal().levelOrder(one);

	}
}
