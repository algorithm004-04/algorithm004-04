/*
 * @lc app=leetcode id=49 lang=golang
 *
 * [49] Group Anagrams
 */

// @lc code=start
//方法1 计数 O(N*k)
// loop s int strs
// 	gram = [26]int
//    	loop char in s
// 			gram[char] ++
//	map[gram] += s
//  map2slice
func groupAnagrams(strs []string) [][]string {
	groups := map[[26]int][]string{} //array作为key
	for _, s := range strs {
		key := [26]int{}
		for _, c := range []byte(s) {
			key[c-'a'] += 1
		}
		groups[key] = append(groups[key], s)
	}

	ret := make([][]string, 0, len(groups))
	for _, v := range groups {
		ret = append(ret, v)
	}
	return ret
}
//方法2 排序 O(N*klogk)
func groupAnagrams(strs []string) [][]string {
	groups := map[string][]string{}
	for _, s := range strs {
		b := []byte(s)
		sort.Slice(b, func(i, j int) bool {
			return b[i] < b[j]
		})
		key := string(b)
		groups[key] = append(groups[key], s)
	}

	ret := make([][]string, 0, len(groups))
	for _, v := range groups {
		ret = append(ret, v)
	}
	return ret
}
// @lc code=end

