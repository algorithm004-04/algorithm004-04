func maxProfit(prices []int) int {
	i := 0
	profit := 0
	n := len(prices)

	if n < 2 {
		return profit
	}
	valley := prices[0]
	peak := prices[0]
	for ; i < n-1; i++ {
		for ; i < n-1; i++ {
			if prices[i+1] <= prices[i] {
				continue
			} else {
				break
			}
		}
		valley = prices[i]

		for ; i < n-1; i++ {
			if prices[i+1] >= prices[i] {
				continue
			} else {
				break
			}
		}
		peak = prices[i]
		profit += peak - valley

	}
	return profit
}
