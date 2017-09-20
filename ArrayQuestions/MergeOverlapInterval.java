package ArrayQuestions;

import java.util.ArrayList;

/**
 * Created by Anna on 6/1/17.
 */
public class MergeOverlapInterval {

    public static class Tuple{
        int x;
        int y;
        Tuple(int x,int y){
            this.x = x;
            this.y = y;
        }

    }

    public static ArrayList<Tuple> mergeIntervals(ArrayList<Tuple> v1) {

        if(v1 == null || v1.size() == 0)
            return null;

        ArrayList<Tuple> v2 = new ArrayList<>();
        v2.add(v1.get(0));

        for(int i = 1; i < v1.size();i++){

            int x1 = v1.get(i).x;
            int y1 = v1.get(i).y;

            int x2 = v2.get(v2.size() -1).x;
            int y2 = v2.get(v2.size() -1).y;

            //Overlapping interval (The ending time in our result list is greater than the starting time of element which
            // is currently examined then the result will be displayed)
            if(y2 >= x1)
                v2.get(v2.size() -1).y =Math.max(y1,y2);
            else
                v2.add(new Tuple(x1,y1));

        }
        return v2;

    }

    public static void main(String[] args){
       Tuple obj1 = new Tuple(1,5);
       Tuple obj2 = new Tuple(3,7);
       Tuple obj3 = new Tuple(4,6);
       Tuple obj4 = new Tuple(6,8);

        ArrayList<Tuple> v1 = new ArrayList<>();
        v1.add(obj1);
        v1.add(obj2);
        v1.add(obj3);
        v1.add(obj4);

        ArrayList<Tuple> v2 = mergeIntervals(v1);
        for(Tuple x1 : v2){
            System.out.print(" "+x1.x + " "+x1.y);
            System.out.println();
        }



    }


}
