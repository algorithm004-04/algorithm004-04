/**
 * @param {character[][]} board
 * @return {boolean}
 * 行中没有重复的数字。
 * 列中没有重复的数字。
 * 3 x 3 子数独内没有重复的数字。
 */
var isValidSudoku = function (board) {
    // 三个方向判重
    let rows = {};
    let columns = {};
    let boxes = {};
    for (let i = 0; i < 9; i++) {
        for (let j = 0; j < 9; j++) {
            let num = board[i][j];
            if (num != '.') {
                let boxIndex = parseInt((i / 3)) * 3 + parseInt(j / 3);
                if (rows[i + '-' + num] || columns[j + '-' + num] || boxes[boxIndex + '-' + num]) {
                    return false;
                }
                // 以各自方向 + 不能出现重复的数字组成唯一键值，若出现第二次，即为重复
                rows[i + '-' + num] = true;
                columns[j + '-' + num] = true;
                boxes[boxIndex + '-' + num] = true;
            }
        }
    }
    return true;
};

//set存数
var isValidSudoku = function (board) {
    for (let i = 0; i < 9; i++) {
        let row = new Set(), col = new Set(), sqr = new Set();
        for (let j = 0; j < 9; j++) {
            let rowc = board[i][j];
            let colc = board[j][i];
            let sqrc = board[Math.floor(i / 3) * 3 + Math.floor(j / 3)][(i % 3) * 3 + j % 3];
            if (row.has(rowc) || col.has(colc) || sqr.has(sqrc)) return false;
            if (rowc !== ".") row.add(rowc);
            if (colc !== ".") col.add(colc);
            if (sqrc !== ".") sqr.add(sqrc);
        }
    }
    return true;
};