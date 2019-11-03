/**
 * 移动零
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @Author blackberry
 * @Date 2019/10/15 8:33 PM
 **/
public class MoveZereos {
    public void moveZeros(int nums) {
        int j = 0;
        int len = nums.length;

        for (int i = 0; i < len; i ++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (j != i) {
                    nums[i] = 0;
                }
                j ++;
            }
        }
    }
}
