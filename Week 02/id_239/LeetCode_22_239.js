/**
 * @param {number} n
 * @return {string[]}
 */

var generateParenthesis = function(n) {
    let result = [];
    generate(0, 0, n, '', result);
    return result;
};


function generate (left, right, n, s, result) {
    if (left === n && right === n) {
        result.push(s);
        return;
    }
    if (left < n) arguments.callee(left + 1, right, n, s + '(', result);
    if (left > right) arguments.callee(left, right + 1, n, s + ')', result);
}
