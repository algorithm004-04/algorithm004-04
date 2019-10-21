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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // public void moveZeroes(int[] nums) {
    //     //用j记录零元素的位置
    //     int j = 0;
    //     for (int i = 0; i< nums.length; i++){
    //         //找到非0元素
    //         if(nums[i] != 0) {
    //             //将其挪到数组首位
    //             nums[j] = nums[i];
    //             //边界判断条件
    //             if (i != j) {
    //                 //将原位置赋值0
    //                 nums[i] = 0;
    //             }
    //             //交换后将j向后移1位
    //             j++;
    //         }
    //     }
    // }

    // public void moveZeroes(int[] nums) {
    //     int j = 0;
    //     //将非0元素全部已到前面
    //     for(int i = 0; i< nums.length; i++){
    //         if (nums[i] != 0) {
    //             nums[j] = nums[i];
    //             j++;
    //         }
    //     }
    //     //在非零元素后面补0
    //     for(int k = j; k < nums.length; k++) {
    //         nums[k] = 0;
    //     }
    // }

    public void moveZeroes(int[] nums) {
        //用j记录零元素的位置
        int j = 0;
        for (int i = 0; i< nums.length; i++){
            //知道第n个非零元素，将它与第n个元素交换
            if (nums[i] != 0) {
                //swap j->temp i->j temp->i
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
