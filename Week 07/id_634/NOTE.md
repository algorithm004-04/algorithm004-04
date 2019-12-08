# NOTE

##### 位运算
1.机器里的数字表示方式和存储格式是二进制
2.进制转换
3.算数移位与逻辑移位:左移、右移、按位或、按位与、按位取反、按位异或
4.XOR-异或 相同为0、不同为1.也可用“不进位加法”来理解

异或操作特点:
x^0=x
x^1s=~x
x^(~x)=1s
x^x=0
c=a^b => a^c=b,b^c=a //交换两个数
a^b^c=>a^(b^c)=(a^b)^c //associative

指定位置的位运算:
1.将x最右边的n位清零: x&(~0<<n)
2.获取x的第n位值(0或者1): (x>>n)&1
3.获取x的第n位的幂值: x&(1<<(n-1))
4.仅将第n位置位1:x|(1<<n)
5.仅将第n位置位0:x&(~(1<<n))
6.将x最高位至第n位(含)清零:x&((1<<n)-1)
7.将第n位至第0位(含)清零：x&(~((1<<(n+1))-1))

实战位运算要点:
判断奇偶:
x%2==1 --> (x&1)==1
x%2==0 --> (x&1)==0

x>>1 --> x/2
即: x=x/2; --> x=x>>1;
    mid = (left + right)/2； --> mid = (left + right)>>1;

X=X&(X-1)清零最低位的1
X&-X=>得到最低位的1
X&~X=>0

##### 布隆过滤器
Bloom Filter vs Hash Table
一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检查一个元素是否在一个集合中。
优点:空间效率和查询时间远远超过一般的算法
缺点:有一定的误识别率和删除困难

案例:
1.比特币网络
2.分布式系统(Map-Reduce)--Hadoop、SearchEngine
3.Redis缓存
4.垃圾邮件、评论等的过滤

##### LRU Cache
Cache缓存
1.记忆
2.钱包-储物柜
3.代码模块

LRU Cache
两个要素：大小、替换策略
HashTable+Double LinkedList

O(1)查询
O(1)修改、更新

least recent use 最近最少使用的
哈希表+双向链表

##### 排序算法

###### 排序算法
1.比较类排序
通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。
2.非比较类排序
不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

###### 初级排序-O(n^2)
1.选择排序（Selection Sort）
每次找最小值，然后放到待排序数组的起始位置。
2.插入排序（Insertion Sort）
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
3.冒泡排序（Bubble Sort）
嵌套循环，每次查看相邻的元素如果逆序，则交换

###### 高级排序-O(N\*LogN)

快速排序（Quick Sort）:
数组取标杆pivot，将小元素放pivot左边，大元素放右侧，然后依次对右边和右边的子数组继续快排；以达到整个序列有序。

归并排序（Merge Sort）-分治:
1.把长度为n的输入序列分成两个长度为n/2的子序列；
2.对这两个子序列分步采用归并排序；
3.将两个排序号的子序列合并成一个最终的排序序列

归并和快排具有相似性，但步骤顺序相反
归并：先排序左右子数组，然后合并两个有序子数组
快排：先调配出左右子数组，然后对于左右子数组进行排序

###### 堆排序（Heap Sort）-堆插入O(logN)，取最大/小值O(1)
1.数组元素依次建立小顶堆
2.依次取堆顶元素，并删除

###### 特殊排序-O(n)
1.计数排序(Conting Sort)
计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为健存储在额外开辟的数组空间中；然后依次把计数大于1的填充回原数组
2.桶排序(Bucket Sort)
桶排序(Bucket Sort)的工作的原理：
假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序(有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。
3.基础排序(Radix Sort)
基础排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。

###### Java初级排序代码

1.选择排序（Selection Sort）
每次找最小值，然后放到待排序数组的起始位置。

``` java
public static void main(String[] args) {
    int[] nums = {10, 5, 6, 7, 1, 2, 4};
    System.out.println("排序前数组为：");
    for (int num : nums) {
        System.out.print(num + " ");
    }
    //选择排序的优化
    for (int i = 0; i < nums.length - 1; i++) {// 做第i趟排序
        int k = i;
        for (int j = k + 1; j < nums.length; j++) {// 选最小的记录
            if (nums[j] < nums[k]) {
                k = j; //记下目前找到的最小值所在的位置
            }
        }
        //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
        if (i != k) {  //交换a[i]和a[k]
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
    System.out.println();
    System.out.println("排序后的数组为：");
    for (int num : nums) {
        System.out.print(num + " ");
    }
}
``` 

2.插入排序（Insertion Sort）
从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。

``` java
public static void main(String[] args) {
    int[] nums = {10, 5, 6, 7, 1, 2, 4};
    System.out.println("排序前数组为：");
    for (int num : nums) {
        System.out.print(num + " ");
    }
    //从数组的第二个元素开始查找
    for (int i = 1; i < nums.length; i++) {
        int j;
        int temp = nums[i];
        //将元素与前一个元素进行比较，从后往前，将小的元素放在前面。
        for (j = i; j > 0 && temp < nums[j - 1]; j--) { //注意比较条件的顺序。 用temp是因为，arr[i]在变化。
            nums[j] = nums[j - 1];
        }
        nums[j] = temp; //将arr[i]按照顺序插入到j位置。
    }
    System.out.println();
    System.out.println("排序后的数组为：");
    for (int num : nums) {
        System.out.print(num + " ");
    }
}
``` 

3.冒泡排序（Bubble Sort）
嵌套循环，每次查看相邻的元素如果逆序，则交换

``` java
public static void main(String[] args) {
    int[] nums = {10, 5, 6, 7, 1, 2, 4};
    System.out.println("排序前数组为：");
    for (int num : nums) {
        System.out.print(num + " ");
    }
    for (int i = 0; i < nums.length - 1; i++) {//外层循环控制排序趟数
        for (int j = 0; j < nums.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
            if (nums[j] > nums[j + 1]) {
                int temp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = temp;
            }
        }
    }
    System.out.println();
    System.out.println("排序后的数组为：");
    for (int num : nums) {
        System.out.print(num + " ");
    }
}
``` 


