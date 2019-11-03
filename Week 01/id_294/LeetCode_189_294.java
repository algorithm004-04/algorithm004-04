package week01;

public class LeetCode_189_294 {

    /**
     * 暴力法：
     * 每次所有元素移动一个位置，一共移动k次
     * 时间复杂度O(n*k)
     * 空间复杂度O(1)
     * 思路：
     * 每次所有元素右移一个位置，也就是将最后一个元素移到第一个位置，第一个元素及后面的元素顺次后移
     * prev保存每次被替换的元素
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int len = nums.length;
        int temp, prev;
        for (int i = 0; i < k; ++i) {
            prev = nums[len-1];
            for (int j = 0; j < len; ++j) {
                temp = nums[j];
                nums[j] = prev;
                prev = temp;
            }
        }
    }

  /**
   * 循环旋转
   * startIndex表示本次cycle其实元素index
   * 从nums[startIndex]开始，k为间隔，逐个向后进行替换，直到回到nums[startIndex]
   * 如果此时未处理完所有元素，则startIndex+1，继续处理下个cycle
   * 时间复杂度O(n)
   * 空间复杂度O(1)
   * @param nums
   * @param k
   */
  public static void rotate2(int[] nums, int k) {
        int len = nums.length;
        int moveCount = 0, startIndex = 0;
        int currIndex = startIndex;
        int currValue = nums[currIndex];
        while (moveCount < len) {
            int targetIndex = (currIndex + k) % len;
            int temp = nums[targetIndex];
            nums[targetIndex] = currValue;
            currIndex = targetIndex;
            currValue = temp;
            moveCount++;
            if (targetIndex == startIndex) {
                if (startIndex + 1 >= len) {
                    break;
                }
                startIndex ++;
                currIndex = startIndex;
                currValue = nums[currIndex];
            }
        }
    }

}
