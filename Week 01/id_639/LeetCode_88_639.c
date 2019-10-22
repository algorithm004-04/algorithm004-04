/*
	Merge Sorted Array:
			        不知道为什么一开始就觉得这道题是一道很简单的题，看到这道题，首先想到的是归并排序
					做了以后才知道，没那么简单，所以这还是眼高手低的毛病，觉得很简单，其实你并不能写对
					做了以后发现还真是，所以在现实生活中也是这样，不要yy,不要乱想，而是去做一些事情，脚踏实地的做一些东西
					
			1. 没有思路的时候就想暴力解法:
					对比两个数组的值，然后移动nums1数组中的值，然后将nums2数组中的值插入到nums1当中,理论上是可以的，但是实际上自己写出的代码一直没有通过题目中的case，试了很久打算先放一下
			
			2. 题目中提示 What if you fill the longer array from the end instead of start ?
			自己就想到使用从头开始对比数组，将最小的放入到nums1数组的最后，然后依次把nums1和nums2数组对比后的较小的值放到后面，然后反转数组
			
			但是遇到一个case 这样就通不过的，如：
				nums1:  456 
				nums2:  123
				
				合并以后: 454321
				也就是合并的时候6这个元素被覆盖掉了，所以这种方法也是行不通的
		
			3. 将nums1数组中的值放到另一个新数组nums3中，然后使用归并排序合并 nums2和nums3数组
		
			4. 题解中的最后一种做法就相当巧妙了，利用到了题目中数组的特性都是有序的数组
			nums1: 1 2 3 0 0 0
			nums2: 2 5 6
			
			从最大的开始比较然后进行合并，这样就不会出现元素覆盖的问题了
			
			如: nums1: 456
				nums2: 123
				
				合并:   1 2 3 4 5 6
				
			非常巧妙的利用了有序数组的特性，解法非常nice
*/

void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n){
    int i = m-1,j = n-1,z=nums1Size-1;
   
    while (i >=0 && j >=0) {
        if (nums1[i] >= nums2[j]) {
            nums1[z] = nums1[i];
            i--;
            z--;
        } else {
            nums1[z] = nums2[j];
            j--;
            z--;
        }
    }
    
    while (j >= 0) {
           nums1[z] = nums2[j];
            j--;
            z--;
     }
    
    while (i >= 0) {
        nums1[z] = nums1[i];
        i--;
        z--;
    }

}
