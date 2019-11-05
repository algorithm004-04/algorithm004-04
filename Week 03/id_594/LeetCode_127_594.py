from collections import defaultdict


def ladderLength(beginWord, endWord, wordList:list):
    L = len(beginWord)
    all_word = defaultdict(list)
    for word in wordList:
        for i in range(L):
            # all_word 储存wordlist中单词的不同映射
            all_word[word[:i] + "*" + word[i+1:]].append(word)

    queue = [(beginWord, 1)]
    # 当visited的单词，状态转化为True
    visited = {beginWord: True}
    while queue:
        # 先进先出的队列规则
        cur_word, level = queue.pop(0)
        for i in range(L):
            # 从队列获得的word不同条件下的映射
            temp_word = cur_word[:i] + "*" + cur_word[i+1:]     # 这里元祖拼接会在本地报错，但LC上却没有。。。
            # 从all_word 字典中匹配 对应的word，也就是说明有符合条件的映射→重点，不过比较好奇的是，这里找不到的
            for word in all_word[temp_word]:
                # 判断获得的 word 是否等于 endword，其实就是是否得到最短距离
                if word == endWord:
                    return level+1
                # 这个是判断新词，新词就加到visited，并且增加层级
                if word not in visited:
                    visited[word] = True
                    # 符合条件的word和level加入到队列里面
                    queue.append((word, level+1))
            # 如果没有匹配的话，则用空list作为key
            all_word[temp_word] = []
    return 0


begin = "hit"
end = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]

print(ladderLength(begin, end, words))
