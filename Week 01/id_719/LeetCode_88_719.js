//  方法1： 用额外的数组存储输出

var merge = function(nums1, m, nums2, n) {
    let result = [];
    let i = 0,
        j = 0;
    while (i < m && j < n) {
        if (nums1[i] < nums2[j]) {
            result.push(nums1[i]);
            i++;
        } else {
            result.push(nums2[j]);
            j++;
        }
    }

    if (i < m) {
        result = [...result, ...nums1.slice(i)];
    } else if (j < n) {
        result = [...result, ...nums2.slice(j)];
    }
    return result;
};

// 方法2： 双指针

var merge = function(nums1, m, nums2, n) {
    var x = 0,
        y = 0;
    
    while(y < n){
        if(nums2[y] < nums1[x] || nums1[x] === undefined){
            nums1.splice(x, 0, nums2[y]);
            x++;
            y++;    
        } else {
            x++;
        }
    }
};