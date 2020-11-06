
public class MaximumSumSequence {
	
	static int find_max_sum_sub_array(int[] A) {
        if (A.length < 1) {
            return 0;
        }

        int curr_max = A[0];
        int global_max = A[0];
        for (int i = 1; i < A.length; i++) {

            if (curr_max < 0) {
                curr_max = A[i];
            }
            else {
                curr_max += A[i];
            }

            if (global_max < curr_max) {
                global_max = curr_max;
            }
        }

        return global_max;
    }

    public static void main(String[] args){

        int[] A = {-10,+20,-30};
        int global_max = find_max_sum_sub_array(A);
        System.out.println(global_max);

    }


	

}
