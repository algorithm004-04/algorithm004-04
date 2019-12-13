class Solution
{
public:
  int findContentChildren(vector<int> &g, vector<int> &s)
  {
    sort(g.begin(), g.end());
    sort(s.begin(), s.end());
    int cnt = 0;
    int s_idx = 0;
    for (int i = 0; i < g.size(); i++)
    {
      // 找第一块合适大小的饼干
      while (s_idx < s.size() && s[s_idx] < g[i])
      {
        s_idx++;
      }
      if (s_idx >= s.size())
        break;
      cnt++;
      s_idx++;
    }
    // int cnt = 0,i = 0,j = 0;
    // while(i < g.size() && j < s.size()){
    //     if(s[j] >= g[i]){
    //         i++;
    //         j++;
    //         cnt++;
    //     }else{
    //         j++;
    //     }
    // }
    return cnt;
  }
};