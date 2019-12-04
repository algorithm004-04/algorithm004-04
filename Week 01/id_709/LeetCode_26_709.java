public static int removeDepulicate(int[] nums){
        int sameIndex = 0;
        int count = nums.length;
        for(int i=1;i<nums.length;i++){
            if(nums[sameIndex] != nums[i]){
                sameIndex++;
                if(i>sameIndex){
                    nums[sameIndex] = nums[i];
                }
            }
        }
        return sameIndex+1;
    }