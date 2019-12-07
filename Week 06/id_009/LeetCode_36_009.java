import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class LeetCode_36_009 {
    public boolean isValidSudoku(char[][] board) {
        int size = 9;
        HashMap<Integer, Integer>[] rows = new HashMap[size];
        HashMap<Integer, Integer>[] columns = new HashMap[size];
        HashMap<Integer, Integer>[] boxes = new HashMap[size];
        for (int i = 0; i < size; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int) num;
                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }
        return true;
    }
}