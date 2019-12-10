/**
 * 
 * @param {number[]} digits 
 * @return {number[]}
 */


// Given a  array with non-negative numbers, representing a number then plus one to this number. Return the number added by one.
var plusOne = function(digits) {
    // for loop from array's length to zero
    for (let i = digits.length - 1; i >= 0; i--) {
        // get the current i of array, allocate the number to variable num
        let num = digits[i] + 1;
        // if num > 9
        if (num > 9) {
            // array[i] equals to 0
            digits[i] = 0;
            // else num <= 9
        } else {
            // array[i] plus 1
            digits[i]++;

            // return the array
            return digits;
        }
    }
    // after the loop, the array will be [0,0,0...]
    // add 1 to the first index of array
    digits.unshift(1);

    // return array
};