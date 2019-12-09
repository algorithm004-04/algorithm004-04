// https://leetcode-cn.com/problems/merge-sorted-array/

class Solution
{
public:
  // 解法1. 把nums2填到nums1后面，然后排序
  // 解法2. nums2和nums1从后往前比较，填到nums1后面
  void merge(vector<int> &nums1, int m, vector<int> &nums2, int n)
  {
    int i = m - 1, j = n - 1;
    while (i >= 0 && j >= 0)
    {
      if (nums2[j] > nums1[i])
      {
        nums1[i + j + 1] = nums2[j];
        j--;
      }
      else
      {
        nums1[i + j + 1] = nums1[i];
        i--;
      }
    }
    if (j >= 0)
    {
      for (int i = 0; i <= j; i++)
      {
        nums1[i] = nums2[i];
      }
    }
  }
};