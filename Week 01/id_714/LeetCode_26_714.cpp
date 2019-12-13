// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
class Solution
{
public:
  int removeDuplicates(vector<int> &nums)
  {
    // count用于统计在i的时候，前面一共出现过多少次重复
    int count = 0;
    for (int i = 1; i < nums.size(); i++)
    {
      if (nums[i] == nums[i - 1])
      {
        count++;
      }
      else
      {
        nums[i - count] = nums[i];
      }
    }
    return nums.size() - count;
  }
};