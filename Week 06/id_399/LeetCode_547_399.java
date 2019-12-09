class Solution {
	public int findCircleNum(int[][] members) {
		if (members[0].length == 0 || members.length == 1) {
			return members.length;
		}
		QuickUnionUF quickUnionUF = new QuickUnionUF(members.length + members[0].length);
		for (int i = 0; i < members.length; i++) {
			for (int j = 0; j < members[i].length; j++) {
				int first = i;
				int second = j + members.length;
				if (members[i][j] == 1) {
					quickUnionUF.union(first, second);
				}
			}
		}

		return quickUnionUF.groups();
	}

	public class QuickUnionUF {
		private int[] parent;   // parent[i] = parent of i
		private int count;      // number of components


		public QuickUnionUF(int n) {
			count = n;
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}


		public int count() {
			return count;
		}

		public int groups() {
			Set<Integer> cache = new HashSet<>();
			for (int i = 0; i < parent.length; i++) {
				cache.add(parent[i]);
			}
			return cache.size();
		}

		public int find(int p) {
			validate(p);
			return parent[p];
		}

		// validate that p is a valid index
		private void validate(int p) {
			int n = parent.length;
			if (p < 0 || p >= n) {
				throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
			}
		}

		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public void union(int p, int q) {
			int rootP = find(p);
			int rootQ = find(q);
			if (rootP == rootQ) return;
			for (int i = 0; i < parent.length; i++) {
				if (parent[i] == rootP) {
					parent[i] = rootQ;
				}
			}

			count--;
		}
	}
}