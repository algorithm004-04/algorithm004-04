package algorithm;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 * 说明:
 *  1 必须在原数组上操作，不能拷贝额外的数组
 *  2 尽量减少操作次数。
 */
public class LeetCode_283_299 {
    public static void main(String[] args) {
        System.out.println("hello");
        int[] nums = {0,1,0,3,12};
//        move(nums);
        move2(nums);

        for (int i =0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void move(int[] nums){

        int nozerolastindex = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {

                if (i > nozerolastindex) {

                    nums[nozerolastindex] = nums[i];
                    nums[i] = 0;
                }
                // 标记不为零的次数/索引
                nozerolastindex++;
            }
        }
    }

    public static void move2(int[] nums){
        int nozerolastindex = 0;
        // 第一次循环计算不为零的情况
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[nozerolastindex] = nums[i];
                nozerolastindex++;
            }
        }
        // 从末尾开始补零
        for (int j = nums.length - 1; j >= nozerolastindex; j--) {

            nums[j] = 0;
        }

    }
}
