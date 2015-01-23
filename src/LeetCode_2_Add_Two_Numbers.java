public class LeetCode_2_Add_Two_Numbers {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null;
		ListNode previous = null;
		int carry = 0;
		while (l1 != null & l2 != null) {
			int result = l1.val + l2.val + carry;
			carry = result > 9 ? 1 : 0;
			result = result % 10;
			if (head == null) {
				head = new ListNode(result);
				previous = head;
			} else {
				ListNode current = new ListNode(result);
				previous.next = current;
				previous = current;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int result = l1.val + carry;
			carry = result > 9 ? 1 : 0;
			result = result % 10;
			ListNode current = new ListNode(result);
			previous.next = current;
			previous = current;
			l1 = l1.next;
		}
		while (l2 != null) {
			int result = l2.val + carry;
			carry = result > 9 ? 1 : 0;
			result = result % 10;
			ListNode current = new ListNode(result);
			previous.next = current;
			previous = current;
			l2 = l2.next;
		}
		if (carry == 1) {
			ListNode current = new ListNode(1);
			previous.next = current;
		}
		return head;
	}
}
