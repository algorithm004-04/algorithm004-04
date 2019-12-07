package week06;


class DisjointSet {
	//parents[i]表示第i个元素的boss的索引,初始parents[i]=i
	//每个元素是自身的boss
	int[] parents;
	int count;

	public DisjointSet(int m) {
		this.parents = new int[m];
		this.count = m;
		for (int i = 0; i < m; i++) {
			this.parents[i] = i;
		}
	}

	//路径压缩，将一个set内所有元素都指向他们的boss
	private int findP(int i) {
		int pi = this.parents[i];
		while (pi != i) {
			this.parents[i] = this.parents[pi];
			i = pi;
			pi = this.parents[i];
		}
		return pi;
	}

	//合并操作，分表找到两个元素的boss，然后设置其中一个元素的boss为另一个元素的boss的boss
	public void join(int oi, int oj) {
		int i = oi, j = oj;
		int pi = this.findP(i);
		int pj = this.findP(j);
		if (pi != pj) {
			this.parents[pj] = pi;
			this.count--;
			i = oi;
			j = oj;
		}
	}
}

public class LeetCode_547 {
	public static int findCircleNum(int[][] M) {
		int len = M.length;
		DisjointSet ds = new DisjointSet(M.length);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if (M[i][j] == 1) {
					ds.join(i, j);
				}
			}
		}
		return ds.count;
	}

	public static void main(String[] args) {
		int[][] m = new int[][]{
				{1, 1, 0},
				{1, 1, 0},
				{0, 0, 1}
		};
		int count = findCircleNum(m);
		System.out.println(count);
	}
}
