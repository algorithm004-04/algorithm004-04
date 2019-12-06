package main

//不太会 抄一遍
func leastInterval(tasks []byte, n int) int {
	charSlice := [26]int{}
	max := 0
	count := 0
	for i := 0; i < len(tasks); i++ {
		charSlice[tasks[i]-'A']++
		if max < charSlice[tasks[i]-'A'] {
			max = charSlice[tasks[i]-'A']
			count = 1
		} else if charSlice[tasks[i]-'A'] == max {
			count++
		}
	}
	if n == 0 || (max-1)*(n+1)+count < len(tasks) {
		return len(tasks)
	}
	return (max-1)*(n+1) + count
}
