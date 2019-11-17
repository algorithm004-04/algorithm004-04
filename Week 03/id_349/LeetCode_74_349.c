// O(log(m) + log(n)) = O(log(m*n))
bool searchMatrix(int** matrix, int matrixSize, int* matrixColSize, int target){
    if (matrixSize == 0 || *matrixColSize == 0) return false;
    int upRow = 0, downRow = matrixSize - 1;
    int leftCol = 0, rightCol = *matrixColSize - 1;
    int midRow, midCol;

    while (upRow <= downRow) {
        midRow = upRow + (downRow - upRow) / 2;
        if (matrix[midRow][rightCol] == target) {
            return true;
        }
        else if (matrix[midRow][rightCol] < target) {
            upRow = midRow + 1;
        }
        else {
            if (target < matrix[midRow][leftCol]) {
                downRow = midRow - 1;
            }
            else { // 目标值就在该行的范围内
                break;
            }
        }
    }

    while (leftCol <= rightCol) {
        midCol = leftCol + (rightCol - leftCol) / 2;
        if (matrix[midRow][midCol] == target) {
            return true;
        }
        else if (matrix[midRow][midCol] < target) {
            leftCol = midCol + 1;
        }
        else {
            rightCol = midCol - 1;
        }
    }
    return false;
}


// @lc code=end

