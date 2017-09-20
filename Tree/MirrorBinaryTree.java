package Tree;

/**
 * Created by Anna on 6/5/17.
 */
public class MirrorBinaryTree {

    public static void mirror_binary_tree(
           TreeNode root) {

        if (root == null) {
            return;
        }

        // We will do a post-order traversal of the binary tree.

        if (root.left != null) {
            mirror_binary_tree(root.left);
        }

        if (root.right != null) {
            mirror_binary_tree(root.right);
        }

        // Let's swap the left and right nodes at current level.

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
