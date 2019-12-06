package week01;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_294 {
    /***
     * 两次循环
     * 第一次循环记录每个元素的"补数"，即与之相加和为target
     * 第二次循环判断每个元素"补数"的"补数"是否存在，且不为当前元素，则找到符合条件的两数
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> positions = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            positions.put(nums[i], i);
        }

        for (int i=0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (positions.get(comp) != null && positions.get(comp) != i) {
                result[0] = i;
                result[1] = positions.get(comp);
                break;
            }
        }
        return result;
    }

  /**
   * 单次循环，在每次记录当前值的"补数"之前，先判断是否有"补数"存在，这样可以省掉一次循环
   * 时间复杂度O(n)
   * 空间复杂度O(n)
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> positions = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (positions.get(comp) != null && positions.get(comp) != i) {
                result[0] = i;
                result[1] = positions.get(comp);
                break;
            }
            //此处要注意，要先判断是否有"补数"存在，再复制
            //否则遇到相同的值，再hashmap中会将之前存在的k-v覆盖掉，导致漏判
            positions.put(nums[i], i);
        }
        return result;
    }
}
