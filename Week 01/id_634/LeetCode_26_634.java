class Solution {
    
    //第三遍双指针法
    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for(int j = 1 ; j < nums.length ; j++) {
            if(nums[j] != nums[j-1]) {
                i++;
                nums[i-1] = nums[j];
            }
        }
        return i;
    }
    
    //第二遍个人想法：转字符串正则去重但遇到负数无法处理
    // public int removeDuplicates(int[] nums) {
    //     int i = nums.length > 0 ? 1 : 0;
    //     for(char c : Arrays.toString(nums).replaceAll("(.)(?=.*\\1)", "") //去重
    //         .replaceAll("[,\\ \\[\\]-]","") //去除数组元素[ , ] 空格符号
    //         .toCharArray()) {
    //         nums[i-1] = Integer.parseInt(c + "");
    //         i++;
    //     }
    //     return i==0 ? i : i - 1;
    // }
    
    //第一遍参考网上做法
    // public int removeDuplicates(int[] nums) {
    //     int i = nums.length > 0 ? 1 : 0;
    //     for(int value: nums) {
    //         if (value != nums[i-1]) {
    //             nums[i++] = value;
    //         }
    //     }
    //     return i;
    // }
}