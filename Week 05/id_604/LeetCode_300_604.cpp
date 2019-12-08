class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {

        if( nums.size() == 0 )
            return 0;

        //memo[i]表示以ｎｕｍｓ[i]为结尾的最长上升子序列的长度
        vector<int> memo(nums.size(),1);

        for(int i = 1; i < nums.size(); i++){
            for(int j = 0; j < i; j++)
                if( nums[j] < nums[i] )
                    memo[i] = max( memo[i], 1 + memo[j]);
        }

        //不是最后一个元素就是最大值，所以要遍历整个ｍｅｍｏ数组求出最大值
        int res = 1;
        for(int i = 0; i < nums.size(); i++)
            res = max(res, memo[i]);

        return res;

    }
};
