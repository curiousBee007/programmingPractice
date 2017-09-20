package Tree;

/**
 * Created by Anna on 6/5/17.
 */
public class BinaryTreeDoublyLinkedList {
    // merge(fuse) two sorted linked lists
    //Circular double liked list
    static TreeNode concatenate_lists(
            TreeNode head1,
            TreeNode head2) {

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        // use left for previous.
        // use right for next.
        TreeNode tail1 = head1.left;
        TreeNode tail2 = head2.left;

        System.out.println("Head1 value is "+ head1.val);
        System.out.println("Head2 value is "+ head2.val);

        System.out.println("Tail1 value  "+ tail1.val);


        System.out.println("Tail2 value " + tail2.val);
        System.out.println("------------------------------");


        tail1.right = head2;
        head2.left = tail1;

        head1.left = tail2;
        tail2.right = head1;
        return head1;
    }


    public static TreeNode convert_to_linked_list(
            TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode list1 = convert_to_linked_list(root.left);
        TreeNode list2 = convert_to_linked_list(root.right);

        root.left = root.right = root;
        TreeNode result = concatenate_lists(list1, root);
        result = concatenate_lists(result, list2);

        return result;
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

        TreeNode result1 = convert_to_linked_list(root);

        while(result1 != null){
            System.out.println(result1.val);
            result1 = result1.right;
        }
    }

}
