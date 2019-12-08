class Solution {
    public int removeDuplicates(int[] nums) {

        /*
         * 1. 声明最近一个不相同的数的变量；
         * 2. 声明最近一次被修改的索引的变量；
         * 3. 数组索引依次往后移动，遇到相同的抛弃，不相同的往前移动
         */
        if (null == nums || nums.length == 0) {
            return 0;
        }

        int lastIdx = 0;
        int lastNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != lastNum) {
                nums[++lastIdx] = nums[i];
                lastNum = nums[lastIdx];
            }
        }

        System.out.println("new length: " + (lastIdx + 1));
        System.out.println("new array: " + Arrays.toString(nums));

        return lastIdx + 1;
    }
}