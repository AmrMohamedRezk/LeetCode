public class LeetCode_109_Convert_Sorted_List_to_Binary_Search_Tree {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return "" + val;
		}
	}

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

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		if(head.next==null)
			return new TreeNode(head.val);
		ListNode preMiddle = getMiddle(head);
		ListNode aftMiddle = null;
		ListNode middle = null;
		if (preMiddle != null) {
			aftMiddle = preMiddle.next.next;
			middle = preMiddle.next;
			preMiddle.next = null;
		} else {
			aftMiddle = head.next;
			middle = head;
		}
		TreeNode current = new TreeNode(middle.val);
		TreeNode left = sortedListToBST(head);
		TreeNode right = sortedListToBST(aftMiddle);
		current.left = left;
		current.right = right;
		return current;

	}

	private static ListNode getMiddle(ListNode head) {
		ListNode previous = null;
		ListNode middle = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			previous = middle;
			middle = middle.next;
			fast = fast.next.next;
		}
		return previous;
	}

	public static void main(String[] args) {
		ListNode first = new ListNode(-1);
		ListNode two = new ListNode(0);
		ListNode three = new ListNode(1);
		ListNode four = new ListNode(2);
		first.next = two;
		two.next = three;
		three.next = four;
		TreeNode root = sortedListToBST(first);
		System.out.println();
	}
}
