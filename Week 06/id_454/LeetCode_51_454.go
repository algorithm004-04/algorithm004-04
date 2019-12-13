func solveNQueens(n int) [][]string {
	// init
	board := BoardConstructor(n)
	// result
	result := [][]string{}

	var backtracking func(b *Board, col, n int)
	backtracking = func(b *Board, col, n int) {
		if col == n {
			result = append(result, b.Clone())
			return
		}
		
		for i := 0; i < n; i++ {
			if b.IsSafe(i, col) {
				b.Place(i, col)
				backtracking(b, col+1, n)
				b.Remove(i, col)
			}
		}
	}

	backtracking(&board, 0, n)
	return result
}


type Board struct {
	M []string
	N int
}

func BoardConstructor(n int) Board {
	m := []string{}
	for i := 0; i < n; i++ {
		temp := ""
		for j := 0; j < n; j++ {
			temp += "."
		}
		m = append(m, temp)
	}
	return Board{m, n}
}

func (b *Board) Place(row, col int) {
	
	b.M[row] = b.M[row][:col] + "Q" + b.M[row][col+1:]
}

func (b *Board) Remove(row, col int) {
	b.M[row] = b.M[row][:col] + "." + b.M[row][col+1:]
}

func (b *Board) IsSafe(row, col int) bool {
	for i := 0; i < b.N; i++ {
		if b.M[i][col] == 'Q' {
			return false
		}
		if b.M[row][i] == 'Q' {
			return false
		}
	}
	for i := 0; i < b.N; i++ {
		for j := 0; j < b.N; j++ {
			if i+j == row+col || i-j == row-col {
				if i != row && j != col && b.M[i][j] == 'Q' {
					return false
				}
			}
		}
	}
	return true
}

func (b *Board) Clone() []string {
	m := []string{}
	for i := 0; i < b.N; i++ {
		m = append(m, b.M[i])
	}
	return m
}