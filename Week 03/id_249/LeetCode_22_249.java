//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateHelper(0, 0 , n, "", list);
        return list;
    }

    public void generateHelper(int left, int right, int n, String s,List<String> list) {
        //terminator
        if (left == n && right ==n) {
            list.add(s);
            return;
        }
        if (left < n) generateHelper(left+1, right, n, s+"(", list);
        if (left > right) generateHelper(left, right + 1, n, s + ")", list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
