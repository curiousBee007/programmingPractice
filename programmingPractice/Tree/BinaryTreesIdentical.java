package Tree;

/**
 * Created by Anna on 6/5/17.
 *
 */
class TreeNode{

    TreeNode left;
    TreeNode right;
    int val;
    TreeNode next;
    TreeNode parent;

    TreeNode(int x){
        val = x;
    }

}

public class BinaryTreesIdentical {

     public static boolean are_identical(TreeNode root1, TreeNode root2){

         if(root1 == null && root2 == null)
             return true;

         if(root1 != null && root2 != null){

           return ((root1.val == root2.val) && are_identical(root1.left,root2.left)
                   && are_identical(root1.right,root2.right));

         }
         return false;
     }


}
