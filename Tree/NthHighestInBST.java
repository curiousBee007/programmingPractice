package Tree;

/**
 * Created by Anna on 6/5/17.
 */
public class NthHighestInBST {

    public static int current_count = 0;
    //Reverse in order
    public static TreeNode find_nth_highest_in_bst(
            TreeNode node,
            int n) {

        if (node == null) {
            return null;
        }

        TreeNode result = find_nth_highest_in_bst(node.right, n);

        if(result != null) {
            return result;
        }

        current_count++;
        if(n == current_count) {
            return node;
        }

        result = find_nth_highest_in_bst(node.left, n);

        if(result != null) {
            return result;
        }

        return null;
    }


    public static void main(String[] args){

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(10);

        root.left.left.left = new TreeNode(9);
        root.left.right.right = new TreeNode(8);*/


        //int d = 125;

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);

        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(350);

        /*
        *      100
        *      /    \
        *      50     200
        *      / \    /   \
        *     25  75  125  350
        *
        *
        *
        *
        *
        * */
        //printParameter(root);
        TreeNode x = find_nth_highest_in_bst(root,3);
        System.out.println(x.val);



    }

}
