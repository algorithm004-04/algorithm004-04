//这里关键的想法是对于任意数字 nnn ，将 nnn 和 n−1n - 1n−1 做与运算，会把最后一个 111 的位变成 000
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        while(n){
            n &= (n-1);
            count++;
        }
        return count;
    }
}
