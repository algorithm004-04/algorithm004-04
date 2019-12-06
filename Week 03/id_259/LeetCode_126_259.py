'''
class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        wordList = set(wordList)
        if endWord not in wordList:
            return []
        res = [] #答案
        visited = set() #用于剪枝的已访问hash
        forward = {beginWord: [[beginWord]]} #前向分支
        backword = {endWord: [[endWord]]}   #后向分支
        _len = 2 #当前的前向分支和后向分支的路径和的长度
        while forward:
            if len(forward) > len(backword):    #始终从路径分支较短的一端做BFS
                forward, backword = backword, forward
            tmp = {}    #存储新的前向分支
            while forward:
                word, paths = forward.popitem()     #取出路径结束词以及到达它的所有路径
                visited.add(word)   #记录已访问的
                for i in range(len(word)):
                    for a in 'abcdefghijklmnopqrstuvwxyz':  #对结束词尝试每一次的置换
                        new = word[:i] + a + word[i+1:]
                        if new in backword: #如果在后向分支列表里发现置换后的词，则路径汇合
                            if paths[0][0] == beginWord:    #前向分支是从beginWord开始的，添加路径汇合的笛卡尔积
                                res.extend(fPath + bPath[::-1] for fPath in paths for bPath in backword[new])
                            else:   #后向分支是从endWord开始的，添加路径汇合的笛卡尔积
                                res.extend(bPath + fPath[::-1] for fPath in paths for bPath in backword[new])
                        if new in wordList and new not in visited:  #仅当wordList存在该词且尚未被访问过才进行BFS
                            tmp[new] = tmp.get(new, []) + [path + [new] for path in paths]
            _len += 1
            if res and _len > len(res[0]):  #res已有答案，且下一次的BFS的汇合路径长度已超过当前长度，不是最短
                break
            forward = tmp   #更新前向分支
        return res

'''

'''

'''
import string
import collections
class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        wordList = set(wordList)
        res = []
        layer = {}
        layer[beginWord] = [[beginWord]]

        while layer:
            print('*' * 40)
            newlayer = collections.defaultdict(list)
            for w in layer:
                if w == endWord:
                    print('res:{},layer[{}]:{}'.format(res, w, layer[w]))
                    res.extend(k for k in layer[w])
                    print('####res:{},layer[{}]:{}'.format(res, w, layer[w]))
                else:
                    for i in range(len(w)):
                        for c in string.ascii_lowercase:
                            new_w = w[:i] + c + w[i+1:]
                            if new_w in wordList:
                                print('layer[{}]:{}'.format(w, layer[w]))
                                newlayer[new_w] += [j + [new_w] for j in layer[w]]
                                print('newlayer[{}]:{}'.format(new_w, newlayer[new_w]))
            wordList -= set(newlayer.keys())
            layer = newlayer
            print('wordList:{},layer:{}'.format(wordList, layer))
        return res



beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
# beginWord = "hot"
# endWord = "dog"
# wordList = ["hot","dog","dot"]
aa = Solution()
print(aa.findLadders(beginWord,endWord,wordList))
