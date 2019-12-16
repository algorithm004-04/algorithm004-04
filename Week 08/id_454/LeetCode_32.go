class Solution {

    /**
     * @param String $s
     * @return Integer
     */
	 func longestValidParentheses(s string) int {
		var result int
		stack := []int{-1}
		for i := range s {
			if len(stack) > 1 && s[i] == ')' && s[stack[len(stack)-1]] == '(' {
				stack = stack[:len(stack)-1]
				if i-stack[len(stack)-1] > result {
					result = i - stack[len(stack)-1]
				}
			} else {
				stack = append(stack, i)
			}
		}
	
		return result
	}
}