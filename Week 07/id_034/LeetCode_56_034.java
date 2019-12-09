import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode_56_034
 *
 * @Author blackberry
 * @Date 2019/12/1 1:54 PM
 **/
public class LeetCode_56_034 {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int i = 1; i < len; i ++) {
            int[] interval = intervals[i];

            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
