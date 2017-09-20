package MathandStats;

import java.util.List;

/**
 * Created by Anna on 6/3/17.
 */
public class findKthPermutation {

    public static int factorial(int n){
        if(n== 0 || n == 1)
            return 1;
        return n * factorial(n-1);
    }

    public static void find_kth_permutation(List<Character> v , int k, StringBuilder result){

        if(v.isEmpty())
            return;

        int n = v.size();
        int count = factorial(n-1);
        int selected = (k-1)/count;

        result.append(v.get(selected));
        v.remove(selected);

        k = k - (count * selected);

        find_kth_permutation(v,k,result);
    }


}
