// 方法一
var isValidOne = function(s) {
  while (s.length > 0) {
    let temp = s;
    // 依次删除字符串中的 () {} []
    s = s.replace('()', '');
    s = s.replace('{}', '');
    s = s.replace('[]', '');
    console.log(s, temp);
    if (temp === s) return false;
  }
  return true;
};

// 方法二
// 遍历字符串 将 { [ ( 三个字符串依次 push 进数组 result 中
// 如果遇到 } ] ) 的时候就跟 result 的最后一个元素进行拼接 判断是否是成对的 {} [] ()
// 如果是的话就将 result 数组的最后一个元素剔除
// 如果不是的话表示这个是一个非有效的字符串
var isValidTwo = function(s) {
  let result = [];
  let flag = true;
  for (let i = 0; i < s.length; i++) {
      if (s[i] === '{' || s[i] === '(' || s[i] === '[') {
          result.push(s[i]);
      } else {
          let l = result.length;
          if (result[l-1] + s[i] === '{}' ||
              result[l-1] + s[i] === '()' ||
              result[l-1] + s[i] === '[]')  {
              result.splice(l-1, 1);
          } else {
            flag = false;
          }
      }
  }
  if (result.length > 0 || !flag) {
    return false;
  } else {
    return true
  }
};