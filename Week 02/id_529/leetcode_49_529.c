/*字母异位词
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
#include<string.h>
#include<stdio.h>
#include <stdlib.h>
int isAnagram(char * str1, char * str2)
{
    int table[26] = {0};
    int i;
    if (strlen(str1) != strlen(str2)) {
        return 0;
    }
    while (*str1 != '\0'){
        table[*str1 - 'a'] += 1;
        str1++;
        table[*str2 - 'a']--;
        str2++;
    }
    for (i = 0; i < 26; i++) {
        if (table[i] != 0) {
            return 0;
        }
    }
    return 1;   
}
char *** groupAnagrams(char strs[][4], int strsSize, int* returnSize, int** returnColumnSizes){
    char ***result = (char ***)malloc(sizeof(char**)*strsSize);
    int i;
    int j;
    int *flag = calloc(strsSize, sizeof(int));
    *returnColumnSizes = malloc(strsSize * (sizeof(int)));
    int count = 0;
    int col = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    for (i = 0; i < strsSize; i++) {
        if (flag[i] == 1){
            continue;
        }
        k = 0;
        n = 0;
        result[m] = malloc(sizeof(char*)*strsSize);
        result[m][k] = malloc(sizeof(char)*26);
        strcpy(result[m][k],strs[i]);
        k++;
        for (j = i + 1; j < strsSize; j++) {
            if (isAnagram(strs[i], strs[j]) && (flag[j] != 1)) {
                flag[j] = 1;
                result[m][k] = malloc(sizeof(char)*26);
                strcpy(result[m][k],strs[j]);
                k++;
            }
        }
        (*returnColumnSizes)[m] = k;
        m++;
    }
    *returnSize = m;
    return result;
}

void main()
{
    char str[][4] = {"eat", "tea", "tan", "ate", "nat", "bat"};
    int returnSize;
    int *returnColumnSizes = 0;
    char ***result2 =  groupAnagrams(str, 6, &returnSize, &returnColumnSizes);
    int i = 0;
    int j = 0;
    for (i = 0; i < returnSize; i++) {
        for (j = 0; j < returnColumnSizes[i]; j++) {
            printf("%s,", result2[i][j]);
        }
        printf("\n");
    }
}