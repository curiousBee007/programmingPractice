package interview_cake;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anna on 7/3/17.
 * Write a function that, given:

 an amount of money
 an array of coin denominations
 computes the number of ways to make the amount of money with coins of the available denominations.

 Example: for amount=44 (44¢) and denominations=[1,2,3][1,2,3] (11¢, 22¢ and 33¢), your program would output
 44—the number of ways to make 44¢ with those denominations:

 1¢, 1¢, 1¢, 1¢
 1¢, 1¢, 2¢
 1¢, 3¢
 2¢, 2¢
 *
 */
public class coinDenomination {

    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    private static int changePossibilitiesTopDown(int amountLeft, int[] denominations, int currentIndex) {

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) {
            return 1;
        }

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) {
            return 0;
        }

        // we're out of denominations
        if (currentIndex == denominations.length) {
            return 0;
        }

        System.out.println(String.format("checking ways to make %d with %s",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        currentIndex, denominations.length))));

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown(amountLeft, denominations,
                    currentIndex + 1);
            amountLeft -= currentCoin;
        }

        return numPossibilities;
    }


    private Map<String, Integer> memo = new HashMap<String, Integer>();

    public int changePossibilitiesTopDown1(int amount, int[] denominations) {
        return changePossibilitiesTopDown1(amount, denominations, 0);
    }
    /*It certainly solves our duplicate work problem. It takes O(n*m)O(n∗m) time and O(n*m)O(n∗m) space, where nn is the size of
    amount and m is the number of items in denominations. */
    private int changePossibilitiesTopDown1(int amountLeft, int[] denominations, int currentIndex) {

        // check our memo and short-circuit if we've already solved this one
        String memoKey = amountLeft + ", " + currentIndex;
        if (memo.containsKey(memoKey)) {
            System.out.println("grabbing memo [" + memoKey + "]");
            return memo.get(memoKey);
        }

        // base cases:
        // we hit the amount spot on. yes!
        if (amountLeft == 0) return 1;

        // we overshot the amount left (used too many coins)
        if (amountLeft < 0) return 0;

        // we're out of denominations
        if (currentIndex == denominations.length) return 0;

        System.out.println(String.format("checking ways to make %d with %s",
                amountLeft, Arrays.toString(Arrays.copyOfRange(denominations,
                        currentIndex, denominations.length))));

        // choose a current coin
        int currentCoin = denominations[currentIndex];

        // see how many possibilities we can get
        // for each number of times to use currentCoin
        int numPossibilities = 0;
        while (amountLeft >= 0) {
            numPossibilities += changePossibilitiesTopDown1(amountLeft, denominations,
                    currentIndex + 1);
            amountLeft -= currentCoin;
        }

        // save the answer in our memo so we don't compute it again
        memo.put(memoKey, numPossibilities);
        return numPossibilities;
    }


    //bottom up O(n∗m) time and O(n)O(n) additional space, where nn is the amount of
    // money and mm is the number of potential denominations.
    public static int changePossibilitiesBottomUp(int amount, int[] denominations) {
        int[] waysOfDoingNCents = new int[amount + 1]; // array of zeros from 0..amount
        waysOfDoingNCents[0] = 1;

        for (int coin : denominations) {
            for (int higherAmount = coin; higherAmount <= amount; higherAmount++) {
                int higherAmountRemainder = higherAmount - coin;
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder];
            }
        }

        return waysOfDoingNCents[amount];
    }

}
