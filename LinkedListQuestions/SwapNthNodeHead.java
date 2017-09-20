package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 */
public class SwapNthNodeHead {

    public static ListNode swapNthNode(ListNode head,int n){

        ListNode prev = null;
        ListNode current = head;

        if(head == null || n <= 1)
            return head;

        for(int count = 1; current != null && count < n;count++){
            prev = current;
            current = current.next;
        }

        if(current == null)
            return head;

        //Current is pointing towards nth node
        prev.next = head;
        //Swapping nth node and current node
        ListNode temp = head.next;
        head.next = current.next;
        current.next = temp;


        return current;


    }

    public static void main(String[] args){

        ListNode head1 = new ListNode(29);
        head1.next = new ListNode(23);
        head1.next.next = new ListNode(82);
        head1.next.next.next = new ListNode(11);
        head1.next.next.next.next = new ListNode(12);
        head1.next.next.next.next.next = new ListNode(27);
        head1.next.next.next.next.next.next = null;


        ListNode x1 = swapNthNode(head1,3);
        System.out.println(x1.val);



    }
}
