class Solution
{
public:
  vector<vector<char>> updateBoard(vector<vector<char>> &board, vector<int> &click)
  {
    // E未挖的空方块
    // M表示未挖的地雷
    // X表示已挖出的地雷
    // B表示已挖出的，没有相邻地雷的空白方块
    // 数字表示有多少地雷跟这个已挖出的方块相邻
    if (board.size() == 0 || click.size() != 2)
    {
      return board;
    }

    // 1. BFS
    // if(board[click[0]][click[1]] == 'M'){
    //     board[click[0]][click[1]] = 'X';
    //     return board;
    // }
    // int row = board.size();
    // int col = board[0].size();
    // queue<pair<int,int>> q;
    // q.push({click[0],click[1]});
    // while(!q.empty()){
    //     auto cur = q.front();
    //     q.pop();
    //     if(board[cur.first][cur.second] != 'E') continue;
    //     int bombcnt = aroundBombCount(cur.first,cur.second,board);
    //     if(bombcnt == 0){
    //         // 不是贴近炸弹的，改成B，然后把附件的点加进去
    //         board[cur.first][cur.second] = 'B';
    //         addAroundPoint(cur.first,cur.second,q,board);
    //     }else{
    //         // 贴近炸弹的，只需要修改成数字
    //         board[cur.first][cur.second] = to_string(bombcnt)[0];
    //     }
    // }

    // 2. DFS
    if (inBoard(click[0], click[1], board) && board[click[0]][click[1]] == 'M')
    {
      board[click[0]][click[1]] = 'X';
      return board;
    }
    dfs(click[0], click[1], board);

    return board;
  }

private:
  bool inBoard(int row, int col, vector<vector<char>> &board)
  {
    // cout<<row<<" "<<col<<endl;
    if (row >= board.size() || row < 0 || col < 0 || col >= board[0].size())
      return false;
    return true;
  }
  void dfs(int row, int col, vector<vector<char>> &board)
  {
    if (!inBoard(row, col, board))
      return;
    if (board[row][col] == 'E')
    {
      int bombcnt = 0;
      if (inBoard(row - 1, col - 1, board) && board[row - 1][col - 1] == 'M')
        bombcnt++;
      if (inBoard(row - 1, col, board) && board[row - 1][col] == 'M')
        bombcnt++;
      if (inBoard(row - 1, col + 1, board) && board[row - 1][col + 1] == 'M')
        bombcnt++;
      if (inBoard(row, col - 1, board) && board[row][col - 1] == 'M')
        bombcnt++;
      if (inBoard(row, col + 1, board) && board[row][col + 1] == 'M')
        bombcnt++;
      if (inBoard(row + 1, col - 1, board) && board[row + 1][col - 1] == 'M')
        bombcnt++;
      if (inBoard(row + 1, col, board) && board[row + 1][col] == 'M')
        bombcnt++;
      if (inBoard(row + 1, col + 1, board) && board[row + 1][col + 1] == 'M')
        bombcnt++;

      if (bombcnt != 0)
      {
        board[row][col] = '0' + bombcnt;
      }
      else
      {
        board[row][col] = 'B';
        dfs(row - 1, col - 1, board);
        dfs(row - 1, col, board);
        dfs(row - 1, col + 1, board);
        dfs(row, col - 1, board);
        dfs(row, col + 1, board);
        dfs(row + 1, col - 1, board);
        dfs(row + 1, col, board);
        dfs(row + 1, col + 1, board);
      }
    }
  }

  void addAroundPoint(int r, int c, queue<pair<int, int>> &q, vector<vector<char>> &board)
  {
    if (r - 1 >= 0)
    {
      if (c - 1 >= 0 && board[r - 1][c - 1] == 'E')
        q.push({r - 1, c - 1});
      if (c + 1 < board[0].size() && board[r - 1][c + 1] == 'E')
        q.push({r - 1, c + 1});
      if (board[r - 1][c] == 'E')
        q.push({r - 1, c});
    }
    if (r + 1 < board.size())
    {
      if (board[r + 1][c] == 'E')
        q.push({r + 1, c});
      if (c - 1 >= 0 && board[r + 1][c - 1] == 'E')
        q.push({r + 1, c - 1});
      if (c + 1 < board[0].size() && board[r + 1][c + 1] == 'E')
        q.push({r + 1, c + 1});
    }
    if (c - 1 >= 0 && board[r][c - 1] == 'E')
      q.push({r, c - 1});
    if (c + 1 < board[0].size() && board[r][c + 1] == 'E')
      q.push({r, c + 1});
  }
  int aroundBombCount(int r, int c, vector<vector<char>> &board)
  {
    int bomb = 0;
    if (r - 1 >= 0)
    {
      if (c - 1 >= 0 && board[r - 1][c - 1] == 'M')
        bomb++; // 左上角
      if (c + 1 < board[0].size() && board[r - 1][c + 1] == 'M')
        bomb++; // 右上角
      if (board[r - 1][c] == 'M')
        bomb++; // 上
    }
    if (r + 1 < board.size())
    {
      if (board[r + 1][c] == 'M')
        bomb++; // 下
      if (c - 1 >= 0 && board[r + 1][c - 1] == 'M')
        bomb++; // 左下角
      if (c + 1 < board[0].size() && board[r + 1][c + 1] == 'M')
        bomb++; // 右下角
    }
    if (c - 1 >= 0 && board[r][c - 1] == 'M')
      bomb++; // 左
    if (c + 1 < board[0].size() && board[r][c + 1] == 'M')
      bomb++; // 右
    return bomb;
  }
};