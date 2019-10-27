package week01;

public class LeetCode_283_294 {

    /**
     * slowIndex总是指向第一个0元素
     * quickIndex从slowIndex后去找第一个不为0的元素，然后与slowIndex交换
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int slowIndex = 0;
        int quickIndex = 1;
        while (slowIndex < nums.length && quickIndex < nums.length) {
            if (nums[slowIndex] != 0) {
                slowIndex ++;
                quickIndex = slowIndex + 1;
                continue;
            }

            //swap a,b
            // a = a + b, b = a - b, a = a - b
            if (nums[slowIndex] != nums[quickIndex]) {
                nums[slowIndex] = nums[slowIndex] + nums[quickIndex];
                nums[quickIndex] = nums[slowIndex] - nums[quickIndex];
                nums[slowIndex] = nums[slowIndex] - nums[quickIndex];
                if (slowIndex == quickIndex - 1) {
                    slowIndex = quickIndex;
                    quickIndex = slowIndex + 1;
                } else {
                    slowIndex ++;
                    quickIndex ++;
                }
            } else {
                quickIndex ++;
            }
        }
    }

  /**
   *
   * zeroIndex指向第一个为0的元素，
   * 思路跟上面是一样的，但是代码更简洁，执行更快
   * 时间复杂度O(n)
   * 空间复杂度O(1)
   * @param nums
   */
  public static void moveZeroes2(int[] nums) {
        int zeroIndex = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != zeroIndex) {
                    temp = nums[i];
                    nums[i] = nums[zeroIndex];
                    nums[zeroIndex] = temp;
                }
                zeroIndex ++;
            }
        }
    }

}
