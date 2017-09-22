package interview_cake;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Anna on 7/7/17.
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2]
 */
public class WiggleSort {

    static class PQsort implements Comparator<Integer> {
        public int compare(Integer one, Integer two) {
            return two - one;
        }
    }


    public static void wiggleSort(int[] nums) {

        if(nums == null)
            return;

        int length = nums.length;

        if(length == 0)
            return;

        PQsort pqs = new PQsort();

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(length, pqs);

        for(Integer i : nums){
            pq2.offer(i);
        }

        /*while(!pq2.isEmpty()){
            System.out.print(" "+pq2.poll());
        }*/

        int maxCount = length/2;
        //int answerArray = new int[length];
        for(int i = 1; i < length; i = i +2){
            nums[i] = pq2.poll();
        }
        for(int j = 0; j < length; j = j +2){
            nums[j] = pq2.poll();
        }

        for(int i = 0 ; i < length;i++){
            System.out.print("  "+nums[i]);
        }

    }

    public static void main(String[] args){

        int nums[] = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
    }
}
