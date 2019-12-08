/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
1,暴力：
1，长度相同，2，s的每个字母在t中都有，t中的每个字母在s中也都有
复杂度O(n^2) 
2，排序之后比较
复杂度O(nlogn)
3, hash acii 码值作为hash 函数，遍历hash表
O(n)
*/
#include <string.h>
#include <stdio.h>
void hashTableGen(char *s, int *hashTable)
{
    while (*s != '\0') {
        hashTable[*s - 'a']++;
        s++;
    }
}
int compare(int *hashTab1, int *hashTab2)
{
    int i;
    for (i = 0; i < 26; i++) {
        if (hashTab1[i] != hashTab2[i]) {
            return 0;
        }
    }
    return 1;
}
int isAnagram(char * s, char * t)
{
    int hashTableS[26] = {0};
    int hashTableT[26] = {0};
    int ret;
    hashTableGen(s, hashTableS);
    hashTableGen(t, hashTableT);
    ret = compare(hashTableS, hashTableT);
    return ret;
}
void main()
{
    char *s = "anagram";
    char *t = "nagaram";
    int ret;
    ret = isAnagram(s, t);
    printf("%d", ret);

}