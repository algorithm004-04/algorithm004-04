//ＢＦＳ
class Solution {
public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {

        unordered_set<string> dict(wordList.begin(),wordList.end());//借助这个字典来创建邻边
        queue<string>  queue;
        queue.push(beginWord);
        int ladder = 1;

        while(!queue.empty()){
            int n = queue.size();
            for(int i = 0 ; i < n; i++){
                string word = queue.front();//获取队列的元素
                queue.pop();//弹出元素
                if(word == endWord){
                    return ladder;
                }

                //找到应该和该单词相连接的邻边
                dict.erase(word);

                for(int j = 0; j < word.length();j++){
                    char c = word[j];
                    for(int k = 0; k < 26; k++){
                        word[j] = 'a' + k;
                        if(dict.find(word) != dict.end()){
                            queue.push(word);
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
