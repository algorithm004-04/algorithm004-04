import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javafx.util.Pair;

class Solution {
  public int ladderLength_old(String beginWord, String endWord, List<String> wordList) {
    int len = beginWord.length();
    HashMap<String, ArrayList<String>> allCombDict = new HashMap<String, ArrayList<String>>();

    wordList.forEach(word -> {
      for (int i = 0; i < len; i++) {
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
        ArrayList<String> transformations = allCombDict.getOrDefault(newWord, new ArrayList<String>());
        transformations.add(word);
        allCombDict.put(newWord, transformations);
      }
    });

    Queue<Pair<String, Integer>> queue = new LinkedList<>();
    queue.add(new Pair(beginWord, 1));

    HashMap<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while (!queue.isEmpty()) {
      Pair<String, Integer> node = queue.remove();
      String word = node.getKey();
      int level = node.getValue();

      for (int i = 0; i < len; i++) {
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);

        for (String adjacentWord : allCombDict.getOrDefault(newWord, new ArrayList<String>())) {
          if (adjacentWord.equals(endWord)) {
            return level + 1;
          }
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            queue.add(new Pair(adjacentWord, level + 1));
          }
        }
      }
    }

    return 0;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (!wordList.contains(endWord))
      return 0;

    Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();

    int len = 1;
    // int strLen = beginWord.length();
    HashSet<String> visited = new HashSet<>();

    beginSet.add(beiginWord);
    endSet.add(endWord);

    while (!beginSet.isEmpty() && !endSet.isEmpty()) {
      if (beginSet.size() > endSet.size()) {
        Set<String> set = beginSet;
        beginSet = endSet;
        endSet = set;
      }

      Set<String> temp = new HashSet<>();

      for (String word : beginSet) {
        char[] chs = word.toCharArray();

        for (int i = 0; i < chs.length; i++) {
          for (char c = 'a'; c <= 'z'; c++) {
            char old = chs[i];
            chs[i] = c;
            String target = String.valueOf(chs);

            if (endSet.contains(target)) {
              return len + 1;
            }

            if (!visited.contains(target) && wordList.contains(target)) {
              temp.add(targte);
              visited.add(traget);
            }
            chs[i] = old;
          }
        }
      }
      beginSet = temp;
      len++;
    }
    return 0;
  }
}