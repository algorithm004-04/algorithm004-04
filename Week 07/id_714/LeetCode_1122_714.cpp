class Solution
{
public:
  vector<int> relativeSortArray(vector<int> &arr1, vector<int> &arr2)
  {
    int count_arr[1001] = {0};
    vector<int> res;
    for (int i = 0; i < arr1.size(); i++)
    {
      count_arr[arr1[i]]++;
    }
    for (int i = 0; i < arr2.size(); i++)
    {
      for (int j = 1; j <= count_arr[arr2[i]]; j++)
      {
        res.push_back(arr2[i]);
      }
      count_arr[arr2[i]] = 0;
    }
    for (int i = 0; i < 1001; i++)
    {
      if (count_arr[i] != 0)
      {
        for (int j = 1; j <= count_arr[i]; j++)
        {
          res.push_back(i);
        }
      }
    }
    return res;
  }
};