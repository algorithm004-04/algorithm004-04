class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> res;
        dfs("", n, n, res);
        return res;
    }
    void dfs(string s, int opens, int closes, vector<string>& res){
        if( !opens && !closes) res.push_back(s);
        if(opens > 0) dfs(s + '(', opens - 1, closes, res);
        if(opens < closes) dfs(s + ')', opens, closes - 1, res);
    }
};
