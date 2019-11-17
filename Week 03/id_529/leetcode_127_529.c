#define MAXLIST 10000
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
int isCanChange(char *beginWord, char *endWord)
{
    int len = strlen(beginWord);
    int ret = 0;
    int len1 = strlen(endWord);
    if (len != len1) {
        return 0;
    }
    for (int i = 0; i < len; i++) {
        if (beginWord[i] != endWord[i]) {
            if (ret == 1) {
                return 0;
            } else {
                ret = 1;
            }
        }
    }
    return ret;
}
int ladderLength(char *beginWord, char *endWord, char wordList[][4], int wordListSize) 
{
    
    char *que[100] = {0};
    int head = 0;
    int tail = 0;
    int mark[MAXLIST] = {0};
    int i;
    int ladder = 1;
    int wordLen = strlen(wordList[0]);
    int queSize = 0;
    char *wordTemp;
    int isinlist = 0;
    /*  判断结束符在不在list 中 */
    for (i = 0; i < wordListSize; i++) {
        if(strcmp(endWord, wordList[i]) == 0) {
            isinlist = 1;
            break;
        }
    }
    if (isinlist == 0) {
        return 0;
    }
    /* beginWord 入队 */
    que[tail]  = beginWord;
    tail = (tail + 1) % MAXLIST;
    while (head != tail) {
        queSize = (tail - head + MAXLIST) % MAXLIST;
        for (i = 0; i < queSize; i++) {
            /* 出队 */
            wordTemp = que[head];
            head = (head + 1) % MAXLIST;
            if (strcmp(wordTemp, endWord) == 0) {
                return ladder;
            }
            for (int j = 0; j < wordListSize; j++) {
                if (mark[j] == 0 && isCanChange(wordTemp, wordList[j]) == 1) {
                    if ((tail + 1)%MAXLIST != head) {
                        que[tail] = wordList[j];
                        tail = (tail + 1) % MAXLIST;
                    }
                    mark[j] = 1;
                }
            }
        }
        ladder++;
    }
    return 0;
}

void main()
{
   // char wordList[7][4] = {"hot","dot","dog","lot","log","cog"};
  //  char wordList[3][2] = {"a", "b", "c"};
    char wordList[1][4] = {"cog"};
    char *beginWord = "hog";
    char *endWord = "cog";
    int ret;
    ret = ladderLength(beginWord,endWord,wordList, 1);
    printf("%d", ret);
}