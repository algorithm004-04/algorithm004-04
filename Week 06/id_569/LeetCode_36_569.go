package main
//不太会 抄一遍lc的代码

func isValidSudoku(board [][]byte) bool {
	// 行列检测
	for i:=0;i<9;i++ {
		mp1 := map[byte]bool{}
		mp2 := map[byte]bool{}
		mp3 := map[byte]bool{}
		for j:=0;j<9;j++ {
			// row
			if board[i][j] != '.' {
				if mp1[board[i][j]] {
					return false
				}
				mp1[board[i][j]] = true
			}
			// column
			if board[j][i] != '.' {
				if mp2[board[j][i]] {
					return false
				}
				mp2[board[j][i]] = true
			}
			// part
			row := (i%3)*3 + j%3
			col := (i/3)*3 + j/3
			if board[row][col] != '.' {
				if mp3[board[row][col]] {
					return false
				}
				mp3[board[row][col]] = true
			}

		}
	}
	return true
}

