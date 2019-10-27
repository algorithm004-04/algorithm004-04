package week01;

public class LeetCode_26_294 {

    /**
     * 解题思路
     * 方法一 快慢指针
     * 慢指针，指向当前非重复序列的最后一个元素，初始值为第一个元素
     * 快指针，指向数组中的每一个元素，初始值为第二个元素，依次指向数组中每一个元素
     * 每当快指针指向的元素与慢指针指向的元素的值不同时，说明出现了新的非重复元素，
     * 将快指针指向的值复制到慢指针的下一个位置，
     * 同时将慢指针向前移动一步，此时慢指针仍然指向非重复序列的最后一个元素
     *
     * 看题解中有人提出优化：
     * 即当快慢指针指向的元素值不等，同时快指针就是慢指针的下一个位置，
     * 那么【将快指针指向的值复制到慢指针的下一个位置】这个操作就是多余的了，
     * 可以加一个判断省掉这个赋值
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int curIndex = 0;
        for (int i=1; i<nums.length; i++){
            if (nums[i] > nums[curIndex]) {
                if (i != curIndex + 1) {
                    nums[curIndex+1] = nums[i];
                }
                curIndex++;
            }
        }
        return curIndex + 1;
    }

    /**
     * 方法二 计数法
     * 通过统计重复元素数量，来计算每一个非重复元素的最终位置
     * 以 nums = [0,0,1,1,1,2,2,3,3,4]为例：
     * 第一个元素肯定属于非重复序列，所以从第二个元素开始看
     * 依次比较当前元素和上一个元素是否相等，如果相等，则重复，计时器count加一
     * 如果不相等，则说明出现了非重复元素，此时需要计算他的最终位置，最终位置 = 当前索引 - 重复元素数量
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        int repeatCount = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i-1]) {
                nums[i - repeatCount] = nums[i];
            } else {
                repeatCount ++;
            }
        }
        return len - repeatCount;
    }

    /***
     * 方法三 直接查找非重复元素
     * 通过方法二可以看出，当nums[i]!=nums[i-1]时，nums[i]就是新发现的非重复元素，
     * 通过在最开始记录当前非重复元素的长度，直接获取到新的元素的位置
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[count] = nums[i];
            }
        }
        return count;
    }


}
