/*
  方法1
  暴力计算
*/
bool isPowerOfTwo(int n){
     if (n == 1) {
         return true;
     }
    
     long int sum = 1;
     while (1) {
         sum = sum * 2;
         if (sum == n) {
             return true;
         }else if (sum > n) {
             return false;
         }
     }
     return false;
}


/*
   方法2
   2的幂次方的数字的二进制有且只有一个1，其余均是0
*/
bool isPowerOfTwo(int n){
    return n > 0 && (n & (n - 1)) == 0;
}


