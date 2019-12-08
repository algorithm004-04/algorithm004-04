// https://leetcode-cn.com/problems/move-zeroes/

class Solution
{
public:
  void moveZeroes(vector<int> &nums)
  {
    if (nums.size() < 2)
    {
      return;
    }
    for (int non_zero_idx = 0, i = 0; i < nums.size(); i++)
    {
      if (nums[i] != 0)
      {
        if (i > non_zero_idx)
        {
          nums[non_zero_idx] = nums[i];
          nums[i] = 0;
        }
        non_zero_idx++;
      }
    }
  }
};