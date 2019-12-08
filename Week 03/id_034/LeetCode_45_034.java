public class LeetCode_45_034 {

    public int jump(int[] nums) {
        int end = 0;
        int maxPos = 0;
        int steps = 0;

        for (int i = 0; i < nums.length - 1; i ++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                steps ++;
            }
        }

        return  steps;
    }
}
