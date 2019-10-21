// https://leetcode-cn.com/problems/plus-one/

class Solution
{
public:
  vector<int> plusOne(vector<int> &digits)
  {
    // digits[digits.size() - 1]++;
    // for(int i = digits.size() - 1; i >= 1; i--){
    //     if(digits[i] == 10){
    //         digits[i] = 0;
    //         digits[i - 1]++;
    //     }
    // }
    // if(digits[0] == 10){
    //     digits[0] = 0;
    //     digits.insert(digits.begin(),1);
    // }
    // return digits;
    for (int i = digits.size() - 1; i >= 0; i--)
    {
      if (digits[i] == 9)
      {
        digits[i] = 0;
      }
      else
      {
        digits[i]++;
        break;
      }
    }
    if (digits[0] == 0)
    {
      digits.insert(digits.begin(), 1);
    }
    return digits;
  }
};