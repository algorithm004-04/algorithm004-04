/*
 *    字母异位词分组
 *    https://leetcode-cn.com/problems/group-anagrams/
 *
*/

#include <unordered_map>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std:

/*
    方法一：排序数组分类 
*/
vector<vector<string>> groupAnagrams_1(vector<string>& strs) {
	unordered_map <string, vector<string>> mp;

	for (string s : strs) {
		string t = s;
        sort(t.begin(), t.end());
        mp[t].push_back(s);
	}

    vector<vector<string>> ret;

    for (auto p : mp){
       ret.push_back(p.second);
    }

    return ret;
}

/*
    方法二：排序数组分类 

    由于题中提到“字符串仅包含小写字母”，可以改进排序算法
*/
vector<vector<string>> groupAnagrams_2(vector<string>& strs) {
	unordered_map <string, vector<string>> mp;

	for (string s : strs) {
        mp[strSort(s)].push_back(s);
	}

    vector<vector<string>> ret;

    for (auto p : mp){
       ret.push_back(p.second);
    }

    return ret;
}

string strSort(string s){
    int counter[26] = {0};

    for (char c : s){
        counter[c - 'a']++;
    }

    string ret;

    for (int c = 0; c < 26; c++) {
        ret += string(counter[c], c + 'a');
    }

    return ret;    
}
