/*给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdio.h>
#include <string.h> 
void generatePara(int left, int right, int n, char *str1, char **str2, int *returnSize,int *capcacity)
{
    if (left == n && right == n) {
        str1[2*n] = '\0';
    //    printf("%d", *returnSize)
        str2[*returnSize] = malloc(sizeof(char)*(2*n+1));
        strcpy(&str2[*returnSize][0], str1);
        (*returnSize)++;
        if (*returnSize >= *capcacity) {
            *capcacity = 2 * (*capcacity);
            str2 = (char **)realloc(str2, sizeof(char*)*(*capcacity));
        }
        return;
    }

    if (left < n) {
        str1[left + right] = '(';
        generatePara(left+1, right, n, str1, str2, returnSize, capcacity);
    }
    if (left > right) {
        str1[left + right] = ')';
        generatePara(left, right + 1, n, str1, str2, returnSize, capcacity);
    }
}
char ** generateParenthesis(int n, int* returnSize){
    char *str1[1000];
    int capacity = 1000;
    char ** temp = malloc(sizeof(char*)*capacity);
    generatePara(0, 0, n, str1, temp, returnSize, &capacity);
    return temp;    
}
void main()
{
    int i;
    int returnSize = 0;
    char **temp = generateParenthesis(8, &returnSize);
    for (i = 0; i < returnSize; i++) {
        printf("%s\n", &temp[i][0]);
    }
    printf("%d\n", returnSize);
}