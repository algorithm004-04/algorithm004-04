class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        if(m == 0) return false;
        int n = matrix[0].size();
        
        int left = 0, right = m * n - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);

            if(matrix[mid / n][mid % n] == target) return true;
            else if(matrix[mid / n][mid % n] < target)  left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
};
