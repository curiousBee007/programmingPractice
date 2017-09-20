package interview_cake;

/**
 * Created by Anna on 7/4/17.
 * Write a class TempTracker with these methods:

 insert()—records a new temperature
 getMax()—returns the highest temp we've seen so far
 getMin()—returns the lowest temp we've seen so far
 getMean()—returns the mean ↴ of all temps we've seen so far
 getMode()—returns a mode ↴ of all temps we've seen so far
 Optimize for space and time. Favor speeding up the getter functions getMax(), getMin(), getMean(), and getMode() over speeding up the insert() function.

 getMean() should return a double, but the rest of the getter functions can return integers. Temperatures will all be inserted as integers. We'll record our temperatures in Fahrenheit, so we can assume they'll all be in the range 0..1100..110.

 If there is more than one mode, return any of the modes.
 */
public class tempTracker {



        // for mode
        private int[] occurrences = new int[111]; // array of 0s at indices 0..110
        private int maxOccurrences;
        private int mode;

        // for mean
        private int totalNumbers;
        private long totalSum;
        private double mean;

        // for min and max
        private int minTemp = Integer.MAX_VALUE;
        private int maxTemp = Integer.MIN_VALUE;

        public void insert(int temperature) {

            // for mode
            occurrences[temperature]++;
            if (occurrences[temperature] > maxOccurrences) {
                mode = temperature;
                maxOccurrences = occurrences[temperature];
            }

            // for mean
            totalNumbers++;
            totalSum += temperature;
            mean = (double) totalSum / totalNumbers;

            // for min and max
            minTemp = Math.min(minTemp, temperature);
            maxTemp = Math.max(maxTemp, temperature);
        }

        public int getMax() {
            return maxTemp;
        }

        public int getMin() {
            return minTemp;
        }

        public double getMean() {
            return mean;
        }

        public int getMode() {
            return mode;
        }
    }

