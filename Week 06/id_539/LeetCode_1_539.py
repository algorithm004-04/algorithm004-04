class Solution(object):
    def findCircleNum(self, M):
        """
        :type M: List[List[int]]
        :rtype: int
        """
        if not M:
            return 0
    
        dim = len(M)
        p = [i for i in range(dim)]

        for i in range(dim):
            for j in range(1, dim):
                if M[i][j] == 1:
                    self._union(p, i,j)

        return len(set(self._parent(p ,i) for i in range(dim)))
    


    def _union(self, p, i, j):
        p1=self._parent(p,i);
        p2=self._parent(p,j);
        p[p2]=p1
        

    def _parent(self, p, i):
        root = i
        while p[root] !=root:
            root = p[root]
        while p[i]!=i: # 路径压缩
            x =i
            i=p[i]
            p[x]=root

        return root