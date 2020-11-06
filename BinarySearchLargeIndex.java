
public class BinarySearchLargeIndex {
	
	boolean binarySearch1(int arr[], int l, int r, int x) {
		//System.out.println("Inside second binary search");
		try {
			while(true) {
				for(int i = l ; i < r;i++) {
					if(arr[i] == x)
						return true;
					}
			}
		}
		catch(Exception e) {
			return false;
			
		}
	}

	boolean binarySearch(int arr[], int l, int r, int x)
    {
		try {
        if (r>=l)
        {
            int mid = l + (r - l)/2;
 
            // If the element is present at the 
            // middle itself
            if (arr[mid] == x)
               return true;
 
            // If element is smaller than mid, then 
            // it can only be present in left subarray
            if (arr[mid] > x)
               return binarySearch(arr, l, mid-1, x);
 
            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid+1, r*2, x);
        }
		}
		catch(Exception e) {
		
			System.out.println(" "+l +"  "+r );
			return binarySearch1(arr,l,r,x);
		}
 
        // We reach here when element is not present
        //  in array
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		BinarySearchLargeIndex obj = new BinarySearchLargeIndex();
		//binarySearch(a)
		boolean val = obj.binarySearch(a, 0, 2, 14);
		System.out.println(val);
		

	}

}
