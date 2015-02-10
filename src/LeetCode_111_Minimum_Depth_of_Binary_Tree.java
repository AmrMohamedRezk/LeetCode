public class LeetCode_111_Minimum_Depth_of_Binary_Tree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public int minDepth(TreeNode root) {
    	if(root==null)
    		return 0;
    	return doCalcMinDepth(root);
    }
    private int doCalcMinDepth(TreeNode root){
    	if(root==null)
    		return Integer.MAX_VALUE;
    	if(root.left==null&&root.right==null)
    		return 1;
    	return 1+Math.min(doCalcMinDepth(root.left), doCalcMinDepth(root.right));
        
    }
}
