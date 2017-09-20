package Tree;

/**
 * Created by Anna on 6/5/17.
 */
public class InOrderSuccessorParent {

    public static TreeNode find_min_tree(TreeNode root){

        if(root == null)
            return null;

        while(root.left !=  null)
            root = root.left;

        return root;
    }




    public static TreeNode inorder_successor(TreeNode root){

        if(root == null)
            return null;

        if(root.right !=  null)
            return find_min_tree(root.right);

        while(root.parent != null){

            if(root.parent.left == root)
                return root.parent;

            root = root.parent;

        }

        return null;
    }




    public static TreeNode find_successor(TreeNode root, int d){

        while(root != null)
        {
            if(root.val < d)
                root = root.right;
            else if (root.val > d)
                root = root.left;
            else
                return inorder_successor(root);
        }

       return null;
    }

}
