class Solution
{
public:
  bool isAnagram(string s, string t)
  {
    if (s.size() != t.size())
    {
      return false;
    }
    else
    {
      // 4. 只需要循环一遍
      int character_hash_table[26] = {0};
      for (auto idx = 0; idx < s.size(); idx++)
      {
        character_hash_table[s[idx] - 'a']++;
        character_hash_table[t[idx] - 'a']--;
      }
      for (int i = 0; i < 26; i++)
      {
        if (character_hash_table[i] != 0)
        {
          return false;
        }
      }
      return true;
    }
  }
};