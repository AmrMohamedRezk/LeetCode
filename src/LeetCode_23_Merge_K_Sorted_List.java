import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_23_Merge_K_Sorted_List {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
				lists.size(), new Comparator<ListNode>() {

					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}
				});
		for (ListNode node : lists) {
			if (node != null)
				queue.add(node);
		}
		if (!queue.isEmpty()) {
			ListNode head = queue.poll();
			ListNode current = head;
			if (head.next != null)
				queue.add(head.next);
			while (!queue.isEmpty()) {

				current.next = queue.poll();
				current = current.next;
				if (current.next != null) {
					queue.add(current.next);
				} else {
					if (queue.size() == 1) {
						current.next = queue.poll();
						return head;
					}
				}
			}
			return head;
		}
		return null;
	}
}
