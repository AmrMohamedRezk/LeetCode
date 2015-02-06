
public class LeetCode_104_Maximum_Depth_of_Binary_Tree {
	  public static class TreeNode {
		      int val;
		     TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public int maxDepth(TreeNode root) {
        if(root==null)
        	return 0;
        else
        	return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
