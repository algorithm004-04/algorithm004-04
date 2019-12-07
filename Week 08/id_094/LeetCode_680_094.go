/*
 * @lc app=leetcode id=680 lang=golang
 *
 * [680] Valid Palindrome II
 */

// @lc code=start
func validPalindrome(s string) bool {
    
    left, right := 0, len(s)-1
    for left < right{
        if s[left] == s[right]{
            left++
            right--
        } else{
            return isPal(s,left+1, right) || isPal(s,left, right-1)
        }
    }
    return true
}

func isPal(s string, left, right int)bool{
    for left < right{
        if s[left] == s[right]{
            left++
            right--
        } else{
            return false
        }
    }
    return true
}
// @lc code=end

