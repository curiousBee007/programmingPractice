package interview_cake;

/**
 * Created by Anna on 7/18/17.
 */
public class LuckyNumber {

    static boolean nextLucky(int x){

        int sumFirstThree = 0;
        int sumLastThree = 0;
        int digitArray[] = new int[6];
        int i = 5;
        while(x != 0){
            digitArray[i] = x%10;
            x = x/10;
            i = i-1;
        }

        sumFirstThree = digitArray[0] + digitArray[1] +digitArray[2];
        sumLastThree = digitArray[3] + digitArray[4] +digitArray[5];
        if(sumFirstThree == sumLastThree)
            return true;
        else
            return false;


    }

    static String onceInATram(int x) {
        // Complete this function
        int nextLucky1 = x;
        if(x == 999999)
            return Integer.toString(1000001);

        for(int i = x+1; i <999999;i++){
            if(nextLucky(i))
            {
                nextLucky1 = i;
                break;
            }
        }
        String str = Integer.toString(nextLucky1);
        return str;
    }

    public static void main(String[] args) {
        int x = 555555;
        String result = onceInATram(x);
        System.out.println(result);
    }
}
