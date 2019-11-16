class Solution
{
public:
  bool lemonadeChange(vector<int> &bills)
  {
    int five_cnt = 0, ten_cnt = 0;
    for (int i = 0; i < bills.size(); i++)
    {
      int money = bills[i];
      if (money == 5)
      {
        // 5元不用找零
        five_cnt++;
        money = 0;
      }
      else if (money == 10)
      {
        // 10元的需要5元来找零
        if (five_cnt > 0)
        {
          five_cnt--;
          ten_cnt++;
          money = 0;
        }
      }
      else
      {
        // 20的要找15，10+5或者5+5+5
        money -= 5;
        if (ten_cnt > 0 && five_cnt > 0)
        {
          money = 0;
          ten_cnt--;
          five_cnt--;
        }
        else if (five_cnt >= 3)
        {
          money = 0;
          five_cnt -= 3;
        }
      }
      if (money > 0)
        return false;
    }
    return true;
  }
};