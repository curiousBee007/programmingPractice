package GraphCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Anna on 6/6/17.
 */
public class CloneDirectedGraph {

    class Node {
        public int data;
        public List<Node> neighbors = new ArrayList<Node>();
        public Node(int d) {data = d;}
    }

    class Graph {

        private Node clone_rec(Node root, HashMap<Node, Node> nodes_completed) {
            if (root == null) {
                return null;
            }

            Node pNew = new Node(root.data);
            nodes_completed.put(root, pNew);

            for (Node p : root.neighbors) {
                Node x = nodes_completed.get(p);
                if (x == null){
                    pNew.neighbors.add(clone_rec(p, nodes_completed));
                } else {
                    pNew.neighbors.add(x);
                }
            }
            return pNew;
        }

        public  Node clone(Node root)
        {HashMap<Node, Node> nodes_completed = new HashMap<Node, Node>();

            return clone_rec(root, nodes_completed);
        }
    }
}
