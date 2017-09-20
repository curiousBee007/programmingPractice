package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 6/12/17.
 */
public class PrintAllParenthesis {

    static void print_list(List<Character> l) {
        for (Character c : l) {
            System.out.print(c);
        }
        System.out.println();
    }

    static void print_all_parentheses_rec(
            int n,
            int left_count,
            int right_count,
            List<Character> output) {

        if (left_count >= n && right_count >=n) {
            print_list(output);
        }

        if (left_count < n) {
            output.add('{');
            print_all_parentheses_rec(
                    n, left_count + 1, right_count, output);
            output.remove(output.size() - 1);
        }

        if (right_count < left_count) {
            output.add('}');
            print_all_parentheses_rec(
                    n, left_count, right_count + 1, output);
            output.remove(output.size() - 1);
        }
    }

    static void print_all_parentheses(int n) {
        List<Character> output = new ArrayList<Character>();
        print_all_parentheses_rec(n, 0, 0, output);
    }

    public static void main(String[] args){
        print_all_parentheses(3);
    }
}
