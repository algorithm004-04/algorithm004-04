/**
 * @param {number[]} height
 * @return {number}
 */
var trap = function(height) {
  let stack = [];
  let trap = 0;
  for (let i = 0; i < height.length; i++) {
      if (stack.length === 0 || height[i] < height[stack[0]]) {
          if (height[i] < height[i-1]) {
              stack.push(i);
          } else {
              while (height[i] >= height[stack[stack.length-1]]) {
                  let stackOldTop = stack.pop();
                  let stackNewTop = stack[stack.length-1];
                  if (height[i] < height[stackNewTop]) {
                      trap = trap + (height[i] - height[stackOldTop]) * (i - stackNewTop -1);
                  } else {
                      trap = trap + (height[stackNewTop] - height[stackOldTop]) * (i - stackNewTop -1);
                  };
              };
              stack.push(i);
          };
      } else {
          while (stack.length !== 0) {
              let stackTop1 = stack.pop();
              let stackTop2 = stack[stack.length-1];
              if (stack.length ===0) break;
              trap = trap + (height[stackTop2] - height[stackTop1]) * (i - stackTop2 -1);
          };
          stack.push(i);
      };
  };
  return trap;
}