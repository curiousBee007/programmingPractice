package ArrayQuestions;

import java.util.ArrayDeque;

/**
 * Created by Anna on 5/31/17.
 */
public class SlidingWindowMax {

    public static void find_max_sliding_window(int[] array, int window_size) {

        if(array.length < window_size) {
            return;
        }

        ArrayDeque<Integer> window = new ArrayDeque<Integer>();

        //find out max for the first window
        for(int i=0 ; i<window_size ; i++) {

            while(!window.isEmpty()
                    && array[i] >= array[window.peekLast()] ) {
                window.removeLast();
            }

            window.addLast(i);
        }

        System.out.print(array[window.peekFirst()] + ", ");

        for(int i= window_size; i<array.length; i++) {

            //remove all numbers that are smaller than current number
            //from the tail of queue
            while(!window.isEmpty()
                    && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }

            //remove first number if it doesn't fall in the window anymore
            if(!window.isEmpty() && window.peekFirst() <= i - window_size) {
                window.removeFirst();
            }

            window.addLast(i);

            System.out.print(array[window.peekFirst()] + ", ");
        }
    }


    //Runtime complexity : Linear O(n) , Memory complexity : Constant O(1)
    /*while moving read_index towards the start of the array:
    *  if read_index points to '0' ,skip
    *  if read_index points to non-zero , write to write_index and decrement write_index
    *
    * */
    static void moveZerosLeft(int arr[]){

        int length = arr.length;
        int writeIndex = length -1;
        int readIndex = length -1;

        while(readIndex != -1){
            if(arr[readIndex] == 0){
                readIndex--;
                continue;
            }
            else{
                arr[writeIndex] = arr[readIndex];
                writeIndex --;
                readIndex --;
            }
        }

        for(int i = 0; i <= writeIndex;i++){
            arr[i] = 0;
        }


    }


    public static void main(String[] args){

        //Run time complexity : Linear O(n)
        //Memory complexity : O(w)

        int a[] = {1,2,3,4,5};
        int window_size = 3;
        //Output window size = {2,3,6}
        find_max_sliding_window(a,3);
        System.out.println();

        int zeros[] = {1,10,20,0,59,63,0,88,0};

        moveZerosLeft(zeros);

        for(int k : zeros)
            System.out.print(" "+ k);
    }

}
