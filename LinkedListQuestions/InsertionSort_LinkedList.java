package LinkedListQuestions;

/**
 * Created by Anna on 6/2/17.
 * Solution
 Runtime Complexity
 Polynomial, O(n2).

 Memory complexity
 Constant, O(1)

 Concept of Insertion Sort is very simple. We'll maintain two linked lists:

 Original list (given to us as input).
 Sorted list (initially empty).
 Here is how the algorithm works.
 While Original list is not empty:
 Remove an element (say 'X') from the Original list.
 Insert 'X' at correct sorted position in the Sorted list.
 *
 *
 */
public class InsertionSort_LinkedList {

    public static ListNode sorted_insert(ListNode head, ListNode node){

      if(node == null)
          return head;

      if(head == null || node.val <= head.val)
      {
          node.next = head;
          return node;
      }

      ListNode curr = head;
      while(curr.next != null && curr.next.val  < node.val)
      {curr = curr.next;
      }

      node.next = curr.next;
      curr.next = node;
      return head;
    }


    //Insertion sort code
    public static ListNode insertion_sort(ListNode head){

        ListNode sorted = null;
        ListNode curr = head;

        while(curr != null){
           ListNode temp = curr.next;
           sorted = sorted_insert(sorted,curr);
           curr = temp;

        }


        return sorted;
    }


}
