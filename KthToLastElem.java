
public class KthToLastElem {
	
	public Node FindKthToLast(int k ,Node head)
	{
	    Node fastPointer = head;
	    Node slowPointer =head;
	    //first advance k
	    int i = 0;
	    for (; i < k && fastPointer != null; i++)
	    {
	    	fastPointer = fastPointer.next;
	    }
	    if (fastPointer == null && i < k)
	    {
	        // the list is too small, we reached the end of the list
	        // and we did not find k elements, fail here.
	        return null;
	    }

	    //move the pointer to the end, sk moves with it
	    while (fastPointer != null)
	    {
	    	    fastPointer = fastPointer.next;
	    	    slowPointer = slowPointer.next;
	    }
	    return slowPointer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
