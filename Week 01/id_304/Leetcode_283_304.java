
/**
 * 时间复杂度O(n),两次循环，如把第一层循环改成swap可减少一次循环。
 */
class Solution {
    public void moveZeroes(int[] nums) { ;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {            
            if ( nums[i] != 0) {
                nums[num++] = nums[i];
            }
        }
        while (num < nums.length)
            nums[num++] = 0;
            
        
    }
}


