package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Anna on 6/12/17.
 */
public class KSumSubsets {

    static int get_bit(int num, int bit) {
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    static void get_k_sum_subsets_1(List<Integer> v, Integer target_sum, List<HashSet<Integer>> sets) {
        int subsets_count = (int)(Math.pow((double)2, (double)v.size()));
        for (int i = 0; i < subsets_count; ++i) {
            HashSet<Integer> set = new HashSet<Integer>();
            Integer sum = 0;

            for (int j = 0; j < v.size(); ++j) {
                if (get_bit(i, j) == 1) {
                    sum += v.get(j);
                    if (sum > target_sum) {
                        break;
                    }
                    set.add(v.get(j));
                }
            }
            if (sum == target_sum) {
                sets.add(set);
            }
        }
    }
    public static void main(String[] args){

        Integer target_sum = 5;
        List<Integer> v = new ArrayList<Integer>();
        v.add(2);
        v.add(3);
        v.add(1);
        v.add(4);
        List<HashSet<Integer>> sets = new ArrayList<HashSet<Integer>>();


    }

}
