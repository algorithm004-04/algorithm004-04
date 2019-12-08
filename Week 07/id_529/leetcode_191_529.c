int hammingWeight(unsigned int n) 
{
    int count = 0;
    int i;
    for (i = 0 ; i < 32; i++) {
        if ((n>>i) & 0x1) {
            count++;
        }
    }
    return count;
}
void main()
{
    int n = hammingWeight(11);
    printf("%d", n);
}