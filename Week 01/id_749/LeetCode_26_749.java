package com.liqi.algorithm.unit1;

public class RemoveDuplicates {
    public static void main(String[] args) {

    }


    public static int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }


}
