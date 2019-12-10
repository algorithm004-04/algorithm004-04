import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_433_minimum_genetic_mutation {

    //单向BFS
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank)); // 先存入set中不断去remove
        if (!set.contains(end)) { //如果不存在end字符串说明肯定不符合条件
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'}; // 题目说明是从这四个字母进行变化
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        set.remove(start);

        int step = 0;
        while (queue.size() > 0) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] tempStringChars = queue.poll().toCharArray();
                for (int i = 0, len = tempStringChars.length; i < len; ++i) {
                    char oldChar = tempStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        tempStringChars[i] = four[j];
                        String newGenetic = new String(tempStringChars);
                        System.out.println("newGenetic = " + newGenetic);
                        if (end.equals(newGenetic)) {
                            return step;
                        } else if (set.contains(newGenetic)) {
                            set.remove(newGenetic);
                            queue.add(newGenetic);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }


    //双向的，就是用两个set来进行，分成正向进行和负向进行。具体的走过的路径会比较少些
    public int minMutation1(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] four = {'A', 'C', 'G', 'T'};
        HashSet<String> positive = new HashSet<String>() {{
            add(start);
        }};
        HashSet<String> nagative = new HashSet<String>() {{
            add(end);
        }};
        HashSet<String> tempNewSet = new HashSet<>();
        int step = 0;
        while (positive.size() > 0 && nagative.size() > 0) {
            step++;
            //每次判断正向是否比负向的元素更多。我们选择元素更小的那个继续更新
            if (positive.size() > nagative.size()) {
                HashSet<String> temp = new HashSet<>(positive);
                positive = nagative;
                nagative = temp;
            }

            //遍历每个正向的元素
            for (String item : positive) {
                String str;
                char[] tempStringChars = item.toCharArray();
                for (int i = tempStringChars.length - 1; i >= 0; --i) {
                    char oldChar = tempStringChars[i];
                    for (int j = 0; j < 4; ++j) {
                        tempStringChars[i] = four[j];
                        String newString = new String(tempStringChars);
                        if (nagative.contains(newString)) {
                            return step;
                        } else if (set.contains(newString)) {
                            set.remove(newString);
                            tempNewSet.add(newString);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
            positive = new HashSet<>(tempNewSet);
            tempNewSet.clear();
        }
        return -1;

    }


    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = new String[]{"AACCGGTA"};
        new LeetCode_433_minimum_genetic_mutation().minMutation(start, end, bank);
    }

}
