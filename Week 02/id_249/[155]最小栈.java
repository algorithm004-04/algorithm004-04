//设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) -- 将元素 x 推入栈中。 
// pop() -- 删除栈顶的元素。 
// top() -- 获取栈顶元素。 
// getMin() -- 检索栈中的最小元素。 
// 
//
// 示例: 
//
// MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
// Related Topics 栈 设计

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 整体思维为构建一个辅助栈，空间换时间
 * 时间复杂度O(1),空间复杂度O(n)
 */
class MinStack {
    //anxuliary为同步辅助栈
    private Stack<Integer> stack;
    private Stack<Integer> anxuliary;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        anxuliary = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        //如果辅助栈为空，且入栈的元素小于栈顶元素，则入辅助站
        //辅助栈为空时直接将x add,不为空时要取到栈顶元素比较
        if (anxuliary.isEmpty() || anxuliary.peek() >= x) {
            //此处push和add均可,两方法效果相同，返回值不同，add返回boolean,push返回item
            //stack本身没有add方法，但其继承的父类vector和vector实现的接口List有
            anxuliary.add(x);
        } else {
            //若不满足上述条件，则是将栈顶元素取到，再次入栈
            //（保证辅助站与原栈元素个数相同，且栈顶元素一直是最小元素）
            anxuliary.push(anxuliary.peek());
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("pop failed, stack is empty.");
        }else {
            stack.pop();
            anxuliary.pop();
        }
        
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            throw new RuntimeException("get top failed, stack is empty.");
        }
    }
    
    public int getMin() {
        if (!anxuliary.isEmpty()) {
            return anxuliary.peek();
        } else {
            throw new RuntimeException("get Minimum failed, stack is empty.");
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
