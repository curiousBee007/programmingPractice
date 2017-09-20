package MathandStats;

/**
 * Created by Anna on 6/3/17.
 */
public class PowerNumber {

    public static double power_rec(double x, int n){

        if(n == 0)return 1;
        if(n == 1)return x;

        double temp = power_rec(x,n/2);

        if(n%2 == 0)
            return temp *temp;
        else
            return x *temp *temp;


    }

    public static double power(double x , int n){

        boolean is_negative = false;

        if(n < 0){
            is_negative = true;
            n*= -1;
        }
        double result = power_rec(x,n);

        if(is_negative)
            return 1/result;

         return result;

    }

    public static void main(String[] args){

        double num = 4.0;
        double x = power(num,4);

        System.out.println(x);

    }


}
