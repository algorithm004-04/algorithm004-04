package id_664

var ans []string

func dfs(n int, cur string, stack []byte) {
	if len(cur)>=n*2 {
		if len(stack)==0 {
			ans = append(ans, cur)
		}
		return
	}
	// 入栈
	if len(stack) <= n && len(cur) <=n*2 {
		dfs(n, cur+"(", append(stack, '('))
	}
	// 出栈
	if len(stack) > 0 {
		dfs(n, cur+")", stack[:len(stack)-1])
	}
}

func generateParenthesis(n int) []string {
	ans = []string{}
	dfs(n, "", []byte{})
	return ans
}