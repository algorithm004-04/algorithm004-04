// 思路:
//   双指针i,j,
//   指针j用来循环数组，指针i标记result数组
//   初始： i = 0; j = 1
//   当i与j指向的值不同时，交换i + 1与j所对应的值
//   j循环结束，返回长度

class LeetCode_26_719 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}