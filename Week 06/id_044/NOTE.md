# NOTE
双向BFS模板
public int twoBFS(String beginWord,String endWord, Set<String> wordList) {

    Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>(),
                visited = new HashSet<>();
    beginSet.add(beginWord);
    endSet.add(endWord);
    int len = 1;
    while(!beginSet.isEmpty() && !endSet.isEmpty()) {
        if (beginSet.size() > endSet.size()) {
            Set<String> tempSet = beginSet;
            beginSet = endSet;
            endSet = tempSet;
        }
        Set<String> temp = new HashSet<>();
        for (String word : beginSet) {
            String target = null;
            if (endSet.contains(target)) {
                return len++;
            }
            if (!visited.contains(target) && wordList.contains(target)) {
                temp.add(target);
                visited.add(target);
            }
        }
        beginSet = temp;
        len++;
    }

}
  

