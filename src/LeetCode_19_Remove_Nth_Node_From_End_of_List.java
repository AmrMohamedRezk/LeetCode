
public class LeetCode_19_Remove_Nth_Node_From_End_of_List {
	  public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fast  = head;
		ListNode previous  = head;
		for(int i=0;i<n-1;i++)
		{
			fast = fast.next;
		}
		fast = fast.next;
		if(fast==null)
			return head.next;
		while(fast.next!=null){
			fast = fast.next;
			previous = previous.next;
		}
		previous.next=previous.next.next;
		return head;
    }
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		one.next = two;
		removeNthFromEnd(one, 2);
	}
}
