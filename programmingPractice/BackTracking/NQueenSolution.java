package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 6/12/17.
 */
public class NQueenSolution {

    // this method determines if a queen can
// be placed at proposed_row, proposed_col
// with current solution i.e. this move
// is valid only if no queen in current
// solution should attacked square at
// proposed_row and proposed_col
    static boolean is_valid_move(int proposed_row, int proposed_col, List<Integer> solution) {
        // we need to check with all queens
        // in current solution
        for (int i = 0; i < proposed_row; ++i) {
            int old_row = i;
            int old_col = solution.get(i);

            int diagonal_offset = proposed_row - old_row;
            if (old_col == proposed_col ||
                    old_col == proposed_col - diagonal_offset ||
                    old_col == proposed_col + diagonal_offset) {
                return false;
            }
        }

        return true;
    }

    static void solve_n_queens_rec(int n, List<Integer> solution, int row, List<List<Integer>> results) {

        if (row == n) {
            results.add(new ArrayList<Integer>(solution));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (is_valid_move(row, i, solution)) {
                solution.set(row, i);
                solve_n_queens_rec(n, solution, row + 1, results);
            }
        }
    }


    static void solve_n_queens(int n, List<List<Integer>> results) {

        List<Integer> solution = new ArrayList<Integer>(n);
        for (int i = 0; i < n; ++i) {
            solution.add(-1);
        }
        solve_n_queens_rec(n, solution, 0, results);

        /*for(List<Integer> l1 : results){
            for(Integer l2 : l1){
                System.out.print(" "+l2);
            }
           System.out.println();
        }*/
    }
    public static void main(String[] args){

        List<List<Integer>> results = new ArrayList<>();
        solve_n_queens(5,results);

    }
}
