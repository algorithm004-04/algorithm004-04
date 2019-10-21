public class Leetcode_26_704 {


    public int removeDuplicates(int[] nums) {

        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}