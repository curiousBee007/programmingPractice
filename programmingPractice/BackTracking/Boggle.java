package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an NxN grid of characters and a dictionary,
 * find all words which can be made from the characters in grid and present in the given dictionary.
 * A word can start and end at any character in the grid.
 * Next character must be adjacent to previous character in any of the directions i.e. up, down, left, right and diagonal.
 * Character at each position in grid can be used only once while making a word.
 * Runtime Complexity
 Exponential, O(N^n).

 where 'N' is the dimension of the grid.

 The recurrence relation for time complexity is

 T(N) = N^2 T(N-1)T(N)=N
 ​2
 ​​ T(N−1)
 Memory Complexity
 Quadratic, O(N^2).
 */
public class Boggle {

        // code assumes that both dimensions of grid are same
        char[][] grid;
        Set<String> dictionary;
        boolean[][] state;

     Boggle(char[][] g, HashSet<String> d){
        grid = g;
        dictionary = d;
        state = new boolean[g.length][g.length];

        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g.length; ++j) {
                state[i][j] = false;
            }
        }
      }


      public HashSet<String> find_all_words(){
        HashSet<String> words = new HashSet<String>();
        StringBuilder current_word = new StringBuilder();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                find_words_rec(i, j, current_word, words);
            }
        }

        return words;
    }




    ArrayList<ArrayList<Integer>> find_all_nbrs(int x, int y)
           {
            ArrayList<ArrayList<Integer>> nbrs = new ArrayList<ArrayList<Integer>>();

            int start_x = Math.max(0, x - 1);
            int start_y = Math.max(0, y - 1);
            int end_x = Math.min(grid.length - 1, x + 1);
            int end_y = Math.min(grid.length - 1, y + 1);

            for (int i = start_x; i <= end_x; ++i) {
                for (int j = start_y; j <= end_y; ++j) {
                    if (state[i][j]) {
                        continue;
                    }
                    ArrayList temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    nbrs.add(temp);
                }
            }
            return nbrs;
        }

        void find_words_rec(int i, int j, StringBuilder current, HashSet<String> words) {

            if (current.length() > 0 && dictionary.contains(current.toString())) {
                words.add(current.toString());
            }


            ArrayList<ArrayList<Integer>> nbrs = find_all_nbrs(i, j);
            for (ArrayList<Integer> pr : nbrs) {

                current.append(grid[pr.get(0)][pr.get(1)]);
                state[pr.get(0)][pr.get(1)] = true;
                find_words_rec(pr.get(0), pr.get(1), current, words);
                current.setLength(current.length() - 1);
                state[pr.get(0)][pr.get(1)] = false;
            }

        }



        public static void main(String[] args){

            char[][] g1 = {{'c','a','t'},{'r','r','e'},{'t','o','n'}};
            HashSet<String> set1 = new HashSet<String>();
            set1.add("cat");
            set1.add("cater");
            set1.add("art");
            set1.add("toon");
            set1.add("moon");
            set1.add("not");
            set1.add("eat");
            set1.add("ton");

            Boggle obj = new Boggle(g1,set1);
            HashSet<String> answer = obj.find_all_words();
            System.out.println("hashset size "+answer.size());
            for(String s : answer){
                System.out.println(s);
            }
        }

    }

