import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_117_Populating_Next_Right_Pointers_in_Each_NodeII {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
		public String toString(){
			return ""+val;
		}
	}
    public static void connect(TreeLinkNode root) {
    	if(root ==null)
    		return;
    	Queue<TreeLinkNode> previousLevel = new LinkedList<TreeLinkNode>();
    	Queue<TreeLinkNode> currentLevel = new LinkedList<TreeLinkNode>();
        previousLevel.add(root);
        while(!currentLevel.isEmpty()||!previousLevel.isEmpty()){
        	while(!previousLevel.isEmpty()){
        		TreeLinkNode first = previousLevel.poll();
        		first.next= (previousLevel.isEmpty()) ? null:previousLevel.peek();
        		if(first.left!=null)
        			currentLevel.add(first.left);
        		if(first.right!=null)
        			currentLevel.add(first.right);
        	}
        	previousLevel = currentLevel;
        	currentLevel = new LinkedList<TreeLinkNode>();
        }
    }
    public static void main(String[] args) {
		TreeLinkNode one = new TreeLinkNode(1);
		TreeLinkNode two = new TreeLinkNode(2);
		TreeLinkNode three = new TreeLinkNode(3);
		TreeLinkNode four = new TreeLinkNode(4);
		TreeLinkNode five = new TreeLinkNode(5);
		TreeLinkNode seven = new TreeLinkNode(7);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.right = seven;
		connect(one);
		System.out.println();

    }

}
