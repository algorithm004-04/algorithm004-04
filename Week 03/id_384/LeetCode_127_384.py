class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        res = 0
        wordList = set(wordList)
        if endWord not in wordList:
            return res
        q = [(beginWord, 1)]
        m = 'abcdefghigklmnopqrstuvwxyz'
        while q:
            v, step = q.pop(0)
            if v == endWord:
                if not res or step < res:
                    res = step
            for i, e in enumerate(v):
                for j in m:
                    r = v[: i] + j + v[i + 1:]
                    if r in wordList:
                        q.append((r, step + 1))
                        wordList.remove(r)
        return res
