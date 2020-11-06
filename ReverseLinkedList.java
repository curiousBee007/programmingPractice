class Node {
	 
	        int data;
	        Node next;
	 
	        Node(int d) {
	            data = d;
	            next = null;
	        }
}

public class ReverseLinkedList {
/* Function to reverse the linked list */
	    Node reverse(Node node) {
	        Node prev = null;
	        Node current = node;
	        Node next = null;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        //node = prev;
	        return prev;
	    }
	 
	    // prints content of double linked list
	    static void printList(Node node) {
	        while (node != null) {
	            System.out.print(node.data + " ");
	            node = node.next;
	        }
	    }
	    
	    public static int mystery(int n) {
	    	if(n<= 0)
	    		return 1;
	    	 return mystery(n-1);
	    }
	 
	    public static void main(String[] args) {
	     	ReverseLinkedList list = new ReverseLinkedList();
	        Node root = new Node(85);
	        root.next = new Node(15);
	        root.next.next = new Node(4);
	        root.next.next.next = new Node(20);
	         
	        System.out.println("Given Linked list");
	        printList(root);
	        
	        Node reverseHead = list.reverse(root);
	        System.out.println("");
	        System.out.println("Reversed linked list ");
	        printList(reverseHead);
	        
	        mystery(100);
	    }

	

}
