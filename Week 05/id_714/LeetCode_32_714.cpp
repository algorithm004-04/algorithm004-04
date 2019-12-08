class Solution
{
public:
  int longestValidParentheses(string s)
  {
    // int res = 0;
    // // 1. 暴力法，有效括号一定是双数的长度，超时
    // for(int i = 0; i < s.size(); i++){
    //     for(int j = i + 2; j <= s.size(); j += 2){
    //         if(isValid(s.substr(i,j - i))){
    //             res = max(res,j - i);
    //         }
    //     }
    // }
    // return res;

    // 2. DP
    if (s.size() == 0)
      return 0;
    int board[s.size()];
    int res = 0;
    memset(board, 0, sizeof(board));
    for (int i = 1; i < s.size(); i++)
    {
      // 只有右括号需要处理
      if (s[i] == ')')
      {
        if (s[i - 1] == '(')
        {
          if (i >= 2)
          {
            board[i] = board[i - 2] + 2;
          }
          else
          {
            board[i] = 2;
          }
        }
        else
        {
          // ))的情况，看下前面有没有匹配的左括号
          if (i - 1 - board[i - 1] >= 0 && s[i - 1 - board[i - 1]] == '(')
          {
            if (i - board[i - 1] - 2 >= 0)
            {
              board[i] = board[i - board[i - 1] - 2] + board[i - 1] + 2;
            }
            else
            {
              board[i] = board[i - 1] + 2;
            }
          }
        }
        res = max(res, board[i]);
      }
      // cout<<board[i]<<" ";
    }
    return res;
  }

private:
  bool isValid(const string s)
  {
    // cout<<s<<endl;
    stack<char> stack;
    for (int i = 0; i < s.size(); i++)
    {
      if (s[i] == '(')
      {
        stack.push('(');
      }
      else if (!stack.empty() && stack.top() == '(')
      {
        stack.pop();
      }
      else
      {
        return false;
      }
    }
    return stack.empty();
  }
};