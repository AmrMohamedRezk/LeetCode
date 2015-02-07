import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<TreeNode> currentLevel = new ArrayList<TreeNode>();
		if (root == null)
			return result;
		currentLevel.add(root);
		boolean flag = true;

		List<TreeNode> nextLevel = new ArrayList<TreeNode>();
		while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
			List<Integer> num = new ArrayList<Integer>();
			if (!flag) {
				for(int i=currentLevel.size()-1;i>=0;i--)
					num.add(currentLevel.get(i).val);
			} else {
				for (TreeNode node : currentLevel) {
					num.add(node.val);
				}
			}
			result.add(num);
			while (!currentLevel.isEmpty()) {
				TreeNode current = currentLevel.remove(0);
				if (current.left != null)
					nextLevel.add(current.left);
				if (current.right != null)
					nextLevel.add(current.right);
			}
			flag = !flag;
			currentLevel = nextLevel;
			nextLevel = new ArrayList<TreeNode>();
		}
		return result;
	}
}
