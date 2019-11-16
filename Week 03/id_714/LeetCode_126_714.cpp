class Solution
{
public:
  vector<vector<string>> findLadders(string beginWord, string endWord, vector<string> &wordList)
  {
    vector<vector<string>> res;

    // 1. BFS
    // helper(beginWord,endWord,wordList,res);

    // 2. 先双向BFS，再DFS
    map<string, unordered_set<string>> hash_table;
    bfsHelper(beginWord, endWord, wordList, hash_table);
    vector<string> current;
    current.push_back(beginWord);
    for (auto iter = hash_table.begin(); iter != hash_table.end(); iter++)
    {
      cout << iter->first << " " << iter->second.size() << endl;
    }
    dfsHelper(beginWord, endWord, hash_table, res, current);
    return res;
  }

private:
  void dfsHelper(string beginWord, string endWord, map<string, unordered_set<string>> &hash_table, vector<vector<string>> &res, vector<string> &current)
  {

    if (beginWord == endWord)
    {
      res.emplace_back(current);
      return;
    }

    if (hash_table.find(beginWord) == hash_table.end())
    {
      cout << "not found " << beginWord << endl;
      return;
    }

    for (auto str : hash_table[beginWord])
    {
      cout << str << endl;
      current.emplace_back(str);
      dfsHelper(str, endWord, hash_table, res, current);
      current.pop_back();
    }
  }
  void bfsHelper(string beginWord, string endWord, vector<string> &wordList, map<string, unordered_set<string>> &hash_table)
  {
    unordered_set<string> word_set(wordList.begin(), wordList.end());
    if (word_set.find(endWord) == word_set.end())
    {
      return;
    }
    unordered_set<string> q1{beginWord};
    unordered_set<string> q2{endWord};
    bool flag = true;
    bool isFound = false;
    while (!q1.empty())
    {
      int size = q1.size();
      for (auto &str : q1)
      {
        word_set.erase(str);
      }
      cout << "size: " << size << endl;
      unordered_set<string> tmp;
      for (auto iter = q1.begin(); iter != q1.end(); iter++)
      {
        string tempstr = *iter;
        for (int i = 0; i < tempstr.size(); i++)
        {
          char c = tempstr[i];
          for (int j = 0; j < 26; j++)
          {
            tempstr[i] = 'a' + j;
            if (q2.find(tempstr) != q2.end())
            {
              isFound = true;
            }
            if (tempstr[i] != c && word_set.find(tempstr) != word_set.end())
            {
              tmp.insert(tempstr);
              cout << "add hashtable: " << flag << " " << *iter << " " << tempstr << " " << endl;
              flag ? hash_table[*iter].insert(tempstr) : hash_table[tempstr].insert(*iter);
            }
          }
          tempstr[i] = c;
        }
      }
      if (isFound)
        break;
      if (tmp.size() < q2.size())
      {
        q1 = tmp;
      }
      else
      {
        q1 = q2;
        q2 = tmp;
        flag = !flag;
      }
    }
  }

  void helper(string beginWord, string endWord, vector<string> &wordList, vector<vector<string>> &res)
  {
    unordered_set<string> word_set(wordList.begin(), wordList.end());
    if (word_set.find(endWord) == word_set.end())
    {
      return;
    }
    queue<vector<string>> q;
    vector<string> temp;
    temp.push_back(beginWord);
    q.push(temp);

    // 记录每层访问过的节点
    unordered_set<string> level_visited;
    level_visited.insert(beginWord);
    bool is_found = false;
    while (!q.empty())
    {
      // 每层访问过的节点，需要从全局节点里删除，因为如果后面还能访问到之前已经访问过的节点，这条路径一定比之前的长
      for (auto iter = level_visited.begin(); iter != level_visited.end(); iter++)
      {
        word_set.erase(*iter);
      }
      level_visited.clear();
      int size = q.size();
      for (int i = 0; i < size; i++)
      {
        vector<string> vec = q.front();
        q.pop();
        string lastword = vec[vec.size() - 1];
        if (lastword == endWord)
        {
          res.push_back(vec);
          is_found = true;
          continue;
        }
        for (int j = 0; j < lastword.size(); j++)
        {
          char c = lastword[j];
          for (int k = 0; k < 26; k++)
          {
            lastword[j] = 'a' + k;
            if (lastword[j] != c && word_set.find(lastword) != word_set.end())
            {
              level_visited.insert(lastword);
              vector<string> new_vec = vec;
              new_vec.push_back(lastword);
              q.push(new_vec);
            }
          }
          lastword[j] = c;
        }
      }
      if (is_found)
        break;
    }
  }
};

// class Solution {
// public:
//     vector<vector<string>> res;
//     unordered_map<string, vector<string>> hash;

//     vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
//         unordered_set<string> dirc(wordList.begin(), wordList.end());
//         if (dirc.find(endWord) == dirc.end()) return res;
//         unordered_set<string> beginw{beginWord};
//         unordered_set<string> endw{endWord};
//         int flag1 = 0, flag2 = 0;  //第一个是否找到最短序列标志, 第二个是否反转标志。

//         while (!beginw.empty()) {
//             unordered_set<string> tmp;
//             for (auto str : beginw){
//                 cout<<"dirc erase: "<<str<<endl;
//                 dirc.erase(str);
//             }
//             for (auto str : beginw) {
//                 for (int i = 0; i < str.size(); ++i) {
//                     string s = str;
//                     for (char j = 'a'; j <= 'z'; ++j) {
//                         s[i] = j;
//                         if (dirc.find(s) == dirc.end()) continue;
//                         if (endw.find(s) != endw.end()) flag1 = 1;
//                         else tmp.insert(s);
//                         cout<<"add hashtable: "<<flag2<<" "<<s<<" "<<str<<endl;
//                         flag2 ? hash[s].push_back(str) : hash[str].push_back(s);
//                     }
//                 }
//             }
//             if (flag1) break;  //已经找到最短序列退出循环。
//             cout<<tmp.size()<<" "<<endw.size()<<endl;
//             if (tmp.size() < endw.size())
//                 beginw = tmp;
//             else {
//                 beginw = endw; endw = tmp;
//                 flag2 = !flag2;  //这里需要使用！反转。
//             }
//         }
//         vector<string> ans = {beginWord};
//         dfs(ans, beginWord, endWord);
//         return res;
//     }

//     void dfs(vector<string>& ans, string& begin, string& end) {
//         if (begin == end) {
//             res.emplace_back(ans);
//             return;
//         }
//         if (hash.find(begin) == hash.end()) return;
//         for (auto str : hash[begin]) {
//             ans.emplace_back(str);
//             dfs(ans, str, end);
//             ans.pop_back();
//         }
//     }
// };