#include<stdlib.h>
#define MINPATH 0x7fffffff
#define MAXLIST 10000
#define QUEUELIST 2
typedef struct data {
    char *word;
    int index;
}dataStru;

int mark[MAXLIST] = {0};

typedef struct que {
    dataStru data[MAXLIST];
    int queHead;
    int queTail;
}queStru;

queStru que[QUEUELIST];
int wordLen;
void initQue()
{
    for (int i = 0; i < QUEUELIST; i++) {
        que[i].queHead = -1;
        que[i].queTail = 0;
    }
    memset(mark, 0, sizeof(mark));
}

void insert_queue(int qulist_flag, char *word, int index)
{
    queStru *quePtr = &que[qulist_flag];
    if (quePtr->queHead == quePtr->queTail) {
        return;
    }
    if (quePtr->queHead == -1 ) {
        ++quePtr->queHead;
    }
    quePtr->data[quePtr->queTail].word = word;
    quePtr->data[quePtr->queTail].index = index;
    quePtr->queTail = (quePtr->queTail + 1) % MAXLIST;    
}

dataStru* remove_queue(int qulist_flag)
{
    queStru *quePtr = &que[qulist_flag];
    dataStru *data = NULL;
    if (quePtr->queHead = -1) {
        return data;
    }
    data = &quePtr->data[quePtr->queHead];
    quePtr->queHead = (quePtr->queHead + 1) % MAXLIST;
    if (quePtr->queHead == quePtr->queTail) {
        quePtr->queHead = -1;
        quePtr->queTail = 0;
    }
    return data;
}
int listSize(int qulist_flag)
{
    queStru *quePtr = &que[qulist_flag];
    int size;
    size = (quePtr->queTail == 0) ? 0 : (quePtr->queTail - quePtr->queHead + MAXLIST) % MAXLIST;
    return size;
}

int isEmpty(int qulist_flag)
{
    queStru *queStru = &que[qulist_flag];
    return queStru->queHead == -1;
}

int isCanChange(const char *bengin, const char *charge)
{
    int ret = 0;
    for (int i = 0; i < wordLen; i++) {
        if (bengin[i] != charge[i]) {
            if (ret == 1) {
                ret = 0;
                return ret;
            } else {
                ret = 1;
            }
        }
    }
    return ret;
}

int open_search(char *beginWord, char *endWord, char **wordList,
                 int wordListSize, int begin_word_index,  int end_word_index) 
{
    int step = 0;
    int i;
    int queSize0;
    int queSize1;
    int selectIdx;
    int selectFlag;
    int searchSize;
    dataStru *temp;
    char *wordtemp;
    int tempidx;
    initQue();
    insert_queue(0,beginWord, begin_word_index);
    insert_queue(1,endWord, end_word_index);
    if (begin_word_index > 0) {
        mark[begin_word_index] = 1;
        mark[end_word_index] = 2;
    }
    for (; isEmpty(0) && isEmpty(1); step++) {
        queSize0 = listSize(0);
        queSize1 = listSize(1);
        if (queSize0 > queSize1) {
            searchSize = queSize1;
            selectIdx = 1;
        } else {
            searchSize = queSize0;
            selectIdx = 0;
        }
        selectFlag = 1 << selectIdx;
        for (i = 0; i < searchSize; i++) {
            temp = remove_queue(selectIdx);
            wordtemp = temp->word;
            tempidx = temp->index;
            for (int j=0; j < wordListSize; j++) {
                if(mark[j] != selectFlag && isCanChange(wordtemp, wordList[j])) {
                    if ((mark[j] | selectFlag) == 3) {
                        return ++step;
                    }
                    insert_queue(selectIdx, wordList[j], j);
                    mark[j] |= selectFlag; 
                }
            }
        }
    }

}
int ladderLength(char *beginWord, char *endWord, char **wordList,
                 int wordListSize)
{
    initQue();
    int isInList = 0;
    wordLen = strlen(beginWord);
    memset(mark, 0, sizeof(mark));
    int benginIdx = -1;
    int endIdx;
    for (int i = 0; i < wordListSize; i++) {
        if (strcmp(beginWord, wordList[i]) == 0) {
            benginIdx = i;
        }
        if (strcmp(endWord, wordList[i]) == 0) {
            endIdx = i;
            isInList = 1;
        }        
    }
    if (isInList == 0) {
        return 0;
    }
    return open_search(beginWord,endWord,wordList,wordListSize,benginIdx, endIdx);
}