class Solution
{
public:
  string reverseOnlyLetters(string S)
  {
    int start = 0, end = S.size() - 1;
    while (start < end)
    {
      while (start < end && !isValidChar(S[start]))
        start++;
      if (start >= end)
        break;
      while (start < end && !isValidChar(S[end]))
        end--;
      if (start >= end)
        break;
      char tmp_char = S[start];
      S[start] = S[end];
      S[end] = tmp_char;
      start++;
      end--;
    }
    return S;
  }

private:
  bool isValidChar(char c)
  {
    return (c - 'a' >= 0 && c - 'z' <= 0) || (c - 'A' >= 0 && c - 'Z' <= 0);
  }
};