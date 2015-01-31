public class LeetCode_82_Remove_Duplicates_from_Sorted_ListII {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode deleteDuplicates(ListNode head) {
    	ListNode fakeHead = new ListNode(0);
    	ListNode current = fakeHead;
    	while(head!=null){
    		if(head.next!=null && head.next.val == head.val){
    			ListNode next = head;
    			while(next!=null&&next.val==head.val)
    				next = next.next;
    			head = next;
    		}else{
    			current.next = head;
    			current = head;
    			head = head.next;
    		}
    	}
    	current.next = null;
    	return fakeHead.next;
    }
    public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(1);
		ListNode three = new ListNode(1);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(3);
//		ListNode six = new ListNode(4);
//		ListNode seven = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
//		five.next = six;
//		six.next = seven;
		deleteDuplicates(one);
    }

}
