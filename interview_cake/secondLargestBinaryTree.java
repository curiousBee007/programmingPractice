package interview_cake;

/**
 * Created by Anna on 7/4/17.
 */
public class secondLargestBinaryTree {

    /*Notice how simple finding the second largest node got when we divided it into two cases:

    The largest node has a left subtree.
    The largest node does not have a left subtree.*/

    public class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    private static int findLargest(BinaryTreeNode rootNode) {
        BinaryTreeNode current = rootNode;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    // Second largest element in a binary search tree
    //We're doing one walk down our BST, which means O(h)O(h) time,
    // where hh is the height of the tree (again, that's O(\lg{n})O(lgn)
    // if the tree is balanced, O(n)O(n) otherwise). O(1)O(1) space.

    public static int findSecondLargest(BinaryTreeNode rootNode) {
        if (rootNode == null || (rootNode.left == null && rootNode.right == null)) {
            throw new IllegalArgumentException("Tree must have at least 2 nodes");
        }

        BinaryTreeNode current = rootNode;

        while (true) {

            // case: current is largest and has a left subtree
            // 2nd largest is the largest in that subtree
            if (current.left != null && current.right == null) {
                return findLargest(current.left);
            }

            // case: current is parent of largest, and largest has no children,
            // so current is 2nd largest
            if (current.right != null &&
                    current.right.left == null &&
                    current.right.right == null) {
                return current.value;
            }

            current = current.right;
        }
    }
}
