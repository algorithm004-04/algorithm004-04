/*
 * @lc app=leetcode id=130 lang=golang
 *
 * [130] Surrounded Regions
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 * algorithms
 * Medium (23.92%)
 * Likes:    1023
 * Dislikes: 513
 * Total Accepted:    171.9K
 * Total Submissions: 699.2K
 * Testcase Example:  '[["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]'
 *
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 *
 * Example:
 *
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 *
 * After running your function, the board should be:
 *
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 *
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 *
 */

// @lc code=start
/*

X X X X        X X X X         X X X X
X O O X  --->  X O O X   --->  X X X X
X X O X        X X O X         X X X X
X O X X        X 1 X X         X O X X

*/
func solve(board [][]byte) {
	if len(board) == 0 {
		return
	}
	row, col := len(board), len(board[0])
	for i := 0; i < row; i++ {
		check(&board, i, 0)     // first column
		check(&board, i, col-1) // last column
	}
	for j := 1; j < col-1; j++ {
		check(&board, 0, j)     // first row
		check(&board, row-1, j) // last row
	}
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if board[i][j] == 'O' {
				board[i][j] = 'X'
			} else if board[i][j] == '1' {
				board[i][j] = 'O'
			}
		}
	}
}

func check(board *[][]byte, i, j int) {
	if (*board)[i][j] == 'O' { // turn 0 into 1 if on the border
		(*board)[i][j] = '1'
		if i-1 > 0 {
			check(board, i-1, j)
		}
		if j-1 > 0 {
			check(board, i, j-1)
		}
		if i+1 < len(*board) {
			check(board, i+1, j)
		}
		if j+1 < len((*board)[0]) {
			check(board, i, j+1)
		}
	}
}

// @lc code=end

