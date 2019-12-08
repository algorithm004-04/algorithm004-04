func maxCoins(nums []int) int {
    
    record := append([]int{1}, nums...)
    record = append(record, 1)
    
    fmt.Println(record)
    mem := make([][]int, len(record))
    for i := range(mem){
        mem[i] = make([]int, len(record))
    }
    
    lens := len(record)
	for stretch := 2; stretch < lens; stretch++ {
		for left := 0; left + stretch < lens; left++ {
			max := 0
			right := left + stretch
			for i := left + 1; i < right; i++ {
				temp := record[left] * record[i] * record[right] + mem[left][i] + mem[i][right]
				if temp > max {
					max = temp
					mem[left][right] = temp
				}
			}
		} 
	}
    return mem[0][lens-1]
}