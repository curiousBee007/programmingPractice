package interview_cake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna on 7/7/17.
 */
public class numDisapperaedArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }


        for(int i = 0; i < nums.length; i++) {
            System.out.print("  "+nums[i]);
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }

    public static void main(String[] args){

        int []nums = {4,3,2,7,8,2,3,1};
        findDisappearedNumbers(nums);
    }


}
