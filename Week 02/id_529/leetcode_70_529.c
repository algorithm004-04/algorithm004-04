/* f(n) = f(n-1)  + f(n-2) */
int climbStairs(int n)
{
    int f1 = 1;
    int f2 = 2; 
    int f3;
    int i;
    if (n == 1) {
        return 1;
    }
    if (n == 2) {
        return 2;
    }
    for (i = 0; i < n; i++) {
        f3 = f1 + f2;
        f1 = f2;
        f2 = f3;
    } 
    return f3;
}
