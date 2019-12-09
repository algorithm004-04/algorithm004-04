
/*
 *    单词接龙 
*/

#include <unordered_map>
#include <unordered_set>
#include <queue>

using namespace std;

/*
    方法一：BFS(广度优先) 

    例子：
        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

        输出: 5
        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
            返回它的长度 5。        
    
    分析：
        由于一次只能更改一个字母，因此，如果从"hit"开始，我们只能更改为仅具有一个字母不同的单词（在本例中为"hot"）。
        用图论的术语，"hot"是"hit"的邻居。这个想法很简单，从beginWord开始，然后访问其邻居，然后访问其邻居的未访问邻居，直到我们到达endWord。
        这是典型的BFS结构。

*/
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end());
        queue<string> todo;
        todo.push(beginWord);
        int ladder = 1;

        while (!todo.empty()) {
            int n = todo.size();

            for (int i = 0; i < n; i++) {
                string word = todo.front();
                todo.pop();

                if (word == endWord) { // terminator
                    return ladder;
                }

                dict.erase(word);

                for (int j = 0; j < word.size(); j++) { 
                    char c = word[j];
                    for (int k = 0; k < 26; k++) {
                        word[j] = 'a' + k;
                        if (dict.find(word) != dict.end()) {
                            todo.push(word);
                        }
                     }
                    word[j] = c;
                }
            }
            ladder++;
        }

        return 0;        
    }
};

/*
    方法二：双向BFS(广度优先) 

    分析：
        上面的代码从一端开始beginWord,我们也可以从endWord同时开始。一旦我们遇到相同的词，就完成了。
        使用两个指针phead和ptail, 在每一步切换到较小的指针以节省时间。
*/

class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end()), head, tail, *phead, *ptail;
        if (dict.find(endWord) == dict.end()) {
            return 0;
        }

        head.insert(beginWord);
        tail.insert(endWord);
        int ladder = 2;

        while (!head.empty() && !tail.empty()) {
            if (head.size() < tail.size()) {
                phead = &head;
                ptail = &tail;
            } else {
                phead = &tail;
                ptail = &head;
            }

            unordered_set<string> temp;

            for (auto it = phead -> begin(); it != phead -> end(); it++) {    
                string word = *it;
                for (int i = 0; i < word.size(); i++) {
                    char t = word[i];
                    for (int j = 0; j < 26; j++) {
                        word[i] = 'a' + j;
                        if (ptail -> find(word) != ptail -> end()) {
                            return ladder;
                        }
                        if (dict.find(word) != dict.end()) {
                            temp.insert(word);
                            dict.erase(word);
                        }
                    }
                    word[i] = t;
                }
            }

            ladder++;
            phead -> swap(temp);
        }
        return 0;
    }
};