class TreeNode{
	TreeNode left;
	TreeNode right;
	int value;
	public TreeNode(int value) {
		this.value = value;
	}
}
public class LeastCommonAncestor {
	
	public TreeNode lowestCommon(TreeNode root, TreeNode a, TreeNode b) {
		 
		if(root == null || root == a || root == b) 
			 return root;
			
	    TreeNode left = lowestCommon(root.left ,a,b);
		TreeNode right = lowestCommon(root.right ,a,b);
		
		 if(left!=null && right!=null) return root;
		
		return (left == null ? right : left);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
