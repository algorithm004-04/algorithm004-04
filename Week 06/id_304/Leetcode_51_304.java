public void cal8queens(int row) {
    int n = result.length;

    if (row == n) {
        lists.add(printQueens(result));
        return;
    }
    for (int column = 0; column < n; ++column) {
        if (isOk(row, column)) {
            result[row] = column;
            cal8queens(row + 1);
        }
    }

}

private boolean isOk(int row, int column) {

    int n = result.length;
    int leftup = column - 1, rightup = column + 1;
    for (int i = row - 1; i >= 0; --i) {
        if (result[i] == column) return false;
        if (leftup >= 0) {
            if (result[i] == leftup) return false;
        }
        if (rightup < n) {
            if (result[i] == rightup) return false;
        }
        --leftup;
        ++rightup;
    }
    return true;
}

private List printQueens(int[] result) { // 打印出一个二维矩阵
    List<String> list = new ArrayList<>();
    String s = "";
    for (int row = 0; row < result.length; ++row) {
        for (int column = 0; column < result.length; ++column) {
            if (result[row] == column)
                s += "Q";
            else s += ".";
        }
        list.add(s);
        s = "";
    }

    return list;
}

public List<List<String>> solveNQueens(int n) {
    result = new int[n];
    cal8queens(0);
    return lists;
}
}
