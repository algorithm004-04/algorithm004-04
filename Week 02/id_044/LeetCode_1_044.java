package week_02.lesson5;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = target - nums[i];
            if (ans.containsKey(sum)) {
                return new int[]{ans.get(sum), i};
            } else {
                ans.put(nums[i], i);
            }

        }
        return new int[]{};

    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,14},9);
    }

}
