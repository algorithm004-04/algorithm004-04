class Solution:
    def ladderLength(self, beginWord, endWord, wordList):
        if endWord not in wordList: return 0

        front = {beginWord}
        back = {endWord}
        dist = 1 # 走的步数
        wordList = set(wordList)
        wordLen = len(beginWord)
        while front:
            dist += 1
            next_front = set()
            for word in front:
                for i in range(wordLen):
                    for c in string.lowercase: # 'a' - 'z'
                        if c != word[i]:
                            new_word = word[:i] + c + word[i+1:]
                            if new_word in back:
                                return dist
                            if new_word in wordList:
                                next_front.add(new_word)
                                wordList.remove(new_word)
            front = next_front
            if len(back) < len(front):
                front, back = back, front

        return 0
        

