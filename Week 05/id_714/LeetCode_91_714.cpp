class Solution
{
public:
  int numDecodings(string s)
  {
    if (s.size() == 0 || s[0] == '0')
    {
      return 0;
    }
    // int board[s.size()];
    // board[0] = 1;
    // for(int i = 1; i < s.size(); i++){
    //     if(s[i] == '0' && s[i - 1] != '1' && s[i - 1] != '2'){
    //         // 不合法
    //         return 0;
    //     }
    //     if(s[i] != '0' && ((s[i - 1] == '2' && (s[i] - '1' < 6)) || (s[i - 1] == '1'))){
    //         if(i - 2 >= 0){
    //             board[i] = board[i - 1] + board[i - 2];
    //         }else{
    //             board[i] = board[i - 1] + 1;
    //         }
    //     }else if(s[i] == '0'){
    //         if(i - 2 >= 0){
    //             board[i] = board[i - 2];
    //         }else{
    //             board[i] = 1;
    //         }
    //     }
    //     else{
    //         board[i] = board[i - 1];
    //     }
    // }
    // return board[s.size() - 1];

    // 优化空间复杂度
    int prev = 1, cur = 1;
    for (int i = 1; i < s.size(); i++)
    {
      int temp = cur;
      if (s[i] == '0')
      {
        if (s[i - 1] == '1' || s[i - 1] == '2')
        {
          cur = prev;
        }
        else
        {
          return 0;
        }
      }
      else
      {
        if (s[i - 1] == '1' || (s[i - 1] == '2' && s[i] - '1' <= 5))
        {
          cur = prev + temp;
        }
        else
        {
          cur = temp;
        }
      }
      prev = temp;
    }
    return cur;
  }
};