package LinkedListQuestions;

import java.util.HashMap;

/**
 * Created by Anna on 6/3/17.
 * Solution #1
 Runtime Complexity
 Linear, O(n).

 Memory Complexity
 Linear, O(n).
 *
 */
class ListNode1 {
    int val;
    ListNode1 next;
    ListNode1 arbit_pointer;

    ListNode1(int x) {
        val = x;
    }

    public void printList(ListNode1 x) {
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

public class CopyRandomPointer {

    //Using Hash code
    public static ListNode1 deep_copy_arbitrary_pointer1(ListNode1 head){

        if(head == null)
            return null;

        ListNode1 current = head;
        ListNode1 new_head = null;
        ListNode1 new_prev = null;

        HashMap<ListNode1,ListNode1> map = new HashMap<>();
        while(current != null){

            ListNode1 new_node = new ListNode1(current.val);
            //new_node.
            new_node.arbit_pointer = current.arbit_pointer;

            if(new_prev != null)
                new_prev.next = new_node;
            else
                new_head = new_node;

            map.put(current,new_node);

            new_prev = new_node;
            current = current.next;


        }
        ListNode1 new_current = new_head;
        while(new_current != null){

            if(new_current.arbit_pointer != null){
                ListNode1 node = map.get(new_current.arbit_pointer);
                new_current.arbit_pointer = node;
            }

            new_current = new_current.next;
        }

        return new_head;

    }

    //using 0(1) memory space
    public static ListNode1 deep_copy_arbitrary_pointer2(ListNode1 head){

        if(head == null)
            return null;

        ListNode1 current = head;

        //Inserting new nodes within the existing linkedlist

        while(current != null){
            ListNode1 new_node = new ListNode1(current.val);
            new_node.next = current.next;
            current.next = new_node;
            current = new_node.next;
        }
        //Setting correct arbitrary pointers
        current = head;

        while(current != null){

            /* Important trick of arbitrary pointer*/
            if(current.arbit_pointer != null) {
                current.next.arbit_pointer = current.arbit_pointer.next;
            }

            current = current.next.next;
        }

        //separating list
        current = head;
        ListNode1 new_head = head.next;
        ListNode1 copied_current = new_head;

        while(current != null){

            copied_current = current.next;
            current.next = copied_current.next;

            if(copied_current.next != null)
                copied_current.next = copied_current.next.next;


            current = current.next;
        }

        return new_head;

    }


    public static void main(String[] args){



    }
}
