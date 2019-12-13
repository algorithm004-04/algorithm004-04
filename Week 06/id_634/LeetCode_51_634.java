class Solution {
    //DFS递归实现
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n <= 0) {
            return res;
        }
        int [] columnVal = new int[n];
        //处理遍历到的TreeNode节点
        DFSWithRecursion(n, res, 0, columnVal);
        return res;
    }
    
    public void DFSWithRecursion(int nQueens, List<List<String>> res, int row, int[] columnVal){
        if(row == nQueens) {
            List<String> unit = new ArrayList<String>();
            for(int i = 0; i < nQueens; i++) {
                StringBuilder s = new StringBuilder();
                for(int j = 0; j < nQueens; j++) {
                    if(j == columnVal[i]) {
                        s.append("Q");
                    } else {
                        s.append(".");
                    }
                }
                unit.add(s.toString());
            }
            res.add(unit);
        } else {
            for(int i = 0; i < nQueens; i++) {
                columnVal[row] = i;
                if(isValid(row,columnVal)) {
                    DFSWithRecursion(nQueens, res, row+1, columnVal);
                }
            }
        }
    }
    
    public boolean isValid(int row, int [] columnVal) {
        for(int i = 0; i < row; i++) {
            if(columnVal[row] == columnVal[i]
               || Math.abs(columnVal[row] - columnVal[i]) == row-i) {
                return false;
            }
        }
        return true;
    }
}