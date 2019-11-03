class Solution {
    public List<String> generateParenthesis(int n) {
      
        res = new ArrayList<>();
        _generateParenthesis(0,0,n,"");
        return res;
    }

    private void _generateParenthesis(int left, int right, int n, String s) {

        //递归的终止条件
        if(left == n && right == n){

            //System.out.println(s);
            res.add(s);
            return;
        }

        //过滤掉无效的括号
        //左括号随便什么时候添加都行
        //右括号添加的条件是必须要小于左括号
        if(left < n) {
            _generateParenthesis(left + 1, right, n, s + '(');
        }

        if(left > right) {
            _generateParenthesis(left, right + 1, n, s + ')');
        }

    }

    private List<String> res;
}
