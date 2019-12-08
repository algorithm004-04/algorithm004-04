"""
There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
Example 1:
Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.
Example 2:
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
Note:
N is in range [1,200].
M[i][i] = 1 for all students.
If M[i][j] = 1, then M[j][i] = 1.
"""


class Solution:
    def findCircleNum(self, M: List[List[int]]) -> int:
        visited = [0] * len(M)
        cnt = 0
        
        for i in range(len(M)):
            if not visited[i]:
                self.dfs(M, visited, i)
                cnt += 1
        
        return cnt
        
    
    def dfs(self, M: List[List[int]], visited: List[int], person: int) -> None:
        for friend in range(len(M)):
            if M[person][friend] == 1 and not visited[friend]:
                visited[friend] = 1
                self.dfs(M, visited, friend)
                
