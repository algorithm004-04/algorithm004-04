import javafx.util.Pair;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private Map<String, List<String>> wordsMapping = new HashMap<>();
    HashMap<String, Boolean> visited = new HashMap<String, Boolean>();


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int lengthOfWord = beginWord.length();
        initWordsMapping(wordList, lengthOfWord);

        Deque<Pair<String, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);

        while (!deque.isEmpty()) {
            Pair<String, Integer> pair = deque.pollFirst();
            String word = pair.getKey();
            int level = pair.getValue();

            for (int i = 0; i < lengthOfWord; i++) {
                String genericWordForm = word.substring(0, i) + "*" + word.substring(i + 1, lengthOfWord);
                List<String> adjacentWords = this.wordsMapping.getOrDefault(genericWordForm, new ArrayList<>());

                for (String adjacentWord : adjacentWords) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.containsKey(adjacentWord)){
                        deque.add(new Pair<>(adjacentWord, level + 1));
                        visited.put(adjacentWord, Boolean.TRUE);
                    }
                }

            }

        }

        return 0;
    }

    private void initWordsMapping(List<String> wordList, int lengthOfWord) {

        for (String word : wordList) {
            for (int i = 0; i < lengthOfWord; i++){
                String genericWordForm = word.substring(0, i) + "*" + word.substring(i + 1, lengthOfWord);
                List<String> words = this.wordsMapping.getOrDefault(genericWordForm, new ArrayList<>());
                words.add(word);
                this.wordsMapping.put(genericWordForm, words);
            }
        }
    }
}