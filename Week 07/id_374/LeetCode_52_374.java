package algorithm.homework.week07;

public class LeetCode_52_374 {
    public static void main(String[] args) {

    }

    private int count;

    /**
     * 位运算
     *
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        count = 0;
        recur(0, 0, 0, 0, n);
        return count;
    }

    private void recur(int row, int col, int pie, int na, int n) {
        if (row == n) {
            count++;
            return;
        }
        int pos = (~(col | pie | na)) & ((1 << n) - 1);
        while (pos != 0) {
            int p = pos & -pos;
            pos &= pos - 1;
            recur(row + 1, col | p, (pie | p) << 1, (p | na) >> 1, n);
        }
    }
}
