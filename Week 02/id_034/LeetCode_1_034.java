import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_034 {

    /**
     *  使用哈希表 一遍遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        if (len <= 1) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     *  b
     * @param nums
     * @param target
     * @return
     */
     public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i ++) {
            for (int j = i + 1; j <len; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
     }
}
