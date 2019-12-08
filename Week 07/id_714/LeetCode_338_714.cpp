class Solution
{
public:
  vector<int> countBits(int num)
  {
    // 0 0
    // 1 1
    // 2 10
    // 3 11
    // 4 100
    // 5 101
    // 6 110
    // res[n] = res[n & (n - 1)] + 1;
    vector<int> res;

    // 1. dp
    // res.push_back(0);
    // for(int i = 1; i <= num; i++){
    //     res.push_back(res[i & (i - 1)] + 1);
    // }

    // 2. hamming weight
    // for(int i = 0; i <= num; i++){
    //     HammingWeight(i, res);
    // }

    // 3. 最高位
    int i = 0, b = 1;
    res.push_back(0);
    while (b <= num)
    {
      while (i < b && b + i <= num)
      {
        res.push_back(res[i] + 1);
        i++;
      }
      i = 0;
      b <<= 1;
    }
    return res;
  }

private:
  void HammingWeight(int n, vector<int> &res)
  {
    int count = 0;
    while (n > 0)
    {
      n = n & (n - 1);
      count++;
    }
    res.push_back(count);
  }
};