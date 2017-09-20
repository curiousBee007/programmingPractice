package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 */
public class ReverseKElements {

    public static ListNode reverse_k_nodes(ListNode head, int k){

        if(k <= 1 || head == null)
            return head;

        ListNode reversed = null;
        ListNode prev_Tail = null;

        while(head != null && k > 0){
            ListNode current_head = null;
            ListNode current_tail = head;
            int n = k;

            while(head != null && n > 0){
                ListNode temp = head.next;
                head.next = current_head;
                current_head = head;
                head = temp;
                n--;
            }

            if(reversed == null)
                reversed = current_head;

            if(prev_Tail != null)
                prev_Tail.next = current_head;

            prev_Tail = current_tail;



        }



        return reversed;
    }

    public static void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args){

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = null;


        ListNode temp1 = reverse_k_nodes(head1,3);
        printList(temp1);

    }

}
