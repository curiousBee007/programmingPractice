package Tree;

/**
 * Created by Anna on 6/5/17.
 *
 * Runtime Complexity
 Linear, O(n)

 Memory Complexity
 O(h).

 Recursive solution has O(h) memory complexity as it will consume memory on the stack up to the height of binary tree h.
 It will be O(log n) for a balanced tree and in the worst case can be O(n).
 */
public class isBinarySearchTree {

    private static boolean is_bst_rec(TreeNode root, int min_value, int max_value){

        if(root == null)
            return true;

        if( root.val < min_value || root.val > max_value)
            return false;

        return is_bst_rec(root.left,min_value,root.val) && is_bst_rec(root.right,root.val,max_value);

    }

    public static boolean is_bst(TreeNode root){

        return is_bst_rec(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /*Runtime Complexity
Linear, O(n).

Memory Complexity
O(h).

Recursive solution has O(h) memory complexity as it will consume memory on the stack up to the height of binary tree h.
 It will be O(log n) for a balanced tree and in the worst case can be O(n).*/

    static TreeNode prev = null;

    public static boolean is_binary_search_tree(
            TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!is_binary_search_tree(root.left) || (prev != null && prev.val>= root.val)) {
            return false;
        }

        prev = root;

        if (!is_binary_search_tree(root.right)) {
            return false;
        }

        return true;
    }


    public static void main(String[] args){

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);

        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(350);

        int d = 125;

        /*
        *      100
        *      /  \
        *      50   200
        *            /  \
        *            125  350
        *      / \
        *    25   75
        *
        *
        *
        * */
        boolean ans = is_binary_search_tree(root);

            System.out.println(ans);

    }



}
