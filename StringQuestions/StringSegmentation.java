package StringQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anna on 6/3/17.
 * Polynomial, O(n2).

 Memory Complexity
 Polynomial, O(n2).
 */
public class StringSegmentation {

    public static boolean can_segment_string(String s, Set<String> dict) {
        Set<String> solved = new HashSet<String>();
        return can_segment_string(s, dict, solved);
    }

    public static boolean can_segment_string(String s, Set<String> dict, Set<String> solved) {
        for (int i = 1; i <= s.length(); ++i) {
            String first = s.substring(0, i);
            if (dict.contains(first)) {
                String second = s.substring(i);

                if (second == null || second.length() == 0 || dict.contains(second)) {
                    return true;
                }

                if (!solved.contains(second)) {
                    if (can_segment_string(second, dict, solved)) {
                        return true;
                    }
                    solved.add(second);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {

        String s = "applepie1";
        String s1 = "apple";
        String s2 = "pear";
        String s3 = "pier";
        String s4 = "pie";

        Set<String> solved = new HashSet<String>();
        solved.add(s1);
        solved.add(s2);
        solved.add(s3);
        solved.add(s4);

        boolean val = can_segment_string(s, solved);
        System.out.println(val);

        //String s11 = "qwertyuiop";
        //System.out.println(s11.substring(2));



    }
}

