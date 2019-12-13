/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        let p = digits[i] + 1
        if (p > 9) {
            digits[i] = 0;
        } else {
            digits[i] = p;
            return digits;
        }
    }
    digits.unshift(1) 
    return digits;
};
