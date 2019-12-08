//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针



class Solution {
    public void moveZeroes(int[] nums) {
        //非零元素应该存放的位置
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i != count) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
//        for(int i = count;i < nums.length;i++) {
//            nums[i] = 0;
//        }

    }
}



//1.创建一个临时数组,将非零元素依次放入数组中,剩下的补零,再将临时数组元素覆盖到原数组   时间O(n) 空间O(n)  不符合要求
//2.双指针法  时间O(n)  空间O(1)