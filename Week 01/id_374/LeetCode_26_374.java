/**
     * 暴力法
     * O(n)
     * O(n)
     *
     * @param nums
     * @return
     */
    private int m1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int tmp = nums[0];
        List tempList = new ArrayList();
        tempList.add(nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != tmp) {
                tempList.add(nums[i]);
                tmp = nums[i];
            }
        }
        return tempList.size();
    }

    /**
     * 双指针
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @return
     */
    private int m3(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                i++;
                if (i != j) {
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }
