class Solution {
    public int[] twoSum(int[] nums, int target) {
        //1. 如果输入数组为空，返回空的整形数组结果
        if (nums == null) {
            return new int[0];
        }

        //2.遍历数组，查找与目标值匹配的输入数组元素
        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            int num2 = target - num1;
            for (int j = 0; j < nums.length&&i != j;j++){
                if (nums[j] == num2) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }
}