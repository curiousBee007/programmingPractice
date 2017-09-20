package Tree;

import java.util.Stack;

/**
 * Created by Anna on 6/5/17.
 */
public class IterativeInorderTraversal {

    public static void inorder_iterative(TreeNode root){

        if(root == null)
            return;

        Stack<TreeNode> stk = new Stack<TreeNode>();

        while(!stk.isEmpty() || root != null){

            if(root != null)
            {
                stk.push(root);
                root = root.left;
                continue;
            }

            System.out.println(stk.peek().val + " ");
            root = stk.pop().right;

        }

    }
}
