public class LeetCode_114_Flatten_Binary_Tree_to_Linked_List {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    TreeNode previous = null;
	public void flatten(TreeNode root) {
		if(root ==null)
			return;
		TreeNode right = root.right;
	    if(previous!=null){
		    previous.right = root;
	        previous.left = null;
	    }
		previous = root;
		flatten(root.left);
		flatten(right);
    }
}
