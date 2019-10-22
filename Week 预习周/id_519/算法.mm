<map>
		<node ID="root" TEXT="算法">		<node TEXT="排序算法" ID="a016db9a1d034033" STYLE="bubble" POSITION="right">
		<node TEXT="原地排序：空间复杂度为O(1)的排序算法" ID="3616dbe92b69b0ac" STYLE="fork">
		</node>
		<node TEXT="排序算法的稳定性：如果待排序的序列中存在值相等的元素，经过排序后，相等元素之间的原有的先后顺序不变" ID="4e16dbe933cf7084" STYLE="fork">
		</node>
		<node TEXT="按时间复杂度分类" ID="f16dbe935e76149" STYLE="fork">
		<node TEXT="O(n^2)" ID="3a16db9b794ae178" STYLE="fork">
		<node TEXT="冒泡排序" ID="2f016dbec85d12175" STYLE="fork">
		<node TEXT="原地/稳定" ID="18e16dbec870530ed" STYLE="fork">
		</node>
		<node TEXT="只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较" ID="38716db9b7d3ed149" STYLE="fork">
		</node>
		</node>
		<node TEXT="插入排序" ID="1b116db9b8065d124" STYLE="fork">
		<node TEXT="原地/稳定" ID="12916dbed781ce18f" STYLE="fork">
		</node>
		<node TEXT="数据分为两个区间，已排序区间和未排序区间。取未排序区间中的元素，在已排序区间中找到合适的位置将其插入，并保证已排序区间数据一直有序" ID="2f116dbec8be5c087" STYLE="fork">
		</node>
		</node>
		<node TEXT="选择排序" ID="3bf16db9b81435073" STYLE="fork">
		<node TEXT="原地/非稳定" ID="29816dbede627009b" STYLE="fork">
		</node>
		<node TEXT="每次从未排序区间中找到最小的元素，将其放到已排序区间的末尾" ID="12516dbedd80d7089" STYLE="fork">
		</node>
		</node>
		<node TEXT="希尔排序" ID="35816db9b8217508b" STYLE="fork">
		<node TEXT="原地/非稳定" ID="3c716dbee009dd104" STYLE="fork">
		</node>
		<node TEXT="通过比较相距一定间隔的元素来工作；各趟比较所用的距离随着算法的进行而减小，直到只比较相邻元素的最后一趟排序为止" ID="35716dbeda2f57108" STYLE="fork">
		</node>
		</node>
		<node TEXT="总结" ID="1bd16dbee16607033" STYLE="fork">
		<node TEXT="随着n增加，耗费时间长，适合数据规模较小数据" ID="23e16dbee17cd201a" STYLE="fork">
		</node>
		<node TEXT="相比而言，插入排序是原地/稳定排序且比冒泡排序数据交换次数少，所以胜出" ID="38216dbee1fedd177" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="O(nlogn)" ID="b116db9b839110a9" STYLE="fork">
		<node TEXT="归并排序" ID="33116db9b870a60c8" STYLE="fork">
		<node TEXT="非原地/稳定" ID="ef16dbeecd2e9185" STYLE="fork">
		</node>
		<node TEXT="如果要排序一个数组，先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排好序的两部分合并在一起" ID="17216dbee8af26065" STYLE="fork">
		</node>
		</node>
		<node TEXT="快速排序" ID="4516db9b8898113b" STYLE="fork">
		<node TEXT="原地/非稳定" ID="13916dbefadfe2077" STYLE="fork">
		</node>
		<node TEXT="要排序数组中下标从p到r之间的一组数据，选择p到r之间的任意一个数据作为分区点pivot；变量p到r之间的数据，将小于pivot的放到左边，将大于pivot的放在右边；根据分治递归的处理思想，再递归排序p到q-1之间的数据和下标q+1到r的数据，直至区间缩小为1" ID="3a016dbeed08d20bd" STYLE="fork">
		</node>
		</node>
		<node TEXT="堆排序" ID="2f516db9b8a3f40e4" STYLE="fork">
		<node TEXT="原地/非稳定" ID="26816dbf0236c400b" STYLE="fork">
		</node>
		<node TEXT="完全二叉树，优先级排序" ID="12016dbeffaf5801b" STYLE="fork">
		</node>
		<node TEXT="借助堆结构实现的排序算法" ID="3be16dbf01d92409e" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="O(n)" ID="8c16db9b8b52717d" STYLE="fork">
		<node TEXT="桶排序" ID="2aa16db9b92c78022" STYLE="fork">
		<node TEXT="将要排序的数据分到几个有序的桶里，每个桶里的数据再单独进行排序，桶内排好序后，再把每个桶里的数据按照顺序依次取出，组成的序列就是有序的" ID="16616dbf0414ac142" STYLE="fork">
		</node>
		<node TEXT="适用外部排序（无法将数据全部加载到内存中的排序）" ID="16116dbf062db2143" STYLE="fork">
		</node>
		<node TEXT="应用：商品订单排序" ID="2a816dbf18021c0a4" STYLE="fork">
		</node>
		</node>
		<node TEXT="计数排序" ID="2b616db9b8ce94139" STYLE="fork">
		<node TEXT="桶排序的一种特殊情况特殊情况。当要排序的n个数据，所处的范围不大的时候，如最大值为k，就可以把数据划分成k个桶，每个桶内的数据都是相同的，这样就节省了桶内排序的时间" ID="5616dbf03864306f" STYLE="fork">
		</node>
		<node TEXT="应用：全省学生考试成绩" ID="10316dbf185c6e03" STYLE="fork">
		</node>
		</node>
		<node TEXT="基数排序" ID="7316db9b8f14c193" STYLE="fork">
		<node TEXT="将组成数字的每一位进行排序，每一位数字在排序过程中可以使用桶排序或者计数排序，再重复k次" ID="37016dbf1c05d70b3" STYLE="fork">
		</node>
		<node TEXT="应用：手机号码等" ID="34b16dbf1d826b001" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
		</node>
		<node TEXT="查找算法" ID="2f16db9a1db2b166" STYLE="bubble" POSITION="right">
		<node TEXT="二分查找" ID="10516db9bb413d023" STYLE="fork">
		<node TEXT="针对的是一个有序的数据集合，每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，或者区间被缩小为0" ID="23416dbf3687f80e8" STYLE="fork">
		</node>
		<node TEXT="时间复杂度O(logn)" ID="2bb16dbf3dfe35086" STYLE="fork">
		</node>
		<node TEXT="场景限制" ID="29316dbf3e8fe3145" STYLE="fork">
		<node TEXT="顺序表结构" ID="2e716dbf3eef73199" STYLE="fork">
		</node>
		<node TEXT="有序数据" ID="18816dbf3f2b4c01c" STYLE="fork">
		</node>
		<node TEXT="数据量太小不适合，可以直接顺序查找" ID="7c16dbf3f6ec6132" STYLE="fork">
		</node>
		<node TEXT="数据量太大也不适合，顺序结构，对内存要求高，需要连续内存" ID="27516dbf404a1d16b" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="散列表" ID="22a16db9bb705e161" STYLE="fork">
		<node TEXT="数组+哈希函数" ID="39e16dbf4198c2088" STYLE="fork">
		</node>
		</node>
		<node TEXT="跳表" ID="35716dbf42b4e102b" STYLE="fork">
		<node TEXT="多级链表" ID="33116dbf42cc940af" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="基本算法思想" ID="9d16db9b9867f0a4" STYLE="bubble" POSITION="right">
		<node TEXT="贪心/婪算法" ID="27816db9b9984507c" STYLE="fork">
		<node TEXT="分阶段工作，在每一个阶段，可以认为所做决定是最好的，而不考虑将来的后果。通常意味着选择的是某个局部最优" ID="9316dbf454f9e148" STYLE="fork">
		</node>
		<node TEXT="实际应用" ID="2c016dbf476894062" STYLE="fork">
		<node TEXT="Dijkstra算法、Prim算法、Kruskal算法" ID="e816dbf44b78705a" STYLE="fork">
		</node>
		<node TEXT="付款：先使用大面值来支付" ID="3a816dbf477f9416c" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="分治算法" ID="23e16db9b9b47a157" STYLE="fork">
		<node TEXT="两部分组成：分，递归解决较小的问题；治，从子问题的解构建原问题的解" ID="de16dbf4adbbb103" STYLE="fork">
		</node>
		<node TEXT="实际应用" ID="1d316dbf4f7a7710f" STYLE="fork">
		<node TEXT="fork/join框架" ID="24f16dbf4fa11f162" STYLE="fork">
		</node>
		<node TEXT="斐波那契数列" ID="14716dbf4fd8ab184" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="动态规划" ID="9516db9b9ca5612a" STYLE="fork">
		<node TEXT="问题分解为多个阶段，每个阶段对应一个决策。记录每一个阶段可达的状态集合，然后通过当前阶段的状态集合，推导下一个阶段的状态集合，动态的往前推进。" ID="37b16dbf5908b605a" STYLE="fork">
		</node>
		<node TEXT="实际应用" ID="7d16dbf55eeda07d" STYLE="fork">
		<node TEXT="求最优解" ID="2c816dbf561f1b0f1" STYLE="fork">
		</node>
		<node TEXT="双11凑单问题" ID="1ec16dbf50119c171" STYLE="fork">
		</node>
		</node>
		</node>
		<node TEXT="回溯算法" ID="19316db9b9dec9169" STYLE="fork">
		<node TEXT="问题求解过程分为多个阶段，每个阶段，任意选择进行下去，当发现条件不满足时，则回退" ID="37616dbf5dd70d154" STYLE="fork">
		</node>
		<node TEXT="实际应用" ID="cb16dbf623222003" STYLE="fork">
		<node TEXT="八皇后" ID="15a16dbf6243430a6" STYLE="fork">
		</node>
		</node>
		</node>
		</node>
</node>
</map>