public class LeetCode_141_Linked_List_Cycle {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		do {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}

}
