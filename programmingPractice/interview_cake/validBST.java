package interview_cake;

import java.util.Stack;

/**
 * Created by Anna on 7/4/17.
 */
public class validBST {

    public static class BinaryTreeNode {

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

    //Recursive approach
    public static boolean isBinarySearchTree(BinaryTreeNode root) {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    //O(n) time and O(n)O(n) space.
    private static boolean isBinarySearchTree(BinaryTreeNode root, int lowerBound, int upperBound) {
        if (root == null) {
            return true;
        }

        if (root.value >= upperBound || root.value <= lowerBound) {
            return false;
        }

        return isBinarySearchTree(root.left, lowerBound, root.value)
                && isBinarySearchTree(root.right, root.value, upperBound);
    }

    //iterative approach


    private static class NodeBounds {

        BinaryTreeNode node;
        int lowerBound;
        int upperBound;

        NodeBounds(BinaryTreeNode node, int lowerBound, int upperBound) {
            this.node = node;
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }
    }

    public static boolean isBinarySearchTree1(BinaryTreeNode root) {

        // start at the root, with an arbitrarily low lower bound
        // and an arbitrarily high upper bound
        Stack<NodeBounds> nodeAndBoundsStack = new Stack<NodeBounds>();
        nodeAndBoundsStack.push(new NodeBounds(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        // depth-first traversal
        while (!nodeAndBoundsStack.empty()) {
            NodeBounds nb = nodeAndBoundsStack.pop();
            BinaryTreeNode node = nb.node;
            int lowerBound = nb.lowerBound;
            int upperBound = nb.upperBound;

            // if this node is invalid, we return false right away
            if (node.value <= lowerBound || node.value >= upperBound) {
                return false;
            }

            if (node.left != null) {
                // this node must be less than the current node
                nodeAndBoundsStack.push(new NodeBounds(node.left, lowerBound, node.value));
            }
            if (node.right != null) {
                // this node must be greater than the current node
                nodeAndBoundsStack.push(new NodeBounds(node.right, node.value, upperBound));
            }
        }

        // if none of the nodes were invalid, return true
        // (at this point we have checked all nodes)
        return true;
    }
}
