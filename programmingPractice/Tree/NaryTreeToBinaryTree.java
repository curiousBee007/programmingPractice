package Tree;

import java.util.ArrayList;

/**
 * Created by Anna on 6/5/17.
 */
class NTreeNode{

    NTreeNode node;
    ArrayList<NTreeNode> children;
    int val;

    NTreeNode(int val ){
        this.val = val;
        //children = new NTreeNode[n];
        //children = new ArrayList<>(n);

    }


}

public class NaryTreeToBinaryTree {

public static TreeNode convert_n_ary_tree_to_binary(NTreeNode root){

    return convert_n_ary_tree_to_binary(root,true);
}


public static TreeNode convert_n_ary_tree_to_binary(NTreeNode node,boolean isLeft){

     if(node == null)
         return null;

     TreeNode btNode = new TreeNode(node.val);
     TreeNode lastNode = btNode;

     for(int i = 0 ; i < node.children.size();i++){
        if(isLeft){

            lastNode.left = convert_n_ary_tree_to_binary(node.children.get(i),!isLeft);
            lastNode = lastNode.left;
        }

        else{

            lastNode.right = convert_n_ary_tree_to_binary(node.children.get(i),!isLeft);
            lastNode = lastNode.right;

        }

     }
     return btNode;
    }

    public static NTreeNode convert_binary_tree_to_nary(TreeNode root){

        return convert_binary_tree_to_nary(root,true);
    }

    public static NTreeNode convert_binary_tree_to_nary(TreeNode node,boolean isLeft){

        if(node == null)
            return null;

        NTreeNode nnode = new NTreeNode(node.val);
        TreeNode temp = node;

        if(isLeft){
           while(temp.left != null){

               NTreeNode child = convert_binary_tree_to_nary(temp.left,!isLeft);
               nnode.children.add(child);
               temp = temp.left;

           }
        }

        else{
            while(temp.right != null){

                NTreeNode child = convert_binary_tree_to_nary(temp.right,!isLeft);
                nnode.children.add(child);
                temp = temp.right;

            }

        }

        return nnode;
    }



}
