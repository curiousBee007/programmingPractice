class Node1 {
	 int data;
	 Node1 next, prev;
	
	 Node1(int d) 
	 {
	     data = d;
	     next = prev = null;
	   }
 }
	 
public class ReverseDoublyLinkedList {
	
	 /* Function to reverse a Doubly Linked List */
	    Node1 reverse(Node1 head) {
	        Node1 temp = null;
	        Node1 current = head;
	 
	        /* swap next and prev for all nodes of 
	         doubly linked list */
	        while (current != null) {
	            temp = current.prev;
	            current.prev = current.next;
	            current.next = temp;
	            current = current.prev;
	        }
	 
	        /* Before changing head, check for the cases like empty 
	         list and list with only one node */
	        if (temp != null) {
	            head = temp.prev;
	        }
	        return head;
	    }
	 
	    
	    public static void main(String[] args) {
	    	 ReverseDoublyLinkedList list = new ReverseDoublyLinkedList();
	 
	        /* Let us create a sorted linked list to test the functions
	         Created linked list will be 10->8->4->2 */
	    	    Node1 head = new Node1(2);
	        //list.push(2,head);
	        
	    }

	

}
