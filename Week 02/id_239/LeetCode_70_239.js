/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let f1 = 1, f2 = 2, f3 = 3;
    if (n <= 2) return n;
    for (let i= 3; i <= n; i++) {
        f3 = f1 + f2;
        f1 = f2;
        f2 = f3;
    }
    return f3;
};
