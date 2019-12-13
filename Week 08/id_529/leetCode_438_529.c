

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#define Q 9997
#define A 256
int hashSet(char *s, int len)
{
    int i;
    int sum = 0;
    for (i=len-1; i >= 0; i--) {
        sum += (s[i] - '0') * A^i % Q;
    }
    return sum;
}
int isAnagrams(char *p, char *s, int len) {
    int hash[256] = {0};
    for (int i = 0; i < len; i++) {
        hash[p[i]]++;
        hash[s[i]]--;
    }
    for (int i = 0; i < 256; i++) {
        if (hash[i] != 0) {
            return 0;
        }
    }
    return 1;
}
int* findAnagrams(char * s, char * p, int* returnSize){
    int lenp;
    int lens;
    int hashP;
    int flag = 0;
    char ch;
    lenp = strlen(p);
    lens = strlen(s);
    *returnSize = 0;
 //   printf("%d, %d\n", lenp, lens);
     int count = 0;
    if (lens < lenp) {
        printf("error %d, %d", lenp, lens);
        return 0;
    }
    int i;
    int *result = malloc(sizeof(int)*lens);

   for (i = 0; i <= lens - lenp; i++) {
        if (flag) {
            if (ch == s[lenp-1]) {
                flag = 1;
                ch = s[0];
                result[count++] = i;
            } else {
                flag = 0;
            }
        } else if (isAnagrams(s, p, lenp)) {            
            result[count++] = i;
            flag = 1;
            ch = s[0];
        }
        s = s + 1;
    }
 //    printf("%d, %d, %d\n", count, hashP, hashValueArr[0]);
    *returnSize = count;
    return result;
 //   return 0;
}

int main()
{

 //   char *s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz\
    abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz\
    abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz\
    abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz\
    abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz\
    abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
 //   char *p  = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
    char *s = "cbaebabacd";
    char *p = "abc";

    int *result;
    int returnSize;
    result = findAnagrams(s, p, &returnSize);
    for (int i=0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }
}