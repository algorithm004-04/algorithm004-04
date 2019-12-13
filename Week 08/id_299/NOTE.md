# NOTE

## 字符串
java、python 是不可变的值，不可变是线程安全

## 字符串算法

### 朴素算法
朴素算法的英文命名为BruteForce，暴力的意思，就是不考虑空间时间复杂度，以最简单的看待问题的视角去思考，去解决,比如：  
> 字符串 M="abcdefabcdx" ，T="abcdx"，找到T串在M串中的位置

```
abcdefabcdx
abcdx
// e!=x 下一轮比较

abcdefabcdx
 abcdx 
// b!=a 下一轮比较

...
abcdefabcdx
      abcdx 
// 找到匹配的位置
```

### Rabin-Karp
1. 假设子串的长度为M(pat), 目标字符串的长度为N(txt)
2. 计算子串的hash值 hash_pat
3. 计算目标字符串txt每个长度为M的子串的hash值（共需要计算N-M+1次）
4. 比较hash值：如果hash值不同，字符串必然不匹配；如果hash值相同，还小使用朴素算法再次判断
