package week06;

import java.util.*;

class Trie2 {
	/**
	 * 利用Map动态分配空间
	 */
	class DynamicNode {
		Map<Integer, DynamicNode> children;
		boolean isWord;
		String theWord;

		public DynamicNode() {
			children = new HashMap<Integer, DynamicNode>();
		}

		public DynamicNode Get(int index) {
			return children.getOrDefault(index, null);
		}

		public void Set(int index, DynamicNode child) {
			children.put(index, child);
		}

		public String toString() {
			return this.theWord + "," + this.children;
		}
	}

	DynamicNode root;

	public Trie2() {
		this.root = new DynamicNode();
	}

	public void insert(String word) {
		DynamicNode root = this.root;
		int len = word.length();
		for (int i = 0; i < len; i++) {
			int index = word.charAt(i) - 'a';
			if (root.Get(index) == null) {
				DynamicNode child = new DynamicNode();
				root.Set(index, child);
				root = child;
			} else {
				root = root.Get(index);
			}
		}
		root.theWord = word;
		root.isWord = true;
	}

	public DynamicNode findLast(String word) {
		DynamicNode root = this.root;
		int len = word.length();
		for (int i = 0; i < len && root != null; i++) {
			int index = word.charAt(i) - 'a';
			root = root.Get(index);
		}
		return root;
	}

	public boolean search(String word) {
		DynamicNode root = this.findLast(word);
		return root == null ? false : root.isWord;
	}

	public boolean startsWith(String prefix) {
		DynamicNode root = this.findLast(prefix);
		return root != null;
	}

	public DynamicNode getRoot() {
		return this.root;
	}

	public DynamicNode getChar(DynamicNode node, char c) {
		return node.Get(c - 'a');
	}
}

public class LeetCode_212 {

	static Trie2 trie;
	static Trie2.DynamicNode root;

	public static List<String> findWords(char[][] board, String[] words) {
		if (board.length == 0) {
			return new ArrayList<>();
		}

		List<String> result;
		Set<String> temp = new HashSet<>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		trie = new Trie2();
		for (int i = 0; i < words.length; i++) {
			trie.insert(words[i]);
		}
		root = trie.getRoot();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				help(board, i, j, root, temp, visited);
			}
		}
		result = new ArrayList<>(temp);
		return result;
	}

	public static void help(
			char[][] board,
			int row,
			int col,
			Trie2.DynamicNode root,
			Set<String> result,
			boolean[][] visited) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length || visited[row][col])
			return;
		Trie2.DynamicNode node = trie.getChar(root, board[row][col]);
		if (node == null) return;
		if (node.isWord) {
			result.add(node.theWord);
		}
		visited[row][col] = true;
		root = node;
		help(board, row - 1, col, root, result, visited);
		help(board, row + 1, col, root, result, visited);
		help(board, row, col - 1, root, result, visited);
		help(board, row, col + 1, root, result, visited);
		visited[row][col] = false;
	}

	public static void main(String[] args) {
		char[][] board = new char[][]{{'a', 'a'}};
		String[] words = new String[]{"aaa"};
		List<String> r = findWords(board, words);
		System.out.println(r);
	}
}
