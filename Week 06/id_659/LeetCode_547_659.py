class Solution(object):
    def findCircleNum(self, M):
   
        n = len(M)
        group = [i for i in range(n)]      

        def get_group(x):                
            while group[x] != x:
                group[x] = group[group[x]]  
                x = group[x]
            return x

        for i in range(1, n):
            for j in range(i):             
                if M[i][j] == 1:
                    group[get_group(i)] = get_group(j)  
        return len(set(get_group(i) for i in range(n)))
