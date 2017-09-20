package Tree;

import java.util.ArrayDeque;

/**
 * Created by Anna on 6/5/17.
 * private static final int MARKER = Integer.MIN_VALUE;

 public static void serialize(BinaryTreeNode node,
 ObjectOutputStream stream)
 throws java.io.IOException {
 if (node == null) {
 stream.writeInt(MARKER);
 return;
 }

 stream.writeInt(node.data);
 serialize(node.left, stream);
 serialize(node.right, stream);
 }

 public static BinaryTreeNode deserialize(
 ObjectInputStream stream) throws java.io.IOException {
 int val = stream.readInt();
 if (val == MARKER) {
 return null;
 }

 BinaryTreeNode node = new BinaryTreeNode(val);
 node.left = deserialize(stream);
 node.right = deserialize(stream);
 return node;
 }
 *
 */
public class ConnectAllSiblings {

    public static void populate_all_siblings(TreeNode root){

        if(root == null)
            return;

        TreeNode current = root;
        TreeNode last = root;

        while(current != null){

            if(current.left != null){
                last.next = current.left;
                last = last.next;
            }
            if(current.right != null){
                last.next = current.right;
                last = last.next;
            }
            last.next = null;
            current = current.left;

        }


    }
    public static void populate_sibling_pointers_2(TreeNode root) {
        if(root == null)
            return;

        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        TreeNode prev = null;

        while(!queue.isEmpty()){
            TreeNode temp = queue.removeFirst();

            if(prev != null) {
                prev.next = temp;
            }

            prev = temp;

            if(temp.left != null){
                queue.addLast(temp.left);
            }

            if(temp.right != null){
                queue.addLast(temp.right);
            }
        }
        prev.next = null;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);
        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(350);
        root.left.left.right = new TreeNode(30);
        root.left.right.left = new TreeNode(60);

        populate_all_siblings(root);
        while(root != null)
        {
            System.out.println(root.val);
            root = root.next;
        }
    }

}
