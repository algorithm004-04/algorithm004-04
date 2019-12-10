package week_02.lesson8;

import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        //记录Q的下标位置数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        Set<Integer> col = new HashSet<>();
        Set<Integer> master = new HashSet<>();
        Set<Integer> slave = new HashSet<>();
        //画棋盘用的栈
        Stack<Integer> stack = new Stack<>();
        backTrack(nums, 0, n, col, master, slave, stack, result);
        return result;

    }

    private static void backTrack(int[] nums, int row, int n, Set<Integer> col,
                           Set<Integer> master, Set<Integer> slave, Stack<Integer> stack,
                           List<List<String>> result) {

        //如果已经到了最后一列，把结果返回到result里面
        if (row == n) {
            List<String> board = convert2board(stack, n);
            result.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!col.contains(i) && !master.contains(row - i) && !slave.contains(row + i)) {
                stack.add(nums[i]);
                col.add(i);
                master.add(row - i);
                slave.add(row + i);

                backTrack(nums, row + 1, n, col, master, slave, stack, result);

                stack.pop();
                col.remove(i);
                master.remove(row - i);
                slave.remove(row + i);
            }

        }


    }

    private static List<String> convert2board(Stack<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (int num :
                stack) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (num == i) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            //sb.replace(num,num + 1, "Q");
            board.add(sb.toString());
        }
        return board;
    }


    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
