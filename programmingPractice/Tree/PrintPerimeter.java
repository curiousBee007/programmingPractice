package Tree;

import java.util.Stack;

/**
 * Created by Anna on 6/5/17.
 */
public class PrintPerimeter {

    static Stack<TreeNode> stack = new Stack<TreeNode>();

   //Not correct
   /* public static void findLeaf(TreeNode root,TreeNode leftMostLeaf){

        TreeNode temp = root;
        boolean isLeft = false;
        boolean isRight = false;

        while(root.left != null){
            isLeft = true;
            root = root.left;
        }
        if(isLeft && root.val != leftMostLeaf.val)
        System.out.print(" "+root.val);


        while(temp.right != null){
            isRight = true;
            temp = temp.right;
        }
        if(isRight)
            System.out.print(" "+temp.val);



    }


    public static void printParameter(TreeNode root){

        if(root == null)
            return;

        //stack.push(root);
        while(root != null){
            System.out.print(" " +root.val);
            stack.push(root);
            root = root.left;
        }

        TreeNode leftMostLeaf = stack.pop();

        while(stack.size() != 1){
            TreeNode temp = stack.pop();
            //System.out.println("temp =  "+temp.val);
            findLeaf(temp,leftMostLeaf);
           // System.out.println(" "+x.val);

        }
        root = stack.pop();
        while(root.right != null){
            stack.push(root.right);
            root = root.right;
        }

        while(stack.size() != 0){
            System.out.print(" "+ stack.pop().val);
        }


    }*/

   public static void print_left_perimeter(TreeNode root){
       while(root != null){

           int curr_val = root.val;

           if(root.left != null)
               root = root.left;

           else if(root.right != null)
               root = root.right;
           else
               break;
           System.out.println(curr_val +" ");

       }
   }

   public static void print_right_perimeter(TreeNode root){
       Stack<Integer> _rvalues = new Stack<>();
       while(root != null){

           int curr_data = root.val;

           if(root.right != null)
               root = root.right;

           else if(root.left != null)
               root = root.left;

           else
               break;

           _rvalues.push(curr_data);
       }

       while(_rvalues.isEmpty())
           System.out.println(_rvalues.pop() + " ");

   }

   public static void print_leaf_nodes(TreeNode root) {

       if (root != null) {
           print_leaf_nodes(root.left);
           print_leaf_nodes(root.right);

           if (root.left == null && root.right == null)
               System.out.println(root.val + " ");

       }
   }



       public static void display_tree_perimeter(TreeNode root)
       {
           if (root != null) {
               System.out.print(root.val + " ");

               print_left_perimeter(root.left);

               if (root.left != null ||
                       root.right != null) {
                   // We don't need to print if root is also the leaf node.
                   print_leaf_nodes(root);
               }

               print_right_perimeter(root.right);
           }
       }





    public static void main(String[] args){

        /*TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(10);

        root.left.left.left = new TreeNode(9);
        root.left.right.right = new TreeNode(8);*/


        //int d = 125;

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);

        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(350);

        /*
        *      100
        *      /    \
        *      50     200
        *      / \    /   \
        *     25  75  125  350
        *
        *
        *
        *
        *
        * */
       //printParameter(root);
        display_tree_perimeter(root);



    }


}
