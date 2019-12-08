// https://leetcode-cn.com/problems/two-sum/

class Solution
{
public:
  vector<int> twoSum(vector<int> &nums, int target)
  {
    vector<int> res;
    if (nums.size() < 2)
    {
      return res;
    }
    map<int, int> pos_map;
    for (int i = 0; i < nums.size(); i++)
    {
      int temp = target - nums[i];
      auto search = pos_map.find(temp);
      // 如果target = 2，nums = [1,1]，这里可以保证i和search->second不同（不重复利用）
      if (search != pos_map.end())
      {
        res.push_back(i);
        res.push_back(search->second);
        break;
      }
      pos_map[nums[i]] = i;
    }
    return res;
  }
};