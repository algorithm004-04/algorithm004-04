class Solution
{
public:
  vector<vector<string>> groupAnagrams(vector<string> &strs)
  {
    // 每个字符串都sort一遍，拿去做map的key
    vector<vector<string>> res;
    int idx = 0;
    map<string, int> string_idx_map;
    for (auto iter = strs.begin(); iter != strs.end(); iter++)
    {
      string temp_str = *iter;
      sort(temp_str.begin(), temp_str.end());
      auto search = string_idx_map.find(temp_str);
      if (search == string_idx_map.end())
      {
        vector<string> temp;
        temp.push_back(*iter);
        res.push_back(temp);
        string_idx_map[temp_str] = idx;
        idx++;
      }
      else
      {
        res[search->second].push_back(*iter);
      }
    }
    return res;
  }
};