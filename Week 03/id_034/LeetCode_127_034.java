import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LeetCode_127_034 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- > 0) {
                String curr = queue.poll();

                if (curr.equals(endWord)) return level;

                char[] currArray = curr.toCharArray();

                for (int i = 0; i < currArray.length; i ++) {
                    char old = currArray[i];
                    for (char c = 'a'; c <= 'z'; c ++) {
                        currArray[i] = c;
                        String next = String.valueOf(currArray);
                        if (!visited.contains(next) && wordSet.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level ++;
        }
        return 0;
    }
}
