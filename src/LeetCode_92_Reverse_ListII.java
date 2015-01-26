
public class LeetCode_92_Reverse_ListII {
	  public static class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
                 val = x;
                 next = null;
          }
	  }
	  public static ListNode reverseBetween(ListNode head, int m, int n) {
          ListNode beforeFirst = null;
          ListNode first = head;
          ListNode afterLast = null;
          int counter = 1;
          while (counter < m) {
                 counter++;
                 beforeFirst = first;
                 first = first.next;
          }
          ListNode previous = null;
          ListNode current = first;
          while (counter <= n) {
                 counter++;
                 afterLast = current.next;
                 current.next = previous;
                 previous = current;
                 current = afterLast;
          }
          if (beforeFirst != null)
                 beforeFirst.next = previous;
          first.next = current;
          return m > 1 ? head : previous;
   }

}
