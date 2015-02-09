public class LeetCode_142_Linked_List_CycleII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if(head ==null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		do{
			if(fast==null||fast.next==null)
				return null;
			slow = slow.next;
			fast = fast.next.next;
		}while(slow!=fast);
		slow = head;
		while(slow!=fast)
		{
			slow = slow.next;
			fast=fast.next;
		}
		return slow;
	}
}
