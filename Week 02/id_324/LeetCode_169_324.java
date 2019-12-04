class Solution {


    public int majorityElement(int[] nums) {
        // 获取众数
        return getMajority(nums, 0, nums.length - 1);
    }

    private int getMajority(int[] nums, int begin, int end) {

        // 终结条件：开始下标=结束下标
        if (begin == end) {
            return nums[end];
        }

        // 处理逻辑：二分数组
        int middle = (end - begin) / 2 + begin;

        // 继续递归：获取二分后的众数
        int e0 = getMajority(nums, begin, middle);
        int e1 = getMajority(nums, middle + 1, end);

        // 整理结果，返回出现次数多的数
        if (e0 == e1) {
            return e0;
        }

        // 获取出现次数比较多的数
        int c0 = countEle(nums, e0, begin, middle);
        int c1 = countEle(nums, e1, middle + 1, end);

        return c0 > c1 ? e0 : e1;
    }


    private int countEle(int[] nums, int val, int begin, int end) {

        int count = 0;

        for (int i = begin; i < end + 1; i++) {
            if (nums[i] == val) {
                count++;
            }
        }

        return count;
    }

}