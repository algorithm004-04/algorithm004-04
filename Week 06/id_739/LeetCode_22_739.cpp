class Solution{
	public:
		vector<string> generateParenthesis(int n){
			vector<string> res;
			dfs("",n,n,res);
			return res;
		}
		void dfs(string s, int open, int close, vector<string>& res){
			if(open == 0 && close == 0) res.push_back(s);
			if(open > 0) dfs(s + '(', open - 1, close,res);
			if(open < close) dfs(s + ')', open, close - 1, res);
		}
};
