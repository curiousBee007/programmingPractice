package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void printList(ListNode x) {
        if(x != null){
            System.out.print(x.val + " ");
            while (x.next != null) {
                System.out.print(x.next.val + " ");
                x = x.next;
            }
            System.out.println();
        }

    }
}


public class LinkedListReverse {

    //Iterative beats 35.5%
        /*public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null)
                return head;

            ListNode list_to_do = head.next;
            ListNode reverse_list = head;
            reverse_list.next = null;


            while(list_to_do != null){
                ListNode temp = list_to_do;
                list_to_do = list_to_do.next;

                temp.next = reverse_list;
                reverse_list = temp;

            }
            return reverse_list;

        }*/

        public ListNode reverseList(ListNode head){
      if(head == null || head.next == null)
         return head;

        ListNode reverse_head = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reverse_head;
      }



}
