/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    let result = {};
    strs.forEach((item, index) => {
        if (result[item]) {

        } else {
            result[item] = [item];
        }
    });
};

function isAnagram(s, t) {
    if (s.length !==  t.length) return false;
    let dict = {};
    for (let i = 0; i < s.length; i++) {
        if (dict[s[i]] === undefined) {
            dict[s[i]] = 1;
        } else {
            dict[s[i]]++;
        };
    }
    for (let j = 0; j < t.length; j++) {
        if (dict[t[j]] === undefined) {
            return false;
        } else if (dict[t[j]] === 0){
            return false;
        } else {
            dict[t[j]]--;
        }
    }
    let sum = Object.values(dict).reduce((total, a) => {
        return total + a;
    }, 0);
    return sum === 0 ? true : false;
};
