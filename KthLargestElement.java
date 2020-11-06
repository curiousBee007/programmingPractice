
public class KthLargestElement {
	
	static void swap(int arr[], int i , int j) {
		int temp = arr[i];
		  arr[i] = arr[j];
		  arr[j] = temp;
	}
	
	
public static int partition(int[] arr, int low, int right)
	{
	    //It considers last element as pivot and moves all smaller elements to the left of it and greater
	    //elements to the right
		int x = arr[right], i = low;
		for (int j = low; j <= right - 1; j++){
			if (arr[j] <= x)
			{
				swap(arr, i ,j);
				i = i+1;
				}
			}
	      swap(arr,i, right);
	      return i;
    }


//This function returns k'th smallest element 
// in arr[l..r] using QuickSort based method. 
// ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
public static int kthSmallest(int[] arr, int l, 
                                     int r, int k)
{
    // If k is smaller than number of elements
    // in array
    if (k > 0 && k <= r - l + 1)
    {
        // Partition the array around last 
        // element and get position of pivot 
        // element in sorted array
        int pos = partition(arr, l, r);

        // If position is same as k
        if (pos-l == k-1)
            return arr[pos];
        
        // If position is more, recur for
        // left subarray
        if (pos-l > k-1) 
            return kthSmallest(arr, l, pos-1, k);
        // Else recur for right subarray
        return kthSmallest(arr, pos+1, r, l+ k-pos-1);
    }

    // If k is more than number of elements
    // in array
    return Integer.MAX_VALUE;
}

	   
	public int findKMain(int arr[], int k){

	   int start = 0;
	   int end = arr.length -1;
		return kthSmallest(arr,start,end ,k);
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {8,9,10,1,2,3,4,5,6,7};
	    int k = 1;
	    int kthLargest = a.length - k +1;
		KthLargestElement obj = new KthLargestElement();
		int x = obj.findKMain(a,kthLargest);
		System.out.println(x);

	}

}
