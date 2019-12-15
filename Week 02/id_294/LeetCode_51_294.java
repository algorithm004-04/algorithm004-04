package week02;

import java.util.*;

/** N Queens */

/** 回溯法
 * 一行只有一个皇后，每层递归处理一行的一个皇后
 * 优化，构建每行字符串的循环可以提前计算好，后面只需查表就好，不用再每次递归时都计算  11ms -> 9ms
 * */
public class LeetCode_51_294 {

    List<String> rowStrings = new ArrayList<>();
    boolean[] usedCols;
    boolean[] usedPie;
    boolean[] usedNa;
    public List<List<String>> nQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0 ; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n;j++) {
                if(j == i)sb.append("Q");
                else sb.append(".");
            }
            rowStrings.add(sb.toString());
        }
        usedCols = new boolean[n];
        usedPie = new boolean[2 * n - 1];
        usedNa = new boolean[2 * n - 1];
//        helper(n, 0, new HashMap<>(), new HashMap<>(), new HashMap<>(), new ArrayList<String>(), result);
        helper2(n, 0, new ArrayList<String>(), result);
        return result;
    }

    public void helper(int n, int row, Map<Integer, Integer> usedCols, Map<Integer, Integer> usedPie, Map<Integer, Integer> usedNa, List<String> record, List<List<String>> result) {
        if (row >= n) {
            result.add(new ArrayList<>(record));
            return;
        }

        // 循环处理当前行皇后的n个位置，看是否可以放
        for (int col = 0; col < n; col++) {
            //检查列是否被占用
            if (usedCols.containsKey(col)) {
                continue;
            }
            //检查撇是否被占用
            if (usedPie.containsKey(col + row)) {
                continue;
            }
            //检查捺是否被占用
            if (usedNa.containsKey(col - row)) {
                continue;
            }
            //添加占用标记
            usedCols.put(col, 1);
            usedPie.put(col + row, 1);
            usedNa.put(col - row, 1);
            //构建当前行的String
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < n; i++) {
//                if (i == col) {
//                    sb.append("Q");
//                } else {
//                    sb.append(".");
//                }
//            }
//            String rowStr = sb.toString();
            String rowStr = rowStrings.get(col);
            record.add(rowStr);
            //递归下一行
            helper(n, row + 1, usedCols, usedPie, usedNa, record, result);
            //reverse_state, 准备尝试下一个位置
            record.remove(rowStr);
            usedCols.remove(col);
            usedPie.remove(col + row);
            usedNa.remove(col - row);
        }
        //当前行递归完成回溯到上一行
    }


    /**
     * 优化2
     * HashMap -> array   9ms -> 3ms
     * 如果使用HashMap，那么查找key需要用contains方法，
     * 需要计算hashCode，相比数组的下标访问，还是要慢
     */

    public void helper2(int n, int row, List<String> record, List<List<String>> result) {
        if (row >= n) {
            result.add(new ArrayList<>(record));
            return;
        }

        // 循环处理当前行皇后的n个位置，看是否可以放
        for (int col = 0; col < n; col++) {
            if (usedCols[col] || usedPie[col + row] || usedNa[col - row + n - 1]) {
                continue;
            }
            //添加占用标记
            usedCols[col] = true;
            usedPie[col + row] = true;
            usedNa[col - row + n - 1] = true;
            String rowStr = rowStrings.get(col);
            record.add(rowStr);
            //递归下一行
            helper2(n, row + 1, record, result);
            //reverse_state, 准备尝试下一个位置
            record.remove(rowStr);
            usedCols[col] = false;
            usedPie[col + row] = false;
            usedNa[col - row + n - 1] = false;
        }
        //当前行递归完成回溯到上一行
    }

    public static void main(String[] args) {
        List<List<String>> result = new LeetCode_51_294().nQueens(4);
        System.out.println(result.size());
    }
}
