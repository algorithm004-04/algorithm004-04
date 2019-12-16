func racecar(target int) int {
    dp := make([]int, 10001)
    return racecarHelper(&dp, target)
}

func racecarHelper(dp *[]int, target int) int {
    if (*dp)[target] > 0 {
        return (*dp)[target]
    }
    n := int(math.Log2(float64(target))) + 1
    if 1<<uint(n) == target+1 {
        (*dp)[target] = n
    } else {
        (*dp)[target] = racecarHelper(dp, (1<<uint(n))-1-target) + n + 1
        for m := 0; m < n-1; m++ {
            (*dp)[target] = min((*dp)[target],
                racecarHelper(dp, target-(1<<uint(n-1))+(1<<uint(m)))+n+m+1)
        }
    }
    return (*dp)[target]
}

func min(x, y int) int {
    if x > y {
        return y
    }
    return x
}