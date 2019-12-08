class Solution {
    
    public int findCircleNum(int[][] M) {
		// 初始朋友圈个数
		int count = M.length;
		int father[] = new int[M.length];
		// 存储每个节点的秩
		int rank[] = new int[M.length];
		// 初始化父节点，father[x]=y表示x的父节点是y
		for (int i = 0; i < father.length; i++) {
			father[i] = i;
		}
		for (int i = 0; i < father.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (M[i][j] == 1)
					count = Union(father, rank, i, j, count);
			}
		}
		return count;
	}
 
	int find(int[] father, int x) {
		if (x != father[x]) {
			father[x] = find(father, father[x]); // 回溯时压缩路径
		}
		return father[x];
	}
 
	int Union(int[] father, int[] rank, int x, int y, int count) {
		x = find(father, x);
		y = find(father, y);
		if (x == y)
			return count;
		if (rank[x] > rank[y]) {
			father[y] = x;
		} else {
			if (rank[x] == rank[y]) {
				rank[y]++;
			}
			father[x] = y;
		}
		// 每次朋友圈合并，将朋友圈个数减1
		count--;
		return count;
    }
}