/*
 * @lc app=leetcode id=42 lang=golang
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
//方法1:用递减栈记录左边界，左右边界比栈顶大
func trap(height []int) int {
	stack := NewStack()
	water := 0
	for i, h := range height {
		for !stack.Empty() && h > height[stack.Peek()] {
			water += popAndUpdate(stack, height, i)
		}
		stack.Push(i)
	}
	return water
}

func popAndUpdate(s *Stack, heights []int, right int) int {
	curheight := heights[s.Peek()]
	s.Pop()
	if s.Empty() {
		return 0
	}
	distance := right - s.Peek() - 1
	height :=  Min(heights[s.Peek()], heights[right]) - curheight
	return distance * height
}


func Min(x,y int) int{
	if x < y {
		return x
	}
	return y
}
type Stack struct {
	data []int
}

func NewStack(x ...int) *Stack {
	return &Stack{data:x}
}

func (s *Stack) Push(val int) {
	s.data = append(s.data, val)
}

func (s *Stack) Pop() {
	n := len(s.data)
	if n > 0 {
		s.data = s.data[:n-1]
	}
}

func (s *Stack) Peek() int {
	n := len(s.data)
	if n > 0 {
		return s.data[n-1]
	}
	return 0
}

func (s *Stack) Empty() bool {
	return  len(s.data) == 0
}

// @lc code=end

