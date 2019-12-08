/*
 * @lc app=leetcode.cn id=493 lang=cpp
 *
 * [493] 翻转对
 *
 * https://leetcode-cn.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (19.71%)
 * Likes:    51
 * Dislikes: 0
 * Total Accepted:    2K
 * Total Submissions: 9.6K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 
 * 你需要返回给定数组中的重要翻转对的数量。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
public:
    // int sort_and_count(vector<int>::iterator begin, vector<int>::iterator end) {
    //     if (end - begin <= 1)
    //         return 0;
    //     auto mid = begin + (end - begin) / 2;
    //     int count = sort_and_count(begin, mid) + sort_and_count(mid, end);
    //     for (auto i = begin, j = mid; i != mid; ++i) {
    //         while (j != end and *i > 2L * *j)
    //             ++j;
    //         count += j - mid;
    //     }
    //     inplace_merge(begin, mid, end);
    //     return count;
    // }

    // int reversePairs(vector<int>& nums) {
    //     return sort_and_count(nums.begin(), nums.end());
    // }

    int merge_sort(vector<int>& nums, vector<int>& tmp, int l, int r){
        if(r - l <= 1) return 0;
        
        int mid = l + ((r-l)>>1);
        int count = merge_sort(tmp, nums, l, mid) + merge_sort(tmp, nums, mid, r);
        
        for(int i = l,j = mid; i < mid; ++i) {
            while(j < r && (tmp[i] / 2.0) > tmp[j]) j++;
            count += j - mid;
        }
        
        int j = mid, p = l;
        for(int i = l; i < mid; ++i) {
            while(j < r && tmp[i] > tmp[j]) nums[p++] = tmp[j++];
            nums[p++] = tmp[i];
        }
        while(j < r) nums[p++] = tmp[j++];
        
        return count;
    }

    int reversePairs(vector<int>& nums) {
        vector<int> tmp = nums;
        
        int ans = merge_sort(nums, tmp, 0, nums.size());
        return ans;
    }
};
// @lc code=end

