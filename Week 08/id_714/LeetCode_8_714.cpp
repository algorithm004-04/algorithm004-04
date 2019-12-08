class Solution
{
public:
  int myAtoi(string str)
  {
    if (str.empty())
      return 0;
    long num = 0;
    int valid_start = 0, valid_end = 0;
    bool is_minus = false;

    // 过滤空格
    while (valid_start < str.size() && str[valid_start] == ' ')
    {
      valid_start++;
    }
    if (valid_start >= str.size())
      return 0;
    if (str[valid_start] != '+' && str[valid_start] != '-' && (str[valid_start] - '0' >= 10 || str[valid_start] - '0' < 0))
      return 0;
    if (str[valid_start] == '-')
    {
      is_minus = true;
      valid_start++;
    }
    else if (str[valid_start] == '+')
    {
      valid_start++;
    }
    if (valid_start >= str.size() || str[valid_start] - '0' >= 10 || str[valid_start] - '0' < 0)
      return 0;
    // skip zero
    while (valid_start < str.size() && str[valid_start] == '0')
      valid_start++;
    if (valid_start >= str.size())
      return 0;
    valid_end = valid_start;
    while (valid_end < str.size() && str[valid_end] - '0' >= 0 && str[valid_end] - '0' <= 9)
    {
      valid_end++;
    }
    string num_str = str.substr(valid_start, valid_end - valid_start);
    long base = 1;
    bool num_too_large = false;
    for (int i = num_str.size() - 1; i >= 0; i--)
    {
      num += (num_str[i] - '0') * base;
      base *= 10;
      if (base > 10000000000)
      {
        num_too_large = true;
        break;
      }
    }
    if (is_minus && (num_too_large || num > 2147483648))
    {
      return -2147483648;
    }
    else if (!is_minus && (num_too_large || num > 2147483647))
    {
      return 2147483647;
    }

    if (is_minus)
    {
      return -num;
    }
    else
    {
      return num;
    }
  }
};