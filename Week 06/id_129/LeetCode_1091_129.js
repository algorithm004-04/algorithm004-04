/**二进制矩阵中的最短路径 https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 * 这实际上是一个在二维数组中寻找源和距离之间最短路径的问题。
 * 我们需要从八个方向来研究这个问题，而不是从四个方向来研究。
 * C_i和C_i + 1是不同的，它们共享一条边或一个角
 * 我们需要继续追踪那些被访问过的单元格。
 * 通常我们可以创建一个相同大小的二维数组来标记已访问的单元格，
 * 但是在这个问题中，它没有提到我们不能修改原来的二维数组数组，
 * 所以我们可以将0变为1来标记已访问的单元格。
 * 参考国际站：https://leetcode.com/problems/shortest-path-in-binary-matrix/discuss/313252/JavaScript-Solution-(BFS)
 * @param {number[][]} grid
 * @return {number}
 */
var shortestPathBinaryMatrix = function (grid) {
    if (grid[0][0]) return -1;

    const queue = [{ coord: [0, 0], dist: 1 }];
    const directs = [[-1, -1], [-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1]];
    const N = grid.length;
    const isValidCoord = (x, y) => x >= 0 && x < N && y >= 0 && y < N;

    grid[0][0] = 1;

    while (queue.length) {
        const { coord: [x, y], dist } = queue.shift();

        if (x === N - 1 && y === N - 1) {
            return dist;
        }

        for (let [moveX, moveY] of directs) {
            const nextX = x + moveX;
            const nextY = y + moveY;

            if (isValidCoord(nextX, nextY) && grid[nextX][nextY] === 0) {
                queue.push({ coord: [nextX, nextY], dist: dist + 1 });
                grid[nextX][nextY] = 1;
            }
        }
    }

    return -1;
};