package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 *
 * Hints
 Use two iterators to scan both lists.
 Solution
 Runtime Complexity
 Linear, O(m + n) where m and n are lengths of both linked lists.

 Memory complexity
 Constant, O(1)

 We maintain a head and tail pointer of the merged linked list. We choose the head of the merged linked list by comparing the first node of both linked lists. For all subsequent nodes in both lists we similarly choose the smaller current node and link it to tail of the merged list and move the current pointer of that list one step forward.

 We keep doing this while there are some remaining elements in both the lists. If there are still some elements in only one of the lists, we link this remaining list to the tail of the merged list.

 Initially merged linked list is NULL

 Merge sort of list
 */
public class MergeLinkedList {

    /*public static ListNode merge_sorted(ListNode head1, ListNode head2){

        if(head1 == null )
            return head2;
        else if(head2 == null)
            return head1;

        ListNode mergedHead = null;
        if(head1.val <= head2.val)
        {
            mergedHead = head1;
            head1 = head1.next;
        }
        else{
            mergedHead = head2;
            head2 = head2.next;
        }
        ListNode mergedTail = mergedHead;
        while(head1 != null && head2 != null){
            ListNode temp = null;
            if(head1.val <= head2.val){
                temp = head1;
                head1 = head1.next;
            }
            else{
                temp = head2;
                head2 = head2.next;
            }
            mergedTail.next = temp;
            mergedTail = temp;
        }
        if(head1 != null)
            mergedTail.next = head1;
        else if(head2 != null)
            mergedTail.next = head2;

        return mergedHead;
    }*/
    // merge sort
    public static ListNode mergeSortList(ListNode head) {

        if (head == null || head.next == null)
            return head;

        // count total number of elements
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        // break up to two list
        int middle = count / 2;

        ListNode l = head, r = null;
        ListNode p2 = head;
        int countHalf = 0;
        while (p2 != null) {
            countHalf++;
            ListNode next = p2.next;

            if (countHalf == middle) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }

        // now we have two parts l and r, recursively sort them
        ListNode h1 = mergeSortList(l);
        ListNode h2 = mergeSortList(r);

        // merge together
        ListNode merged = merge(h1, h2);

        return merged;
    }

    public static ListNode merge(ListNode l, ListNode r) {
        ListNode p1 = l;
        ListNode p2 = r;

        ListNode fakeHead = new ListNode(100);
        ListNode pNew = fakeHead;

        while (p1 != null || p2 != null) {

            if (p1 == null) {
                pNew.next = new ListNode(p2.val);
                p2 = p2.next;
                pNew = pNew.next;
            } else if (p2 == null) {
                pNew.next = new ListNode(p1.val);
                p1 = p1.next;
                pNew = pNew.next;
            } else {
                if (p1.val < p2.val) {
                    // if(fakeHead)
                    pNew.next = new ListNode(p1.val);
                    p1 = p1.next;
                    pNew = pNew.next;
                } else if (p1.val == p2.val) {
                    pNew.next = new ListNode(p1.val);
                    pNew.next.next = new ListNode(p1.val);
                    pNew = pNew.next.next;
                    p1 = p1.next;
                    p2 = p2.next;

                } else {
                    pNew.next = new ListNode(p2.val);
                    p2 = p2.next;
                    pNew = pNew.next;
                }
            }
        }

        // printList(fakeHead.next);
        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);

        ListNode n4 = new ListNode(30);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n1 = mergeSortList(n1);

        printList(n1);
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
}
