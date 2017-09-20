package interview_cake;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Anna on 7/4/17.
 */
public class twoSum {

    //O(n) time, and O(n)O(n) space. Note while optimizing runtime we added a bit of space cost.
    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // movie lengths we've seen so far
        Set<Integer> movieLengthsSeen = new HashSet<Integer>();

        for (int firstMovieLength : movieLengths) {

            int matchingSecondMovieLength = flightLength - firstMovieLength;
            if (movieLengthsSeen.contains(matchingSecondMovieLength)) {
                return true;
            }

            movieLengthsSeen.add(firstMovieLength);
        }

        // we never found a match, so return false
        return false;
    }





}
