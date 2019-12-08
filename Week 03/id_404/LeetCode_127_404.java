import javafx.util.Pair;
/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    // 时间复杂度 O(M * N), 其中 M 是单词的长度，N 是单词表中的总数
    // 空间复杂度 O(M * N), 其中 M 是单词的长度，N 是单词表中的总数
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // since all words are of same lenth
        int len = beginWord.length();

        // Dictionary to hld combination of words that can be formed,
        // form any given word. By changine one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });
        allComboDict.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
 });

        // Queue for BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < len; i ++) {
                // intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);

                // Next states are all the words, which share the same intemediate state.
                for (String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what are looking for
                    // i.e the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // Otherwise, add it to the BFS Queue. Also make it visited
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        queue.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }

        }
        return 0;
    }

    private Integer len;
    private HashMap<String, ArrayList<String>> allComboDict;

    public Solution() {
        this.len = 0;
        this.allComboDict = new HashMap();
    }

    private int visitWordNode(
                              Queue<Pair<String, Integer>> queue,
                              HashMap<String, Integer> visited,
                              HashMap<String, Integer> otherVisited
                              ) {
        Pair<String, Integer> node = queue.remove();
        String word = node.getKey();
        Integer level = node.getValue();
        for (int i = 0; i < this.len; i++ ) {
            String newWord = word.substring(0, i) +
                '*' + word.substring(i + 1, this.len);
            for (String adjacentWord: this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                if (otherVisited.containsKey(adjacentWord)) {
                    return level + otherVisited.get(adjacentWord);
                }
                if (!visited.containsKey(adjacentWord)) {
                    visited.put(adjacentWord, level + 1);
                    queue.add(new Pair(adjacentWord, level + 1));
                }
            }
        }

        return -1;
    }

    // 时间复杂度 O(M + N), 其中 M 是单词的长度，N 是单词表中的总数
    // 空间复杂度 O(M + N), 其中 M 是单词的长度，N 是单词表中的总数
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        this.len = beginWord.length();
        wordList.forEach(word -> {
                for (int i = 0; i < this.len; i++) {
                    String newWord = word.substring(0, i) + '*' +
                        word.substring(i + 1, this.len);
                    ArrayList transformations = this.allComboDict.getOrDefault(newWord, new ArrayList());
                    transformations.put(word);
                    this.allComboDict.put(newWord, transformations);
                }
            });

        Queue<Pair<String, Integer>> queue_begin = new LinkedList();
        queue_begin.add(new Pair(beginWord, 1));
        Queue<Pair<String, Integer>> queue_end = new LinkedList();
        queue_end.add(new Pair(endWord, 1));

        HashMap<String, Integer> visited_begin = new HashMap();
        visited_begin.put(beginWord, 1);
        HashMap<String, Integer> visited_end = new HashMap();
        visited_end.put(endWord, 1);

        while (!queue_begin.isEmpty() && !queue_end.isEmpty()) {
            int ans = visitWordNode(queue_begin, visited_begin, visited_end);
            if (ans > -1) {
                return ans;
            }

            ans = visitWordNode(queue_end, visited_end, visited_begin);
            if (ans > -1) {
                return ans;
            }
        }

        return 0;
    }
  }
// @lc code=end
