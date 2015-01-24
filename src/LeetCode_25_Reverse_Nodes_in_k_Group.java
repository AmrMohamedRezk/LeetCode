public class LeetCode_25_Reverse_Nodes_in_k_Group {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		if (!shouldReverse(head, k))
			return head;
		ListNode previous = null;
		ListNode current = head;
		ListNode next = null;
		int count = 0;
		while (current != null && count < k) {
			count++;
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		if (next != null) {
			head.next = reverseKGroup(next, k);
		}
		return previous;
	}

	private boolean shouldReverse(ListNode head, int k) {
		while (head != null && k != 0) {
			head = head.next;
			k--;
		}
		return k == 0 ? true : false;
	}

}
