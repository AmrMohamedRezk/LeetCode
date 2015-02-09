import java.util.Stack;

public class LeetCode_143_Reorder_List {
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

	public static void reorderList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (slow != fast) {
			Stack<ListNode> stack = new Stack<ListNode>();
			while (slow != null) {
				stack.push(slow);
				slow = slow.next;
			}
			ListNode current = head;
			while (!stack.isEmpty()) {
				if (stack.peek() != current) {
					ListNode next = current.next;
					current.next = stack.pop();
					current.next.next = next;
					current = next;
				}else{
					stack.pop();
				}
			}
			current.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
//		ListNode seven = new ListNode(7);
		one.next = two;
		two.next = three;
//		three.next = four;
//		four.next = five;
//		five.next = six;
	//	six.next = seven;
		reorderList(one);
	}
}
