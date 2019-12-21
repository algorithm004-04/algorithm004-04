    /**
     * 283.移动零
     *
     * @param nums
     */
    //i不是0的话, 赋值给
    public static void moveZeroes(int[] nums) {
        //
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }

        }
    }
