package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 */
public class ReverseEvenNodes {

    public static ListNode merge_alternating(ListNode list1, ListNode list2){

        if(list1 == null)
            return list2;

        if(list2 == null)
            return list2;

        ListNode head = list1;
        while(list1.next != null && list2 != null){
            ListNode temp = list2;
            list2 = list2.next;

            temp.next = list1.next;
            list1.next = temp;
            list1 = temp.next;

        }
        if(list1.next == null)
            list1.next = list2;

        return head;

    }



    public static ListNode reverse_even_nodes(ListNode head){

        ListNode curr = head;
        ListNode list_even = null;

        while(curr != null && curr.next != null){

            ListNode even = curr.next;
            curr.next = even.next;

            //Push at the head of a new list
            even.next = list_even;
            list_even = even;

            curr = curr.next;
        }

        /*now merge the two lists
        * Original : 1,2,3,4,5
        * Modified original : 1,3,5
        * List_even : 4,2
        * Merged : 1,4,3,2,5*/

        return merge_alternating(head,list_even);

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


        ListNode temp1 = reverse_even_nodes(head1);
        printList(temp1);



    }

}
