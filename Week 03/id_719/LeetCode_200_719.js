var numIslands = function(grid) {
    function sink(a, b) {
        // terminator
        if (grid[a][b] === "0") return 0;

        // process
        grid[a][b] = "0";

        // drill down
        // top a-1 b
        if (a > 0 && grid[a - 1][b] === "1") sink(a - 1, b);

        // left a b-1
        if (b > 0 && grid[a][b - 1] === "1") sink(a, b - 1);

        // right a b+1
        if (b < grid[a].length - 1 && grid[a][b + 1] === "1") sink(a, b + 1);

        // down a+1 b
        if (a < grid.length - 1 && grid[a + 1][b] === "1") sink(a + 1, b);

        return 1;
    }

    let result = 0;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] === "1") {
                result += sink(i, j);
            }
        }
    }

    return result;
};


// 利用向量
var numIslands = function(grid) {
    function sink(a, b) {
        // terminator
        if (grid[a][b] === "0") return 0;

        // process
        grid[a][b] = "0";

        // drill down
        drillDown(a, b, grid, sink);
        return 1;
    }

    let result = 0;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[i].length; j++) {
            if (grid[i][j] === "1") {
                result += sink(i, j);
            }
        }
    }

    return result;
};

function drillDown(a, b, grid, sink) {
    d = [
        [-1, 0], // top - 1
        [1, 0], // down + 1
        [0, -1], // left - 1
        [0, 1] // right + 1
    ];

    for (let direction of d) {
        let x = b + direction[1]; // x 轴变化
        let y = a + direction[0]; // y 轴变化
        if (
            x >= 0 &&
            y >= 0 &&
            x < grid[a].length &&
            y < grid.length &&
            grid[y][x] === "1"
        ) {
            sink(y, x);
        }
    }
}