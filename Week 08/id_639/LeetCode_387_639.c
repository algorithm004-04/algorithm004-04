int firstUniqChar(char *s)
{
    int a[26] = {0};
    int i,len;
    len =strlen(s);
    if (len == 1){
        return 0;
    }
    for (i = 0;i< len;i++) {
        int key;
        key = s[i]-'a';
        a[key]++;
    }
    
    for (i =0 ;i< len;i++) {
        int key;
        key = s[i]-'a';
        if (a[key]==1) {
            return i;
        }
    }
    return -1;
}
