package Tree;

import java.util.Stack;

/**
 * Created by Anna on 6/5/17.
 */
public class InorderTreeIterator {

    Stack<TreeNode> stk = new Stack<TreeNode>();

    public InorderTreeIterator(TreeNode root){

        while(root != null){
            stk.push(root.left);
            root = root.left;
        }

    }

    public boolean hasNext(){
        return !stk.isEmpty();
    }

    public TreeNode getNext(){

        if(stk.isEmpty())
            return null;

        TreeNode popNode = stk.pop();
        TreeNode temp = popNode.right;

        while(temp!= null){
            stk.push(temp);
            temp = temp.left;
        }
        return popNode;

    }

}
