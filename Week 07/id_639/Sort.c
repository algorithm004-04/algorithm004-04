// 冒泡排序
void BubbleSort(int *arr,int n) {
     int i,j;
     for (i = 0;i < n - 1;i++) {
        for (j = 0;j < n-2-i;j++) {
            if (arr[j] > arr[j+1]) {
                int temp;
                temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
           }
        }
     }
}

// 快速排序
void swap(SqList *L,int low,int high) {
    int temp;
    temp = L->r[high];
    L->r[high] = L->r[low];
    L->r[low] = temp;
}

int Partition(SqList *L,int low,int high) {
   int pivotkey;

   pivotkey = L->r[low];
   while (low < high) {
       while (low < high && L->r[high] >= pivotkey) {
           high--;
       }
       swap(L,low,high);

      while (low < high && L->r[low] <= pivotkey) {
         low++;
      }
      swap(L,low,high);
   }
   return low;
}

void QSort(SqList *L,int low,int high) {
   int privot;
   if (low < high) {
        privot = Partition(L,low,high);
        QSort(L,low,privot-1);
        QSort(L,privot+1,high);
   }
}

void QuickSort(SqList *L) {
   QSort(L,1,L->length);
}


// 归并排序
void Merge(int SR[],int TR[],int i,int m,int n) {
    int j,k,l;

    for (j=m+1,k=i;i<=m && j<=n;k++) {
        if (SR[i] < SR[j]) {
          TR[k] = SR[i++];
        }else {
          TR[k] = SR[j++];
        }
    }

    if (i <= m) {
        for (l = 0;l<=m-i;l++) {
           TR[k+l] = SR[i+l];
        }
    }

    if (j <= n) {
       for (l = 0;l <= n-j;l++) {
          TR[k+l] = SR[j+l];
       }
    }
}

void MSort(int SR[],int TR1[],int s,int t) {
   int m;
   int TR2[MAXSIZE+1];

   if (s == t) {
      TR1[s] = SR[s];
   }else {
      m = (s+t)/2;
      MSort(SR,TR2,s,m);
      MSort(SR,TR2,m+1,t);
      Merge(TR2,TR1,s,m,t);
   }
}

void MergeSort(SqList *L) {
   MSort(L->r,L->r,1,L->length);
}



