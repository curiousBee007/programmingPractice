package ArrayQuestions;

/**
 * Created by Anna on 6/1/17.
 */
public class maximumKadane {
    int global_profit;
    int global_sell;

    public void maximumSellProfit(int arr[]){
        int curr_buy = arr[0];
        global_sell = arr[1];
        int current_profit = Integer.MIN_VALUE;
        global_profit = global_sell - curr_buy;

        for(int i = 1; i < arr.length;i++)
        {
            current_profit = arr[i] - curr_buy;
            if(current_profit > global_profit)
            {
                global_profit = current_profit;
                global_sell = arr[i];
            }

            if(arr[i] < curr_buy)
                curr_buy = arr[i];
        }


    }

    public static void main(String[] args){
        maximumKadane obj = new maximumKadane();
        int[] arr = {12,5,9,19};
        obj.maximumSellProfit(arr);

        System.out.println(" Global sell "+obj.global_sell);
        System.out.println(" Global profit "+obj.global_profit);


    }
}
