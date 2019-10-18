// 方法： 算数法，进位+1
var plusOne = function(digits) {
    for (let i = digits.length - 1; i >= 0; i--) {
        let num = digits[i] + 1;
        if (num > 9) {
            digits[i] = 0;
        } else {
            digits[i]++;
            return digits;
        }
    }
    digits.unshift(1);
    return digits;
};