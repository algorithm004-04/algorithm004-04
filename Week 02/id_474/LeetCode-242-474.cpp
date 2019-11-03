
/*
 *    有效的字母异位词
 *    https://leetcode-cn.com/problems/valid-anagram/description/
 *
*/

#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std:

/*
    方法一： 排序

    时间复杂度：O(n * logn)
*/
bool isAnagram_1(string s, string t) {
    sort(s.begin(), s.end()); //sort函数的时间复杂度为n*longn
    sort(t.begin(), t.end());

    return s == t;
}


/*
    方法二： 计数器 -- unordered_map

    时间复杂度：O(n)
*/
bool isAnagram_2(string s, string t) {
	if (s.length() != t.length())
		return false;

	unordered_map<char, int> charCounts;

	for (int i = 0; i < s.length(); i++) {
		charCounts[s[i]]++;
		charCounts[t[i]]--;
	}

	for (auto count : charCounts) {
		if (count.second)
			return false;
	}

	return true;
}

/*
    方法三： 计数器--数组

    由于题目说 “字符串仅包含小写字母”，

    时间复杂度：O(n)
*/
bool isAnagram_3(string s, string t) {
    if (s.length() != t.length()) 
        return false;

    int n = s.length();
    int counts[26] = {0};

    for (int i = 0; i < n; i++) { 
        counts[s[i] - 'a']++;
        counts[t[i] - 'a']--;
    }

    for (int i = 0; i < 26; i++)
        if (counts[i]) 
            return false;

    return true;
}