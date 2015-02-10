import java.util.ArrayList;
import java.util.List;

public class LeetCode_113_Path_SumII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> currentResult = new ArrayList<Integer>();
		if (root != null)
			pathSum(root, 0, sum, result, currentResult);
		return result;
	}

	private void pathSum(TreeNode root, int currentSum, int sum,
			List<List<Integer>> result, List<Integer> currentResult) {
		if (root == null)
			return;
		if (isLeaf(root) && currentSum + root.val == sum) {
			currentResult.add(root.val);
			List<Integer> copy = new ArrayList<Integer>();
			for (int num : currentResult)
				copy.add(num);
			result.add(copy);
			currentResult.remove(currentResult.size() - 1);
			return;
		}
		currentResult.add(root.val);
		pathSum(root.left, currentSum + root.val, sum, result, currentResult);
		pathSum(root.right, currentSum + root.val, sum, result, currentResult);
		currentResult.remove(currentResult.size() - 1);
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}
}
