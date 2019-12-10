    class Solution {
        public void moveZeroes(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    continue;
                }
                // find next non-zero
                int nextIndex = findNextNonZeroIndex(i, nums);
                nums[i] = nums[nextIndex];
                nums[nextIndex] = 0;

            }
            System.out.println(Arrays.toString(nums));
        }

        public int findNextNonZeroIndex(int currentIndex, int[] nums) {
            for (int i = currentIndex; i < nums.length; i++) {
                if (nums[i] != 0) {
                    return i;
                }
            }
            return currentIndex;
        }
    }
