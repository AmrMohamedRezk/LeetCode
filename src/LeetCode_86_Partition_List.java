public class LeetCode_86_Partition_List {
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

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return null;
		ListNode fakeFirstHalfHead = new ListNode(0);
		ListNode fakeSecondHalfHead = new ListNode(0);
		ListNode firstHalf = fakeFirstHalfHead;
		ListNode secondHalf = fakeSecondHalfHead;
		while (head != null) {
			if (head.val >= x) {
				secondHalf.next = head;
				secondHalf = head;
			} else if (head.val < x) {
				firstHalf.next = head;
				firstHalf = head;
			}
			head = head.next;
		}
		secondHalf.next = null;
		firstHalf.next = fakeSecondHalfHead.next;
		return fakeFirstHalfHead.next;
	}

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode two = new ListNode(4);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(2);
		first.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		ListNode result = partition(first, 3);
		System.out.println();
	}

}
