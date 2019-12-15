from collections import defaultdict, deque

class Solution:
    def ladderLength(self, begin_word: str, end_word: str, word_list: List[str]) -> int:
        if end_word not in word_list:
            return 0 
        matched_word_dict = defaultdict(list)
        q = deque()
        visited = set()

        for word in word_list:
            for i in range(len(word)):
                matched_word_dict['{}{}{}'.format(word[:i], '*', word[i+1:])].append(word)

        q.append([begin_word, 1])

        while(q):
            word, level = q.popleft()
            for i in range(len(word)):
                next_words = matched_word_dict['{}{}{}'.format(word[:i], '*', word[i+1:])]
                for nw in next_words:
                    if nw == end_word:
                        return level + 1
                    if nw not in visited:
                        visited.add(nw)
                        q.append([nw, level + 1])
        return 0