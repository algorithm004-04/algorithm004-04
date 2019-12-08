//Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
//
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
// Related Topics Array Sort

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wangchuande
 * @Date: 2019/10/20 20:37
 */
public class LeetCode_56_314 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1)
                return intervals;

            // Sort by ascending starting point
            Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

            List<int[]> result = new ArrayList<>();
            int[] newInterval = intervals[0];
            result.add(newInterval);
            for (int[] interval : intervals) {
                if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                else {                             // Disjoint intervals, add the new interval to the list
                    newInterval = interval;
                    result.add(newInterval);
                }
            }

            return result.toArray(new int[result.size()][]);
        }
    }

}

