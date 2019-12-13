func numDecodings(s string) int {
	size := len(s)
	if size == 0 {
		return 0
	}
	return helper(s, 0)
}

func helper(s string, i int) int {
	if i == len(s) {
		return 1
	}
	if s[i] == '0' {
		return 0
	}

	one := helper(s, i+1)
	var two int
	if i+1 < len(s) && (s[i]-'0')*10+(s[i+1]-'0') <= 26 {
		two = helper(s, i+2)
	}
	return one + two
}
