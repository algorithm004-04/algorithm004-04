#include <iostream>
#include <vector>
#include <stack>
#include <assert.h>
using namespace std;

/*
 *LeetCode 17题 Letter Combinnation of a Phone
 * digits是数字字符串
 * s(digits)是digits所能代表的字符字符串
 * s(digits[0...n-1])
 * letter(digits[0]) + s(digits[1...n-1])
 * letter(digits[0]) + letter(digits[1]) + s(digits[2...n-1])
 */

class Solution {
private:
    const string letterMap[10] = {
      " ",
      "",
      "abc",
      "def",
      "ghi",
      "jkl",
      "mno",
      "pqrs",
      "tuv",
      "wxzy",

    };

    vector<string> res;
    //s中保存了此时digits[0...index-1]翻译得到的一个字符字符串
    //寻找digits[index]匹配的字母，获得digits[0...index]翻译得到的解
    void findCombination(const string &digits, int index, const string &s) {
        cout << index << " : " << s <<endl;

        if(index == digits.size()){
            res.push_back(s);
            cout << "get " <<s<<" , return"<< endl;
            return;
        }

        char c = digits[index];
        assert(c >= '0' && c <= '9' && c!='1');
        string letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.size(); i++){
            cout << "digits[" << index <<"] = "<<c<<", use " << letters[i] << endl;
            findCombination(digits, index + 1,s+letters[i]);
        }

        cout<<"digits["<<index<<"] = "<<c<<" complete, return" <<endl;
    }
public:
    vector<string> letterCombinations(string digits) {
        res.clear();
        if(digits == "")
            return res;
        findCombination(digits,0,"");
        return res;
    }
};

int main(void)
{

    vector<string> res = Solution().letterCombinations("5");
    for(int i = 0 ; i < res.size(); i++)
        cout << res[i] << endl;
    
    return 0;
}

