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
    // 用map去记录数和对应的位置
    map<int, int> pos_map;
    for (int i = 0; i < nums.size(); i++)
    {
      int temp = target - nums[i];
      auto search = pos_map.find(temp);
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