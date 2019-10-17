### Remove Duplicates from Sorted Array
> 分析： 移除重复值，整体遍历。需要一个临时变量记录上一次查询到的值，一个变量记录当前可修改的最小位置，首次代码如下

```c
int removeDuplicates(int* nums, int numsSize){
    int cur, tmp, ptr=0;
    for(cur=0;cur<numsSize;cur++){
        if (cur == 0){ 
            tmp = nums[cur];
            ptr++;
        } else {
            if (tmp == nums[cur]) {
                continue;
            }   
            nums[ptr] = nums[cur];
            tmp = nums[cur];
            ptr++;
        }   
    }   
    return ptr;
}
```
