package algorithm.homework.week06;

import javafx.util.Pair;

import java.util.*;

public class LeetCode_374_127 {
    public static void main(String[] args) {

    }

    /**
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int l = beginWord.length();
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<>();
        wordList.forEach(
                word -> {
                    for (int i = 0; i < l; ++i) {
                        String newword = word.substring(0, i) + '*' + word.substring(i + 1, l);
                        ArrayList<String> transformations = allComboDict.getOrDefault(newword, new ArrayList<String>());
                        transformations.add(word);
                        allComboDict.put(newword, transformations);
                    }
                }
        );
        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        queue.add(new Pair<>(beginWord, 1));
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < l; ++i) {
                String newword = word.substring(0, i) + '*' + word.substring(i + 1, l);
                for (String adjacentWord:allComboDict.getOrDefault(newword,new ArrayList<String>())){
                    if (adjacentWord.equals(endWord)) {
                        return  level + 1;
                    }
                    if (!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord,true);
                        queue.add(new Pair<>(adjacentWord,level +1 ));
                    }
                }
            }
        }
        return 0;
    }
}
