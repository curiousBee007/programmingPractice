package Tree;

/**
 * Created by Anna on 6/5/17.
 */
public class InorderSuccessor {

    public static TreeNode find_min(TreeNode root){
        if(root == null)
            return null;

        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static TreeNode inorder_successor_bst(TreeNode root, int d){

      if(root == null)
          return null;

      TreeNode successor = null;
      while(root != null){

          if(root.val < d){
              root = root.right;
          }
          if(root.val > d){
              successor = root;
              root = root.left;
          }
          else{
              if(root.right != null){

                 successor = find_min(root.right);
              }
              break;

          }

      }

      return successor;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(50);
        root.right = new TreeNode(200);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(75);

        root.right.left = new TreeNode(125);
        root.right.right = new TreeNode(350);

        int d = 125;

        /*
        *      100
        *      /  \
        *      50   200
        *            /  \
        *            125  350
        *      / \
        *    25   75
        *
        *
        *
        * */
        TreeNode ans = inorder_successor_bst(root,d);
        if(ans != null)
            System.out.println(ans.val);

    }



}
