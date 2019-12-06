//这里关键的想法是对任意数字n,将n和n-1做与运算，会把最后一个1变成0
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
