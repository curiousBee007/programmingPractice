package Tree;

/**
 * Created by Anna on 8/7/17.
 */
class TreeNode1 {
     int val;
     TreeNode1 left;
     TreeNode1 right;
     TreeNode1(int x) { val = x; }
 }
public class MergeBinaryTree {

    /*public TreeNode1 mergeTrees1(TreeNode1 t1, TreeNode1 t2){
        TreeNode1 rootNode = new TreeNode1(0);
        mergeTrees( t1, t2);
        return(rootNode);
    }*/



    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args){

        TreeNode1 root1 = new TreeNode1(1);
        root1.left = new TreeNode1(3);
        root1.right = new TreeNode1(2);
        root1.left.left = new TreeNode1(5);

        TreeNode1 root2 = new TreeNode1(2);
        root1.left = new TreeNode1(1);
        root1.right = new TreeNode1(3);
        root1.left.right = new TreeNode1(4);
        root1.right.right = new TreeNode1(7);

        MergeBinaryTree obj = new MergeBinaryTree();
        //obj.mergeTrees(root1,root2);
    }
}
