package com.kkkkkk.demovvorld.leetcode169;

class Solution {
    /**
     * 关键前提：
     * 1. 一定存在众数
     * 2. 众数指超过半数
     * <p>
     * 分治：分为A, B两个区间
     * 1. A区间不存在majority, B存在majority=x。合并A和B，majority为x。
     * 2. A和B都存在majority=x。合并A和B，majority为x。
     * 3. A区间majority=x, B区间majority=y. 合并A和B，比较x的数量 和 y的数量。
     * <p>
     * 关键：如果一定存在众数，A, B两边至少一边存在众数。
     * 只是递归解法的前提。关键前提。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return majorityElement(0, nums.length - 1, nums);
    }

    private int majorityElement(int low, int high, int[] nums) {
        if (low == high) {
            return nums[low];
        }

        int mid = (high - low) /2 + low;
        int left = majorityElement(low, mid, nums);
        int right = majorityElement(mid + 1, high, nums);

        return countElement(low, high, nums, left, right);
    }

    private int countElement(int i, int max, int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int leftCount = 0;
        int rightCount = 0;
        while (i <= max) {
            if (nums[i] == left) {
                ++leftCount;
            } else if (nums[i] == right) {
                ++rightCount;
            }
            ++i;
        }
        return leftCount > rightCount ? left : right;
    }

    public static void main(String[] args) {
        int[] t = new int[]{3, 2, 3, 1, 3};
        System.out.println(new Solution().majorityElement(t));
    }
}
