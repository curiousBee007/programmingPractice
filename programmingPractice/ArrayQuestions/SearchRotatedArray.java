package ArrayQuestions;

/**
 * Created by Anna on 5/31/17.
 */

/*Logarithmic, O(logn).
We can make the search iterative to get constant memory complexity.

The solution is essentially binary search with some modifications.
If we look at the array in example closely, we notice that at least one half of the array
is always sorted. We can use this property to our advantage. If the number n lies
within the sorted half of the array then our problem is basic binary search.
Otherwise discard the sorted half and keep examining the unsorted part.
Since we are partitioning array in half at each step this gives us O(logn) runtime complexity.*/
public class SearchRotatedArray {


    public static int findRotatedArray(int[] arr, int start, int end ,int key){
        if(start > end)
            return -1;

        int mid = start + (end - start)/2;
        if(arr[mid] == key)
            return mid;

        if(arr[start] < arr[mid] && key >= arr[start] && key < arr[mid])
            return findRotatedArray(arr,start,mid -1,key);

        else if(arr[mid] < arr[end] && key > arr[mid] && key <= arr[end])
            return findRotatedArray(arr,mid +1,end,key);

        else if(arr[start] > arr[mid] )
            return findRotatedArray(arr,start,mid -1,key);

        else if(arr[end] < arr[mid] )
            return findRotatedArray(arr,mid + 1,end,key);


        return -1;
    }

    public static void main(String[] args){

        int zeros[] = {10,20,30,1,2,3,4,5,6};

        int x = findRotatedArray(zeros,0, zeros.length -1,5);
        System.out.println(x);


    }
}
