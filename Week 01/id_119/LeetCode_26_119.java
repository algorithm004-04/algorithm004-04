    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0)
                return 0;
            
            int targetIndex = 1;
            int OG = nums[0];

            for(int i = 1; i < nums.length; i++){
                if(nums[i] != OG){
                    OG = nums[i];
                    nums[targetIndex] = nums[i];
                    targetIndex++;
                }
            }

            return targetIndex;
        }
    }
