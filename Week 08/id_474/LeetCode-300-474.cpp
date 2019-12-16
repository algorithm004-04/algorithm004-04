/*
 * @lc app=leetcode.cn id=300 lang=cpp
 *
 * [300] 最长上升子序列
 */

// @lc code=start

#include <iostream>
#include <vector>

using namespace std;


class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> res;

        for(int i = 0; i < nums.size(); i++) {
            auto it = lower_bound(res.begin(), res.end(), nums[i]);
            if(it == res.end()) 
                res.push_back(nums[i]);
            else 
                *it = nums[i];
        }

        return res.size();        
    }
};
// @lc code=end

