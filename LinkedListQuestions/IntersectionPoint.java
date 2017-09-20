package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 */
public class IntersectionPoint {

    /*public static ListNode intersect(ListNode head1, ListNode head2){

        ListNode list1node = null;
        int list1length = get_length(head1);

        ListNode list2node = null;
        int list2length = get_length(head2);

        int length_difference = 0;
        if(list1length > list2length){
            length_difference = list1length - list2length;
            list1node = head1;
            list2node = head2;
        }
        else{
            length_difference = list2length - list1length;
            list1node = head2;
            list2node = head1;
        }

        while(length_difference > 0){
            list1node = list1node.next;
            length_difference--;
        }
        while(list1node != null){

            if(list1node == list2node)
                return list1node;

            list1node = list1node.next;
            list2node = list2node.next;

        }

        return null;

    }

    public static int get_length(ListNode head){
        int list_length = 0;
        while(head != null){
            head = head.next;
            list_length++;

        }

        return list_length;
    }*/


    //The logic doesn't make much sense
    int getNode(ListNode head1, ListNode head2) {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return _getIntesectionNode(d, head1, head2);
        } else {
            d = c2 - c1;
            return _getIntesectionNode(d, head2, head1);
        }
    }

    /* function to get the intersection point of two linked
     lists head1 and head2 where head1 has d more nodes than
     head2 */
    int _getIntesectionNode(int d, ListNode node1, ListNode node2) {
        int i;
        ListNode current1 = node1;
        ListNode current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.val == current2.val) {
                return current1.val;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    /*Takes head pointer of the linked list and
    returns the count of nodes in the list */
    int getCount(ListNode node) {
        ListNode current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }


    public static void main(String[] args){

        ListNode head1 = new ListNode(29);
        head1.next = new ListNode(23);
        head1.next.next = new ListNode(82);
        head1.next.next.next = new ListNode(11);
        head1.next.next.next.next = new ListNode(12);
        head1.next.next.next.next.next = new ListNode(27);
        head1.next.next.next.next.next.next = null;

        ListNode head2 = new ListNode(13);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(23);
        head2.next.next.next = new ListNode(28);
        head2.next.next.next.next = null;

        IntersectionPoint obj = new IntersectionPoint();
       int x1 = obj.getNode(head1,head2);
        System.out.println(x1);



    }
}
