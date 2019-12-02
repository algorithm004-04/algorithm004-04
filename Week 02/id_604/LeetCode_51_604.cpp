#include <iostream>
#include <vector>
#include <stack>
#include <assert.h>
using namespace std;

//LeetCode 51. N-Queens
/*N皇后问题
 *典型的递归回溯求解的题目
 */

//怎么能够快速的判断不合法的情况
//竖向：col[i]表示第i列被占用

class Solution {
private:
    vector<vector<string>> res;
    vector<bool> col,dia1,dia2;
    //尝试在一个n皇后问题中，摆放第index行的皇后位置
    void putQueen(int n, int index, vector<int> &row){

        if( index == n ){
            res.push_back(generateBoard(n,row));
            return;
        }

        for( int i = 0 ; i < n ; i++ ){
            //尝试将第index行的皇后摆放在第i列
            if( !col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                row.push_back(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n,index+1,row);
                //进行回溯的过程，清理现场
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
                row.pop_back();
            }
        }

        return;
    }

    vector<string> generateBoard(int n, vector<int>&row){
        assert(row.size() == n);
        vector<string> board(n,string(n,'.'));
        for(int i = 0; i < n; i++){
            board[i][row[i]] = 'Q';
        }
        return board;
    }
public:
    vector<vector<string>> solveNQueens(int n) {

        res.clear();
        col = vector<bool>(n, false);
        dia1 = vector<bool>(2*n-1,false);
        dia2 = vector<bool>(2*n-1,false);

        vector<int> row;
        putQueen(n,0,row);

        return res;


    }
};

int main(void)
{
    int n = 4;
    vector<vector<string>> res = Solution().solveNQueens(n);
    for(int i = 0 ; i < res.size(); i++){
        for(int j = 0; j < n;j++){
            cout << res[i][j] << endl;
        }
        cout<<endl;
    }
    return 0;
}


