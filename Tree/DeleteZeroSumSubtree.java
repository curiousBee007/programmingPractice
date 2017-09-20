package Tree;

/**
 * Created by Anna on 6/5/17.
 */
public class DeleteZeroSumSubtree {

    public static int delete_zero_sum_subtree_rec(
            TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum_left = delete_zero_sum_subtree_rec(root.left);
        int sum_right = delete_zero_sum_subtree_rec(root.right);

        if (sum_left == 0) {
            root.left = null;
        }
        if (sum_right == 0) {
            root.right = null;
        }

        return root.val + sum_left + sum_right;
    }

    public static void printTree(TreeNode root)
    {
        if(root == null)
            return;
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    public static void delete_zero_sum_subtree(
            TreeNode root) {

        if (root == null) {
            return;
        }
        int x = delete_zero_sum_subtree_rec(root);

        if (0 == x) {
            root = null;
        }
        printTree(root);

    }

    public static void main(String[] args){


        //int d = 125;

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(-3);
        root.left.right = new TreeNode(-2);



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

        delete_zero_sum_subtree(root);


    }
}
