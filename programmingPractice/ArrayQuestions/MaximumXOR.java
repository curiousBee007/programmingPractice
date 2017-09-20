package ArrayQuestions;

import java.util.HashSet;

/**
 * Created by Anna on 7/24/17.
 */
public class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> set = new HashSet<Integer>();

            for (int num : nums) {
                //System.out.println(num & mask);
                set.add(num & mask); // reserve Left bits and ignore Right bits
            }

            /* Use 0 to keep the bit, 1 to find XOR
             * 0 ^ 0 = 0
             * 0 ^ 1 = 1
             * 1 ^ 0 = 1
             * 1 ^ 1 = 0
             */
            // now find out if there are two prefix with different i-th bit
            // if there is, the new max should be current max with one 1 bit at i-th position, which is candidate
            // and the two prefix, say A and B, satisfies:
            // A ^ B = candidate
            // so we also have A ^ candidate = B or B ^ candidate = A
            // thus we can use this method to find out if such A and B exists in the set
            int tmp = max | (1 << i); // in each iteration, there are pair(s) whoes Left bits can XOR to max
            //System.out.println(tmp);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        int a[] = {3, 10, 5, 25, 2, 8};
        MaximumXOR obj = new MaximumXOR();
        int max = obj.findMaximumXOR(a);
        System.out.println(max);

    }
}
