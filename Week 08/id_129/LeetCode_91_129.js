var numDecodings = function (s) {
  if (s.length > 0 && s[0] === "0") return 0;
  if (s.length < 2) return 1;
  if (s[0] === "1" || (s[0] === "2" && parseInt(s[1]) < 7)) {
    return numDecodings(s.slice(1)) + numDecodings(s.slice(2));
  }
  return numDecodings(s.slice(1));
};

var numDecodings = function (s) {
  let previous = (s.endsWith('0')) ? 0 : 1, result = 1;
  if (s.startsWith('0') || s.indexOf('00') !== -1) return 0;
  for (const [index, value] of s.split('').entries()) {
    if (index) {
      const num = parseInt(`${s[index - 1]}${value}`);
      const canPermutate = (num >= 10 && num <= 26 && num % 10 !== 0);
      if (num % 10 === 0 && num > 26) return 0;
      result = (canPermutate) ? result + previous : result;
      previous = (canPermutate) ? result - previous : result;
    }
  }
  return result;
};