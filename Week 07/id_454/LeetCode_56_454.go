func merge(intervals []Interval) []Interval {
    if len(intervals) == 0 {
        return []Interval{}
    }
    
    sort.Slice(intervals, func(i, j int) bool {return intervals[i].Start < intervals[j].Start})
    ret := []Interval{intervals[0]}
    for i := 1; i < len(intervals); i++ {
        tail := ret[len(ret)-1]
        if tail.End < intervals[i].Start {
            ret = append(ret, intervals[i])
        } else if intervals[i].End > tail.End {
            ret[len(ret)-1].End = intervals[i].End
        }
    }
    return ret
}