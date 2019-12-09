void bubbleSort(int *a, int len)
{
    int i;
    int j;
    int temp;
    for (i = 0; i < len - 1; i++){
        for (j = 0; j < len - 1 - i; j++) {
            if (a[j] > a[j+1]) {
                temp = a[j+1];
                a[j+1] = a[j];
                a[j] = temp;
            }
        }
    }
}
void bubbleSort2(int *a, int len)
{
    int i;
    int j;
    int temp;
    for (i = 0; i < len; i++) {
        for (j = i+1; j < len; j++) {
            if (a[i] > a[j]) {
                temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
    }
}
void selctSort(int *a, int len)
{
    int i;
    int j;
    int temp;
    int minIndex = 0;
    for (i = 0; i < len - 1; i++) {
        minIndex = i;
        for (j = i+1; j < len; j++) {
            if (a[minIndex] > a[j]) {
                minIndex = j;
            }
        }
        temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }
}
int partion(int *a, int left, int right)
{
    int i = 0;
    int j = 0;
    int p = left;
    int index = p + 1;
    int temp;
    for (i = index; i <= right; i++) {
        if (a[i] < a[p]) {
            temp = a[i];
            a[i] = a[index];
            a[index] = temp;
            index++;
        }
    }
    temp = a[p];
    a[p] = a[index-1];
    a[index-1] = temp;
    return index - 1;
}
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
int partion2(int *a, int left, int right)
{
    int i = 0;
    int p = right; 
    int count = left;
    for (i = left; i < right; i++) {
        if (a[i] < a[p]) {
            swap(&a[i], &a[count]);
            count++;
        }
    }
    swap(&a[p], &a[count]);
    return count;
}
void quickSort(int *a, int left, int right)
{
    int pivot = 0;
    if (left >= right) {
        return;
    }
    pivot = partion2(a, left, right);
    quickSort(a, left, pivot-1);
    quickSort(a, pivot+1, right);
}

void merge(int *a, int left, int mid, int right) 
{
    int i = left;
    int j = mid + 1;
    int *temp = malloc(sizeof(int) * (right - left + 1));
    int k  = 0;
    while (i <= mid && j <= right) {
        if (a[i] < a[j]) {
            temp[k++] = a[i++];            
        } else {
            temp[k++] = a[j++];
        }
    }
    while (i <= mid) {
        temp[k++] = a[i++];
    }
    while (j <= right) {
        temp[k++] = a[j++];
    }
    for(i = 0; i < k; i++) {
        a[left + i] = temp[i];
    }   
    free(temp);
}
void mergeSort(int *a, int left, int right)
{
    if (left >= right) {// !!! 注意
        return;
    }
 //   int mid = (right + left ) >> 1;
    int mid = ((right - left ) >> 1) + left; //!! 注意
    mergeSort(a, left, mid);
    mergeSort(a, mid+1, right);
    merge(a, left, mid, right);
}

void main()
{
    int arry[6] = {5,2,6,3,7,4};
    //selctSort(arry, 6);
    //quickSort(arry, 0, 5);
    mergeSort(arry, 0, 5);
    for (int i=0; i < 6; i++) {
        printf("%d ", arry[i]);
    }
}