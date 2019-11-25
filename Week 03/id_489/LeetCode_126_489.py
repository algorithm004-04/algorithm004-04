from typing import List
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        from collections import defaultdict
        wordList = set(wordList)
        res = []
        # 记录单词下一步能转到的单词
        next_word_dict = defaultdict(list)
        # 记录到beginWord距离
        distance = {}
        distance[beginWord] = 0

        # 找一个单词能转到的单词
        def next_word(word):
            ans = []
            for i in range(len(word)):
                for j in range(97, 123):
                    tmp = word[:i] + chr(j) + word[i + 1:]
                    if tmp != word and tmp in wordList:
                        ans.append(tmp)
            return ans

        # 求到beginWord的距离
        def bfs():
            cur = [beginWord]
            step = 0
            flag = False
            while cur:
                step += 1
                next_time = []
                for word in cur:
                    for nw in next_word(word):
                        next_word_dict[word].append(nw)
                        if nw == endWord:
                            flag = True
                        if nw not in distance:
                            distance[nw] = step
                            next_time.append(nw)
                if flag:
                    break
                cur = next_time
            # 遍历所有从beginWord到endWord的路径

        def dfs(tmp, step):
            if tmp[-1] == endWord:
                res.append(tmp)
                return
            for word in next_word_dict[tmp[-1]]:
                if distance[word] == step + 1:
                    dfs(tmp + [word], step + 1)

        bfs()
        dfs([beginWord], 0)
        return res


if __name__ == '__main__':
    solution = Solution()
    print(solution.findLadders("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))