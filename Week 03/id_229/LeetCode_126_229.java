import javafx.util.Pair;

import java.util.*;

public class LeetCode_126_dancijielong2 {

    //输出相应的路径
    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        //结果集
        List<List<String>> res = new ArrayList<>();
        Set<String> distSet = new HashSet<>(wordList);
        //字典中不包含目标单词
        if (!distSet.contains(endWord)) {
            return res;
        }
        //已经访问过的单词集合：只找最短路径，所以之前出现过的单词不用出现在下一层
        Set<String> visited = new HashSet<>();
        //积累每一层的结果队列
        Queue<List<String>> queue = new LinkedList<>();
        List<String> list = new ArrayList<>(Arrays.asList(beginWord));
        queue.add(list);
        visited.add(beginWord);
        //是否到达符合条件的层
        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            //上一层的结果队列
            int size = queue.size();
            //// 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
            // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
            //如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                //获取该路径上一层的单词
                String word = path.get(path.size() - 1);
                char[] chars = word.toCharArray();
                //寻找该单词的下一个符合条件的单词
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[j] = ch;
                        if (temp == ch) {
                            continue;
                        }
                        String str = new String(chars);
                        //符合条件：在wordList中 &&之前的层没有使用过
                        if (distSet.contains(str) && !visited.contains(str)) {
                            //生成新的路径
                            List<String> pathList = new ArrayList<>(path);
                            pathList.add(str);
                            //如果该单词是目标单词：将该路径添加到结果集中，查询截止到该层
                            if (str.equals(endWord)) {
                                flag = true;
                                res.add(pathList);
                            }
                            //将该路径添加到该层队列中
                            queue.add(pathList);
                            //将该单词添加到该层已访问的单词集合中
                            subVisited.add(str);
                        }
                    }
                    chars[j] = temp;
                }
            }
            //将该层所有访问的单词添加到总的已访问集合中
            visited.addAll(subVisited);
        }
        return res;
    }


}
