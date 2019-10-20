
/**
 * 暴力 ，时间复杂度O(n^2),空间复杂度 O(1）
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        
        
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] res = new int[2];
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return new int[0];

        
    }
}

 /**
         * 夹逼
         * 复制一份数组进行排序，空间复杂度O(n)
         * 排序本身O(log n)
         * 夹逼 O(n)
         * 整体时间复杂度 O(log n)
         */
class Solution {
    public int[] twoSum(int[] nums, int target) {
       
        int[] newnums = new int[nums.length];


        for (int i = 0; i < newnums.length; i++) {
            newnums[i] = nums[i];
            
        }
        int i = nums.length-1;
        Arrays.sort(newnums);
        int j = 0;

        while ( j < i) {
            if (newnums[i] + newnums[j] == target) {
                int[] res = new int[2];
                boolean record = false;
                for (int k = 0 ; k < nums.length; k++) {
                    if ( nums[k] == newnums[i] && record != true) {
                        res[0] = k;
                        record = true;
                    }
                    else if ( nums[k] == newnums[j] ) {
                        res[1] = k;
                    }
                }
                Arrays.sort(res);
                return res;
                

            }else if (newnums[i] + newnums[j] > target )
                i--;
            else
                j++;

        }


        return new int[0];

        
    }
}





