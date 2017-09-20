package ArrayQuestions;

/**
 * Created by Anna on 6/1/17.
 * Solution
 Runtime Complexity
 Linearithmic, O(nlogn).

 Memory Complexity
 Logarithmic, O(logn).

 Recursive solution has O(logn) memory complexity as it will consume memory on the stack.
 */
public class QuickSort {

   static int partition(int[] arr, int low, int high){

       int pivot_value = arr[low];
       int i = low;
       int j = high;

       while(i < j){

        while(arr[i] <= pivot_value && i <= high) i++;
        while(arr[j] > pivot_value) j--;

        //We have to change the value
        if(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        else
            break;


       }

       arr[low] = arr[j];
       arr[j] = pivot_value;

       //j is our pivot_index
       return j;
   }

    static void quick_sort_rec(int[] arr, int low, int high){

       if(high > low){

           int pivot = partition(arr,low,high);
           quick_sort_rec(arr,low,pivot -1);
           quick_sort_rec(arr,pivot +1,high);


       }



   }



   public static void main(String[] args){

     int[] arr = {10,5,16,14,12,78};
       quick_sort_rec(arr,0,arr.length -1);
      for(int i : arr)
          System.out.print(" "+i);
   }

}
