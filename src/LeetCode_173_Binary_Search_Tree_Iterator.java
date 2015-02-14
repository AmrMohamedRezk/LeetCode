import java.util.Stack;

public class LeetCode_173_Binary_Search_Tree_Iterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return "" + val;
		}
	}

	private Stack<TreeNode> stack;

	public LeetCode_173_Binary_Search_Tree_Iterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = stack.pop();
		int retval = node.val;
		if (node.right != null) {
			node = node.right;
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
		}
		return retval;
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		six.left = two;
		six.right = eight;
		two.left = one;
		two.right = four;
		four.left = three;
		four.right = five;
		eight.left = seven;
		eight.right = nine;
		LeetCode_173_Binary_Search_Tree_Iterator it = new LeetCode_173_Binary_Search_Tree_Iterator(
				six);
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */
