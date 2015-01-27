public class LeetCode_24_Swap_Nodes_in_Pairs {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode previous = fakeHead;
		ListNode current = fakeHead.next;
		ListNode next = null;
		while(current!=null && current.next!=null){
			next = current.next.next;
			previous.next = current.next;
			previous = current;
			current.next.next = current;
			current.next = next;
			current = next;
		}
		return fakeHead.next;
	}
}
