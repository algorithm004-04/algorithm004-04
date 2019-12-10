class Solution
{
public:
  bool isAnagram(string s, string t)
  {
    if (s.size() != t.size())
      return false;

    // 1. 都排序再对比
    // sort(s.begin(),s.end());
    // sort(t.begin(),t.end());
    // return s == t;

    // 2. hash table
    int character_map[26] = {0};
    for (int i = 0; i < s.size(); i++)
    {
      character_map[s[i] - 'a']++;
    }
    for (int i = 0; i < t.size(); i++)
    {
      character_map[t[i] - 'a']--;
      if (character_map[t[i] - 'a'] < 0)
      {
        return false;
      }
    }
    return true;
  }
};