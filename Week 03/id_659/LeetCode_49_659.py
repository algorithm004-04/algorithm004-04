
def ladderLength( beginWord: str, endWord: str, wordList):
    word_set = set(wordList)
    # 定义当前层的单词集合为beginWord
    cur_word = [beginWord]
    # 定义下一层的单词集合
    next_word = []
    # 定义从 beginWord 到 endWord 的最短转换序列的长度
    depth = 1
    removed=[]

    if endWord not in wordList:
        return 0

    level = 1
    while cur_word:
        for i in cur_word:
            for j in wordList:
                if diffWordCount(i, j):
                    if j == endWord:
                        return level + 1
                    if j not in next_word:
                        next_word.append(j)

        for k in next_word:
            wordList.remove(k)

        if len(next_word) > 0:
            level += 1
            cur_word = next_word
            next_word=[]
        else:
            return 0


def diffWordCount( i: str, j: str) -> bool:
    cnt = 0
    for index in range(len(i)):
        if i[index] != j[index]:
            cnt += 1

    return cnt == 1
print(ladderLength('red','tax',["ted","tex","red","tax","tad","den","rex","pee"]))