/**
 * @param {number[]} bills
 * @return {boolean}
 * 暴力法：
 * 1.当客户支付是10美元，需找零5美元，若没有则false
 * 2.当客户支付20美元时，要么找零3个5美元，要么找零10美元+5美元，不满足时false
 * 
 */
var lemonadeChange = function (bills) {
    let fiveSum = 0
    let tenSum = 0
    let twSum = 0
    for (let index = 0; index < bills.length; index++) {
        const el = bills[index];
        if (el === 5) {
            fiveSum += 5
        } else if (el === 10) {
            tenSum += 10
            if (fiveSum / 5 > 0) {
                fiveSum -= 5
            } else {
                return false
            }
        } else if (el === 20) {
            twSum += 20
            if (tenSum / 10 > 0 && fiveSum / 5 > 0) {
                tenSum -= 10
                fiveSum -= 5
            } else if (fiveSum / 5 >= 3) {
                fiveSum -= 15
            } else {
                return false
            }
        }
    }
    return true
};
//代码优化，不计算总和，只记录个数，比如3个5元，2个十元，只计算剩余的个数够不够找零就行了，20元的个数没用
var lemonadeChange = function (bills) {
    let fiveSum = 0
    let tenSum = 0
    for (let index = 0; index < bills.length; index++) {
        const el = bills[index];
        if (el === 5) {
            fiveSum++
        } else if (el === 10) {
            if (fiveSum === 0) {
                return false
            }
            tenSum++
            fiveSum--
        } else if (el === 20) {
            if (tenSum > 0 && fiveSum > 0) {
                tenSum--
                fiveSum--
            } else if (fiveSum >= 3) {
                fiveSum -= 3
            } else {
                return false
            }
        }
    }
    return true
};