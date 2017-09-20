package MathandStats;


/**
 * Created by Anna on 6/3/17.
 */
public class SquareRoot {

    private static final double EPSILON = 0.00001;

    public static double square_root_iterative(double num){

        double low = 0;
        double high = 1+ num/2;

        while(low < high){

            double mid = (low + high)/2;

            double sqr = mid * mid;

            double diff = Math.abs(num - sqr);

            if(diff <= EPSILON)
                return mid;

            if(sqr < num)
                low = mid;
            else
                high = mid;



        }

        return -1;

    }

    public static void main(String[] args){

        double num = 4.0;
        double x = square_root_iterative(num);

        System.out.println(x);

    }

}
