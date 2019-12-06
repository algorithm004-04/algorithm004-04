https://leetcode-cn.com/problems/minimum-genetic-mutation/
class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        if end not in bank:
            return -1
        begin = {start}
        end = {end}
        beginStrLen = len(start)
        bank = set(bank)
        length = 0
        change = {'A': 'TCG', 'T': 'ACG', 'C': 'ATG', 'G': 'ATC'}
        while begin:
            length += 1
            nextGenSet = set()
            for gen in begin:
                for i in range(beginStrLen):
                    for j in change[gen[i]]:
                        if j != gen[i]:
                            nextGen = gen[:i] + j + gen[i + 1:]
                            if nextGen in end:
                                return length
                            if nextGen in bank:
                                nextGenSet.add(nextGen)
                                bank.remove(nextGen)
            begin = nextGenSet
            if len(end) < len(begin):
                end, begin = begin, end
        return -1