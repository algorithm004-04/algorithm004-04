/**
 * 变量j每次只指向非0的位置，如果不是自身（i==j）,那么i位置的非零赋值到j位置之后，将i位置改为0
 */
var moveZeroes = function (nums) {
  let j = 0
  for (let i = 0, l = nums.length; i < l; i++) {
    if (nums[i] !== 0) {
      nums[j] = nums[i]
      if (i !== j) nums[i] = 0
      j++
    }
  }
}

/**
 * 取出所有非0的值，然后补0，需要一个零时变量存储非零个数
 */
var moveZeroes = function (nums) {
  let notZero = 0
  let l = nums.length
  for (let i = 0; i < l; i++) {
    if (nums[i] !== 0)
      nums[notZero++] = nums[i]
  }
  while (notZero < l) {
    nums[notZero++] = 0
  }
}
