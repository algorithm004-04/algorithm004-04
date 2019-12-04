//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.HashMap;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Character, Character> bracketMap;

    public Solution(){
        this.bracketMap = new HashMap<Character, Character>();
        this.bracketMap.put(')', '(');
        this.bracketMap.put(']', '[');
        this.bracketMap.put('}', '{');
    }

    public boolean isValid2(String s) {
        //初始化用于操作的栈
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            //取到s的每个字符赋值给c
            char c = s.charAt(i);

            if (this.bracketMap.containsKey(c)) {
                //取到栈顶元素,取之前判断栈是否为空
                char top = stack.isEmpty() ? '#' : stack.pop();
                //判断括号是否匹配
                if (top != this.bracketMap.get(c)) {
                    return false;
                }
            } else {
                //将左括号入栈
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    //International version top1 solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                //栈为空，或者当前取出的不配对
                return false;
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
