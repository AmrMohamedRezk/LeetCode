public class LeetCode_83_Remove_Duplicates_from_Sorted_List {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode current = head;
		ListNode runner = head.next;
		while (runner != null) {
			if (runner.val != current.val) {
				current.next = runner;
				current = runner;
			}
			runner = runner.next;
		}
		current.next = null;
		return head;
	}
}
