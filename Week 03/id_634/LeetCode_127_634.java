class Solution { 
    //1.暴力
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     //qs 每一轮遍历转换的初始集合  qe 每一轮遍历转换的目标 dict 所有可用词的集合即字典
    //     Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>();
    //     qs.add(beginWord);//加入转换词
    //     if (dict.contains(endWord)) {
    //         qe.add(endWord); //加入目标转换词
    //         //最小2步
    //         for (int len = 2; !qs.isEmpty(); len++) {
    //             Set<String> qt = new HashSet<>();
    //             for (String w : qs) {
    //                 //依次从初始集合取出词，找出符合要求的临时转换词
    //                 for (int j = 0; j < w.length(); j++) {
    //                     char[] ch = w.toCharArray();
    //                     //从词的第一个字母开始匹配把符合的词加入到临时集合中
    //                     for (char c = 'a'; c <= 'z'; c++) {
    //                         if (c == w.charAt(j)) continue;
    //                         ch[j] = c;
    //                         String nb = String.valueOf(ch);
    //                         if (qe.contains(nb)) return len; //如果符合目标词则返回
    //                         if (dict.contains(nb)) qt.add(nb); // 如果字典中包含词曾加入到临时集合中
    //                     }
    //                 }
    //             }
    //             qs = (qt.size() < qe.size()) ? qt : qe; //选择临时集合中和目标集合小的作为下一轮匹配的开始集合
    //             qe = (qs == qt) ? qe : qt; //选择下一轮匹配的目标集合
    //         }
    //     }
    //     return 0;
    // }
    
    //2.BFS
    // public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //     //qs 每一轮遍历转换的初始集合  qe 每一轮遍历转换的目标 visite 全局集合去重
    //     Set<String> qs = new HashSet<String>(), qe = new HashSet<String>(), visite = new HashSet<String>();
    //     qs.add(beginWord);
    //     qe.add(endWord);
    //     int len = 1;
    //     while (!qs.isEmpty() && !qe.isEmpty()) {
    //         //每层遍历匹配的开始集合如果初始集合大于目标集合互换，减少遍历次数
    //         if (qs.size() > qe.size()) {
    //             Set<String> set = qs;
    //             qs = qe;
    //             qe = set;
    //         }
    //         Set<String> qt = new HashSet<String>();
    //         for (String word : qs) {
    //             //依次从初始集合取出词，找出符合要求的临时转换词
    //             char[] chs = word.toCharArray();
    //             //从词的第一个字母开始匹配把符合的词加入到临时集合中
    //             for (int i = 0; i < chs.length; i++) {
    //                 for (char c = 'a'; c <= 'z'; c++) {
    //                     char old = chs[i];
    //                     chs[i] = c;
    //                     String target = String.valueOf(chs);
    //                     //如果字典中不包含目标词
    //                     if (!wordList.contains(endWord)) {
    //                         return 0;
    //                     }
    //                     //如果符合目标词则返回
    //                     if (qe.contains(target)) {
    //                         return len + 1;
    //                     }
    //                     // 如果字典中包含词，且全局集合不包含则加入到临时集合中
    //                     if (!visite.contains(target) && wordList.contains(target)) {
    //                         qt.add(target);
    //                         visite.add(target);
    //                     }
    //                     chs[i] = old;
    //                 }
    //             }
    //         }
    //         //初始化下一层遍历的目标集合
    //         qs = qt;
    //         len++;
    //     }
    //     return 0;
    // }
    
    //3.BFS 队列
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                //每层遍历匹配从队列依次取出初始词
                String str = queue.remove();
                //如果符合目标词则返回
                if(str.equals(endWord)) {
                    return level + 1;
                }
                //从词的第一个字母开始匹配把符合的词加入到队列中
                for(int j = 0; j < str.length(); j++) {
                    char[] letters = str.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++) {
                        letters[j] = ch;
                        String transStr = new String(letters);
                        // 如果字典中包含转换词，且和初始词不同，则加入队列
                        if(!transStr.equals(str) && dict.contains(transStr)) {
                            queue.add(transStr);
                            dict.remove(transStr);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}