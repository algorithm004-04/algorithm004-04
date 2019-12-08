class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        // wordList.push_back(beginWord);
        return helper(beginWord,endWord,wordList);
    }
    
private:
    int helper(string beginWord, string endWord, vector<string>& wordList){
        // int step = 0;
        // unordered_set<string> word_set(wordList.begin(), wordList.end());
        // if (word_set.find(endWord) == word_set.end())
        // {
        //     return 0;
        // }
        // queue<string> q;
        // q.push(beginWord);
        // while (!q.empty())
        // {
        //     int size = q.size();
        //     for (int i = 0; i < size; i++)
        //     {
        //         string word = q.front();
        //         q.pop();
        //         word_set.erase(word); // word_set里删掉表示已经遍历过
        //         if (word == endWord)
        //         {
        //             step++;
        //             return step;
        //         }
        //         for (int j = 0; j < word.size(); j++)
        //         {
        //             char c = word[j];
        //             for (int k = 0; k < 26; k++)
        //             {
        //                 word[j] = 'a' + k;
        //                 if (c != word[j] && word_set.find(word) != word_set.end())
        //                 {
        //                     q.push(word);
        //                 }
        //             }
        //             word[j] = c;
        //         }
        //     }
        //     step++;
        // }
        // return 0;
        
        int step = 1;
        unordered_map<string,int> word_map;
        for(int i = 0; i < wordList.size(); i++){
            word_map[wordList[i]] = 0;
        }
        if(word_map.find(endWord) == word_map.end()){
            return 0;
        }
        queue<string> front_q,back_q;
        queue<string>* cur_q;
        word_map[beginWord] = 1;
        word_map[endWord] = 2;
        front_q.push(beginWord);
        back_q.push(endWord);
        while(front_q.size() && back_q.size()){
            int flag = front_q.size() < back_q.size() ? 1 : 2;
            cur_q = flag == 1 ? &front_q : &back_q;
            int size = cur_q->size();
            for(int i = 0; i < size; i++){
                string temp = cur_q->front();
                cur_q->pop();
                cout<<temp<<endl;
                if(word_map[temp] == 3){
                    return step;
                }
                for(int j = 0; j < temp.size(); j++){
                    char c = temp[j];
                    for(int k = 0; k < 26; k++){
                        temp[j] = 'a' + k;
                        // 字母相同、word_map里没有这个词、已经被爬过的，就不再爬了
                        if(c == temp[j] || word_map.find(temp) == word_map.end() || word_map[temp] & flag){
                            continue;
                        }
                        word_map[temp] |= flag;
                        cur_q->push(temp);
                    }
                    temp[j] = c;
                }
            }
            step++;
        }
        return 0;
    }    
};