func climbStairs(n int) int {
	if n == 1 {
		return 1
	}
	if n == 2 {
		return 2
	}
	if _, ok := cache[n]; !ok {
		cache[n] = climbStairs(n-1) + climbStairs(n-2)
	}
	return cache[n]
}

var cache = make(map[int]int)