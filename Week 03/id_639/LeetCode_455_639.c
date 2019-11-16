/*
	一开始自己写的时候用了for 循环，不是一次循环，而是用了嵌套的for 循环，自己把复杂度又升高了
	其实比较好的感觉是用while 循环
*/

int comp(const void*a,const void *b) {
    return ( *(int*)a - *(int*)b );
}

int findContentChildren(int *g,int gSize,int *s,int sSize) {
    int ret = 0;

    qsort(g,gSize,sizeof(int),comp);
    qsort(s,sSize,sizeof(int),comp);

    int i=0,j=0;

    while (i < gSize && j < sSize) {
        if (s[j] >= g[i]) {
            ret++;
            i++;
            j++;
        }else {
            j++;
        }
    }

    return ret;
}