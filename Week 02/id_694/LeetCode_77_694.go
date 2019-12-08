
var nn, kk int
var output [][]int

func combine(n int, k int) [][]int {
	nn = n
	kk = k
	output = [][]int{}
	backtrack(1, []int{})
	return output
}

func backtrack(first, curr []int) {
	if len(curr) == kk {
		output = append(output, curr)
	}

	for i := first; i < nn + 1; i++ {
		curr = append(curr, i)
		backtrack(i + 1, curr)
		curr = curr[:len(curr)-1]
	}
}
