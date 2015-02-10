import java.util.Queue;

public class LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> currentLevel = new java.util.LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> nextLevel = new java.util.LinkedList<TreeLinkNode>();
		currentLevel.add(root);
		while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				TreeLinkNode current = currentLevel.poll();
				if (!currentLevel.isEmpty())
					current.next = currentLevel.peek();
				if (current.left != null)
					nextLevel.add(current.left);
				if (current.right != null)
					nextLevel.add(current.right);
			}
			currentLevel = nextLevel;
			nextLevel = new java.util.LinkedList<TreeLinkNode>();
		}

	}

}
