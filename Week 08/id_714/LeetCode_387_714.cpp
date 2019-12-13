class Solution
{
public:
  int firstUniqChar(string s)
  {
    int character_count[26] = {0};
    for (int i = 0; i < s.size(); i++)
    {
      character_count[s[i] - 'a']++;
    }
    for (int i = 0; i < s.size(); i++)
    {
      if (character_count[s[i] - 'a'] == 1)
      {
        return i;
      }
    }
    return -1;
  }
};