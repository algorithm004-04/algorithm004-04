class Solution
{
public:
  int robotSim(vector<int> &commands, vector<vector<int>> &obstacles)
  {
    vector<pair<int, int>> d{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    unordered_set<string> obstacles_set;
    for (int i = 0; i < obstacles.size(); i++)
    {
      obstacles_set.insert(to_string(obstacles[i][0]) + " " + to_string(obstacles[i][1]));
    }

    int dflag = 0;
    int x = 0, y = 0;
    int result = 0;
    for (int cmd : commands)
    {
      if (cmd == -1)
      {
        dflag += 1;
        if (dflag == 4)
          dflag = 0;
      }
      else if (cmd == -2)
      {
        dflag -= 1;
        if (dflag == -1)
          dflag = 3;
      }
      else
      {
        int step = cmd;
        while (step > 0)
        {
          string key = to_string(x + d[dflag].first) + " " + to_string(y + d[dflag].second);
          if (obstacles_set.find(key) == obstacles_set.end())
          {
            x += d[dflag].first;
            y += d[dflag].second;
          }
          step--;
        }
      }
      result = max(result, x * x + y * y);
    }
    return result;
  }
};