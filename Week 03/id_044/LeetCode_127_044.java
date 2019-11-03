package week_03.lesson9;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 2;
        }
        Set<String> result = new HashSet<>(wordList);

        Set<String> beginSet = new HashSet<>(Collections.singleton(beginWord));
        Set<String> endSet = new HashSet<>(Collections.singleton(endWord));

        return search(1, beginSet, endSet, result);


    }

    private static int search(int level, Set<String> beginSet, Set<String> endSet, Set<String> result) {

        if (beginSet.size() == 0 || endSet.size() == 0) {
            return 0;
        }

        result.removeAll(beginSet);
        level++;
        Set<String> nextLevelSet = new HashSet<>();
        for (String beginWord : beginSet) {
            char[] chars = beginWord.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch < 'z'; ch++) {
                    chars[i] = ch;
                    String newWord = String.valueOf(chars);
                    if (!result.contains(newWord)) {
                        continue;
                    }
                    if (endSet.contains(newWord)) {
                        return level;
                    }
                    nextLevelSet.add(newWord);
                }
                chars[i] = temp;
            }
        }

        if (nextLevelSet.size() <= endSet.size()) {
            beginSet = nextLevelSet;
        } else {
            beginSet = endSet;
            endSet = nextLevelSet;
        }

        return search(level, beginSet, endSet, result);
    }


    public static void main(String[] args) {
        System.out.println(ladderLength("hit","cog",
                new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }

}
