package LinkedListQuestions;

/**
 * Created by Anna on 6/3/17.
 */
public class AddTwoIntegers {

    public static ListNode add_integers(ListNode integer1,ListNode integer2){
        ListNode result = null;
        ListNode last = null;
        int carry = 0;

        while(integer1 != null || integer2 != null || carry >0){

            int first =(integer1 == null ? 0: integer1.val);
            int second = (integer2 == null ? 0: integer2.val);
            int sum = first + second + carry;
            ListNode pNew = new ListNode(sum % 10);
            carry = sum/10;

            if(result == null)
                result = pNew;
            else
                last.next = pNew;

            last = pNew;

            if(integer1 != null)
                integer1 = integer1.next;

            if(integer2 != null)
                integer2 = integer2.next;


        }
        return result;


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

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(2);
        head2.next.next.next.next.next = new ListNode(6);
        head2.next.next.next.next.next.next = null;

        ListNode temp = add_integers(head1,head2);
        temp.printList(temp);






    }
}
