package ArrayQuestions;

/**
 * Created by Anna on 7/24/17.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int len1 = digits.length;
        int arr1[] = new int[len1+1];
        //int j = len1;
        int sum = 0;
        int carry = 0;
        int i = len1 -1;
        int k = i+1;

        sum = 1+digits[len1 -1];

        carry = sum/10;

        digits[i] = sum % 10;

        arr1[len1] = sum % 10;

        if(carry == 0)
            return digits;
        if(carry > 0 && len1 == 1){
            arr1[0] = carry;
            return arr1;
        }

        while(carry > 0 && i > 0){

            sum = digits[i - 1] + carry;
            carry = sum /10;
            sum = sum % 10;

            arr1[k] = sum;
            k = k -1;

            i = i -1;

            digits[i] = sum;

            if(carry == 0){

                return digits;
            }
            if(carry > 0 && i == 0){

                arr1[0] = carry;
                return arr1;
            }

        }


        return arr1;


    }

    public static void main(String[] args){
        PlusOne obj = new PlusOne();
        int a[] = {9,8,9};
        int sol[] = obj.plusOne(a);
        for(int i : sol){
            System.out.print(" "+i);
        }

    }



}
