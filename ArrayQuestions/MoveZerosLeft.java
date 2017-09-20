package ArrayQuestions;

/**
 * Created by Anna on 6/1/17.
 */
public class MoveZerosLeft {
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

        int zeros[] = {1,10,20,0,59,63,0,88,0};

        moveZerosLeft(zeros);

        for(int k : zeros)
            System.out.print(" "+ k);
    }
}
