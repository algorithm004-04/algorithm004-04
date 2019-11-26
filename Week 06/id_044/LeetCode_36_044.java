package week_06.lesson14;

import java.util.HashMap;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int count = 9;
        //初始化行、列、子数独
        HashMap<Integer, Integer>[] rows = new HashMap[count];
        HashMap<Integer, Integer>[] columns = new HashMap[count];
        HashMap<Integer, Integer>[] boxes = new HashMap[count];

        for (int i = 0; i < count; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3) * 3 + j / 3;
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

}
