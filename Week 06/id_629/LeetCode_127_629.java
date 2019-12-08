package com.zhk.Search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

//leetcode 127
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
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
                            temp.add(target);
                            visited.add(target);
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
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) { // crucial for Solution #2
            return 1;
        }

        Deque<String> deque1 = new ArrayDeque<>(); // use as queue
        Deque<String> deque2 = new ArrayDeque<>(); // use as queue

        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();

        deque1.add(beginWord);
        deque2.add(endWord);

        visited1.add(beginWord);
        visited2.add(endWord);

        int distance = 2;

        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            if (checkNeighbors(deque1, visited1, visited2, words)) {
                return distance;
            }
            distance++;
            if (checkNeighbors(deque2, visited2, visited1, words)) {
                return distance;
            }
            distance++;
        }
        return 0; // no transformation sequence exists
    }

    private boolean checkNeighbors(Deque<String> deque,
                                   Set<String> visitedFromThisSide,
                                   Set<String> visitedFromThatSide,
                                   Set<String> words) {
        int wordsInLevel = deque.size();
        for (int i = 0; i < wordsInLevel; i++) {
            String word = deque.removeFirst();
            for (String neighbor : getNeighbors(word, words)) {
                if (visitedFromThatSide.contains(neighbor)) {
                    return true;
                }
                if (!visitedFromThisSide.contains(neighbor)) {
                    visitedFromThisSide.add(neighbor);
                    deque.add(neighbor);
                }
            }
        }
        return false;
    }

    // Generates all possible neighbors of given String
    private Set<String> getNeighbors(String str, Set<String> words) {
        Set<String> validWords = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char[] neighbor = str.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                neighbor[i] = ch;
                String word = new String(neighbor);
                if (words.contains(word)) {
                    validWords.add(word);
                }
            }
        }
        validWords.remove(str); // original String is not its own neighbor
        return validWords;
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        HashSet<String> hs = new HashSet<>();
        hs.add("hot");
        hs.add("dot");
        hs.add("dog");
        hs.add("lot");
        hs.add("log");
        hs.add("cog");
        int res = wl.ladderLength("hit","cog",hs);
    }
}
