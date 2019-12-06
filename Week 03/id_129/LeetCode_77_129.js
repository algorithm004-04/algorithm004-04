/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 * 回溯法
 */
var combine = function (n, k) {
    const res = []
    function recall(start, cur) {
        if (cur.length === k) return res.push(cur.slice())
        for (let i = start; i <= n; i++) {
            cur.push(i)
            recall(i + 1, cur)
            cur.pop()
        }
    }
    recall(1, [])
    return res
};