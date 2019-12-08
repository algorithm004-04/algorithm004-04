int find(int *parent, int i)
{
    if(parent[i] == -1) {
        return i;
    }
    return find(parent, parent[i]);
}
void unify(int *parent, int x, int y)
{
    int xset = find(parent, x);
    int yset = find(parent, y);
    if (xset != yset) {
        parent[xset] = yset;
    }
}

int findCircleNum(int M[][3], int MSize, int* MColSize){
    int *parent = malloc(sizeof(int)*MSize);
    int i, j;
    for (i = 0; i < MSize; i++) {
        parent[i] = -1;
    }
    for (i = 0; i < MSize; i ++) {
        for (j = 0; j < *MColSize; j++) {
            if (M[i][j] == 1 && i !=j) {
                unify(parent, i, j);
            }
        }
    }
    int count = 0;
    for (int i = 0; i < MSize; i++) {
        if (parent[i] == -1) {
            count++;
        }
    }

    return count;
}

void main()
{
    int a[3][3] = {{1,1,0}, {1,1,0}, {0,0,1}};
    int count;
    int colSize = 3;
    count = findCircleNum(a, 3, &colSize);
    printf("%d", count);
}