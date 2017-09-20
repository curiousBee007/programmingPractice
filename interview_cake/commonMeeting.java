package interview_cake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Anna on 7/3/17.
 * Write a function mergeRanges() that takes a list of meeting time ranges and returns a list of condensed ranges
 * [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
 *   [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
 */



public class commonMeeting {
    /*Write a function mergeRanges() that takes a list of meeting time ranges and returns a
    list of condensed ranges.*/
    /*O(nlgn) time and O(n)O(n) space.*/

    class Meeting {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }
    }

    public static List<Meeting> mergeRanges(List<Meeting> meetings) {

        // sort by start times
        List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
        Collections.sort(sortedMeetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2)  {
                return m1.startTime - m2.startTime;
            }
        });

        // initialize mergedMeetings with the earliest meeting
        List<Meeting> mergedMeetings = new ArrayList<Meeting>();
        mergedMeetings.add(sortedMeetings.get(0));

        for (Meeting currentMeeting : sortedMeetings) {

            Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

            // if the current and last meetings overlap, use the latest end time
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.endTime, currentMeeting.endTime));

                // add the current meeting since it doesn't overlap
            } else {
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;
    }


}
