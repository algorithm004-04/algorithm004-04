/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
// 方法一
var merge = function(nums1, m, nums2, n) {
    nums1.splice.apply(nums1,  [m, n].concat(nums2));
    nums1.sort(function (a, b) { return a - b;});   
};

// 方法二

var merge2 = function(nums1, m, nums2, n) {
    var len = m + n - 1;
    var len1 = m - 1;
    var len2 = n - 1;
    while (len1 >= 0 && len2 >= 0) {
        nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
    } 
    nums1.splice.apply(nums1, [0, len2 + 1].concat(nums2.slice(0, len2 + 1)));
};
