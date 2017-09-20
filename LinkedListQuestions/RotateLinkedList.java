package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 */
public class RotateLinkedList {

    private static int find_length(ListNode head){
     int len = 0;
     while(head != null){
         len++;
         head = head.next;
     }
     return len;
    }

    private static int adjust_rotation(int n , int len){
        n = n%len;
        if(n <0){
            n = n +len;
        }
        return n;
    }

    public static ListNode rotate_List(ListNode head, int n){
       if(head == null || n == 0)
           return head;

       int len = find_length(head);
       n = adjust_rotation(n,len);

       if(n == 0)
           return head;

        /**
         *Find the start of the rotated list . If we have 1,2,3,4,5 where n =2
         *4 is the start of rotated list
         */
        int rotations_count = len -n -1;
       ListNode temp = head;

       while(rotations_count > 0){
           rotations_count--;
           temp = temp.next;
       }


       ListNode new_head = temp.next;

        temp.next = null;

        temp = new_head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = head;
        return new_head;


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


        ListNode temp1 = rotate_List(head1,2);
        printList(temp1);



    }

}
