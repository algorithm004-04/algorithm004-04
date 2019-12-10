 class Solution {
 public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordList_set = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Map<String, ArrayList<String>> next_word_map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();

        bfs(beginWord, endWord, next_word_map, distance, wordList_set);
        dfs(beginWord, endWord, next_word_map, 0, res, new ArrayList<String>(Arrays.asList(beginWord)), distance);
        return res;
    }

    private void dfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, int step, List<List<String>> res, ArrayList<String> tmp, Map<String, Integer> distance) {
        
        if (tmp.get(tmp.size() - 1).equals(endWord)) res.add(new ArrayList<>(tmp));
        for (String word : next_word_map.get(tmp.get(tmp.size() - 1))) {
            tmp.add(word);
            if (distance.get(word) == step + 1) dfs(word, endWord, next_word_map, step + 1, res, tmp, distance);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void bfs(String beginWord, String endWord, Map<String, ArrayList<String>> next_word_map, Map<String, Integer> distance, Set<String> wordList_set) {
        for (String s : wordList_set) next_word_map.put(s, new ArrayList<String>());
        next_word_map.put(beginWord, new ArrayList<>());
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean flag = false;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String word = queue.poll();
                for (String nw : next_word(word, wordList_set)
                ) {
                    next_word_map.getOrDefault(word, new ArrayList<>()).add(nw);
                    if (nw.equals(endWord)) flag = true;
                    if (!distance.containsKey(nw)){
                        distance.put(nw, step);
                        queue.offer(nw);   
                    } 
                    
                }
            }
            if (flag) break;
        }
    }

    private ArrayList<String> next_word(String word, Set<String> wordList_set) {
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String tmp = new String(chars);
                if (!tmp.equals(word) && wordList_set.contains(tmp)) ans.add(tmp);
            }
        }
        return ans;
    }
}