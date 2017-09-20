package GraphCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 6/6/17.
 */
class vertex {
    private char value;
    private boolean visited;
    private List<vertex> adj_vertices;
    private List<vertex> in_vertices;

    public vertex(char value, boolean visited) {
        this.value = value;
        this.visited = visited;
        this.adj_vertices = new ArrayList<vertex>();
        this.in_vertices = new ArrayList<vertex>();
    }

    char getValue() {
        return value;
    }

    void setValue(char value) {
        this.value = value;
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }

    List<vertex> getAdj_vertices() {
        return this.adj_vertices;
    }

    List<vertex> getIn_vertices() {
        return this.in_vertices;
    }
}




    class graph {
        private List<vertex> g;

        public graph(List<vertex> g) {
            super();
            this.g = g;
        }

        public List<vertex> getG() {
            return g;
        }

        void setG(List<vertex> g) {
            this.g = g;
        }

        // This method creates a graph from a list of words. A node of
        // the graph contains a character representing the start or end
        // character of a word.
        void create_graph(List<String> words_list) {
            for (int i = 0; i < words_list.size(); i++) {
                String word = words_list.get(i);
                char start_char = word.charAt(0);
                char end_char = word.charAt(word.length() - 1);

                vertex start = vertex_exists(start_char);
                if (start == null) {
                    start = new vertex(start_char, false);
                    g.add(start);
                }

                vertex end = vertex_exists(end_char);
                if (end == null) {
                    end = new vertex(end_char, false);
                    g.add(end);
                }

                // Add an edge from start vertex to end vertex
                add_edge(start, end);
            }
        }

        // This method returns the vertex with a given value if it
        // already exists in the graph, returns NULL otherwise
        vertex vertex_exists(char value) {
            for (int i = 0; i < g.size(); i++) {
                if (g.get(i).getValue() == value) {
                    return g.get(i);
                }
            }
            return null;
        }

        // This method returns TRUE if all nodes of the graph have
        // been visited
        boolean all_visited() {
            for (int i = 0; i < getG().size(); i++) {
                if (getG().get(i).isVisited() == false) {
                    return false;
                }
            }
            return true;
        }

        // This method adds an edge from start vertex to end vertex by
        // adding the end vertex in the adjacency list of start vertex
        // It also adds the start vertex to the in_vertices of end vertex
        void add_edge(vertex start, vertex end) {
            start.getAdj_vertices().add(end);
            end.getIn_vertices().add(start);
        }

        // This method returns TRUE if out degree of each vertex is equal
        // to its in degree, returns FALSE otherwise
        boolean out_equals_in() {
            for (int i = 0; i < getG().size(); i++) {
                int out = getG().get(i).getAdj_vertices().size();
                int in = getG().get(i).getIn_vertices().size();
                if (out != in) {
                    return false;
                }
            }
            return true;
        }

        // This method returns TRUE if the graph has a cycle containing
        // all the nodes, returns FALSE otherwise
        boolean check_cycle_rec(vertex node, vertex starting_node) {

            node.setVisited(true);

            // Base case
            // return TRUE if all nodes have been visited and there
            // exists an edge from the last node being visited to
            // the starting node
            List<vertex> adj = node.getAdj_vertices();
            if (all_visited()) {
                for (int i = 0; i < adj.size(); i++) {
                    if (adj.get(i) == starting_node) {
                        return true;
                    }
                }
            }

            // Recursive case
            for (int i = 0; i < adj.size(); i++) {
                if (adj.get(i).isVisited() == false) {
                    node = adj.get(i);
                    if (check_cycle_rec(node, starting_node)) {
                        return true;
                    }
                }
            }
            return false;
        }


        boolean check_cycle(int list_size) {
            // Empty list and single word cannot form a chain
            if (list_size < 2) {
                return false;
            }

            if (g.size() > 0) {
                if (out_equals_in()) {
                    return check_cycle_rec(getG().get(0),
                            getG().get(0));
                }
            }
            return false;
        }

        void print_graph() {
            for (int i = 0; i < g.size(); i++) {
                System.out.println(g.get(i).getValue() + " "
                        + g.get(i).isVisited() + "\n");
                List<vertex> adj = g.get(i).getAdj_vertices();
                for (int j = 0; j < adj.size(); j++) {
                    System.out.println(adj.get(j).getValue() + " ");
                }
                System.out.println("\n");
            }
        }

    }

    public class WordChaining {
}
