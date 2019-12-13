class Solution
{
public:
  string reverseStr(string s, int k)
  {
    if (k <= 0 || s.empty())
      return s;
    int start = 0;
    while (start + 2 * k < s.size())
    {
      innerReverseStr(s, start, start + k - 1);
      start += 2 * k;
    }
    if (start < s.size() - 1)
    {
      if (start + k - 1 < s.size())
      {
        innerReverseStr(s, start, start + k - 1);
      }
      else
      {
        innerReverseStr(s, start, s.size() - 1);
      }
    }
    return s;
  }

private:
  void innerReverseStr(string &s, int start, int end)
  {
    while (start < end)
    {
      char tmp_char = s[start];
      s[start] = s[end];
      s[end] = tmp_char;
      start++;
      end--;
    }
  }
};