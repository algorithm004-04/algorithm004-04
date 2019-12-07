package simple;

public class LC1122 {

    /**
     * 使用桶排序
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        //计数每个桶有多少个数，也就是每个值在数组中有几个
        for(int num:arr1){
            bucket[num]++;
        }
        //由于重新排序不会改变数组的长度，所以可以利用原数组，可以节省空间复杂度
        int i = 0;
        //由于排序是按照相对顺序进行排序，所以，首先根据arr2中的桶的顺序，依次从对应的桶中取数到arr1中
        //并注意，每拿出一个数，需要将对桶中的数的个数进行-1操作
        for(int num:arr2){
            while(bucket[num]-- > 0){
                arr1[i++] = num;
            }
        }
        //未在arr2中的桶中的数，按照桶号升序进行输出，所以进行二次遍历
        for(int j = 0; j < 1001; ++j){
            while(bucket[j]-- > 0){
                arr1[i++] = j;
            }
        }
        return arr1;
    }

}
