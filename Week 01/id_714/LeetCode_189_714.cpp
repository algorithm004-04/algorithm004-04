// https://leetcode-cn.com/problems/rotate-array/

class Solution
{
public:
  // 解法1. 每次记录最后一个数，然后把前面的数往后面移动，最后把记录的数放在数组开头
  // 解法2. 用额外空间做
  // 解法3. 反转
  void rotate(vector<int> &nums, int k)
  {
    if (nums.size() < 2)
    {
      return;
    }
    k = k % nums.size();
    reverse(nums, 0, nums.size() - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.size() - 1);
  }

  void reverse(vector<int> &nums, int start, int end)
  {
    while (start < end)
    {
      int temp = nums[end];
      nums[end] = nums[start];
      nums[start] = temp;
      start++;
      end--;
    }
  }
};