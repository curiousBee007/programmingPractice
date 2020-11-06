
public class QuickSort {
	
static void swap(int arr[], int i , int j) {
		int temp = arr[i];
		  arr[i] = arr[j];
		  arr[j] = temp;
	}
	
	
public static int partition(int [] arr, int left, int right)
	{
	    //It considers last element as pivot and moves all smaller elements to the left of it and greater
	    //elements to the right
		int x = arr[right], i = left;
		for (int j = left; j <= right - 1; j++){
			if (arr[j] <= x)
			{
				swap(arr, i ,j);
				i = i+1;
			}
			}
	      swap(arr,i, right);
	      return i;
    }


static void quick_sort_rec(int[] arr, int low, int high) {
	  if (low < high) {
	    int pivot_index = partition(arr, low, high);
	    quick_sort_rec(arr, low, pivot_index - 1);
	    quick_sort_rec(arr, pivot_index + 1, high);
	  }
	}

	static void quick_sort(int[] arr) {
	  quick_sort_rec(arr, 0, arr.length - 1);
	}

public void 	printArray(int arr[]) {
	
	for(Integer i : arr) {
		System.out.print(" "+i);
	}
	System.out.println();
}
	

  
public void findKMain(int arr[]){

  int start = 0;
  int end = arr.length -1;
  //int max[] = new int[]{-1};
  quick_sort_rec(arr,start,end);
  printArray(arr);
}  

public static void main(String[] args) {
		// TODO Auto-generated method stub
	int a[] = {8,9,10,1,2,3,4,5,6,7};
	
	QuickSort obj = new QuickSort();
	obj.findKMain(a);
}

}
