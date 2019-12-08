class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int row[9][9] = {0}, rol[9][9] = {0}, Matrix[9][9] = {0};
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                     int num = board[i][j] - '0' - 1;
                row[i][num]++;
                if(row[i][num] == 2) return false;
                rol[j][num]++;
                if(rol[j][num] == 2) return false;
                Matrix[3*(i/3)+(j/3)][num]++;
                if(Matrix[3*(i/3)+(j/3)][num] == 2) return false;
                }
            }
        }
        return true;
    }
};
