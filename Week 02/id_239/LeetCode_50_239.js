/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    if (n < 0) {
        x = 1 / x;
        n = -n;
    }
    return recurison(x, n);
};

function recurison (x, n) {
    if (n === 0) {
        return 1.0;
    }
    let half = recurison(x, parseInt(n / 2));
    return (n % 2) === 0 ? half * half : half * half * x;
}
