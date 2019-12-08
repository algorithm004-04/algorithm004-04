/*
 * @lc app=leetcode.cn id=191 lang=cpp
 *
 * [191] 位1的个数
 */

// @lc code=start
#include <iostream>
#include <bitset>

using namespace std;

/*
class Solution {
public:
    int hammingWeight(uint32_t n) {
        return bitset<32>(n).count();
    }
};
*/

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        
        while (n) {
            n &= (n - 1);
            count++;
        }
        
        return count;        
    }
};

// @lc code=end

