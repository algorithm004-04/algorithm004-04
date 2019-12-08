class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordList.add(beginWord);
		Map<String, List<String>> graph = buildGraph(wordList);
        	// bfs
		int ans = 0;
		LinkedList<String> queue = new LinkedList<>();
		Set<String> visit = new HashSet<>();
		queue.addLast(beginWord);
		visit.add(beginWord);
		while (!queue.isEmpty()) {
			ans++;
			int size = queue.size();
			while (size > 0) {
				String s = queue.pollFirst();
				if (s.equals(endWord)) {
					return ans;
				}
				List<String> adjs = graph.get(s);
				for (String adj : adjs) {
					if (!visit.contains(adj)) {
						queue.addLast(adj);
						visit.add(adj);
					}
				}
				size--;
			}
		}
		return 0;
	}
    	// buildGraph
	private Map<String, List<String>> buildGraph(List<String> wordList) {
		Map<String, List<String>> ans = new HashMap<>();
		HashSet<String> set = new HashSet<>(wordList);
		wordList.forEach(s -> ans.put(s, getString(s, set)));
		return ans;
	}

	private List<String> getString(String str, Set<String> wordList) {
		List<String> ans = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char[] chars = str.toCharArray();
			char original = chars[i];
			for (char c = 'a'; c <= 'z'; c++) {
				if (original != c) {
					chars[i] = c;
					String s = String.valueOf(chars);
					if (wordList.contains(s)) {
						ans.add(s);
					}
				}
			}
		}
		return ans;
	}
}
