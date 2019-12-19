/**
 * Created by Administrator on 2019/12/15 0015.
 */
public class LeetCode_283_移动零 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int num:nums){
            if(num!=0){
                nums[index++]=num;
            }
        }
        while(index<nums.length){
            nums[index++] = 0;
        }
    }
}
