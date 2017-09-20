package ArrayQuestions;

/**
 * Created by Anna on 5/31/17.
 */
public class Least_Common_Number {

    public static int find_least_common_number(int[] arr1, int[] arr2, int[] arr3){

        int i = 0,j=0,k=0;
        while(i < arr1.length && j < arr2.length && k<arr3.length){

            if(arr1[i] == arr2[j] && arr2[j] == arr3[k] && arr3[k] == arr1[i])
                return arr1[i];

            if(arr1[i] <= arr2[j] && arr1[i] <= arr3[k])
                i++;

            else if(arr2[j] <= arr1[i] && arr2[j] <= arr3[k])
                j++;

            else if(arr3[k] <= arr1[i] && arr3[k] <= arr2[j])
                k++;

        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr1 = {6,7,10,25,30,63,64};
        int[] arr2 = {-1,4,5,6,7,8,50};
        int[] arr3 = {1,6,10,14};

        int x = find_least_common_number(arr1,arr2,arr3);
        System.out.println(x);

    }

}
