# 聊聊散列表

## 前言
嗨，大家好，我是阎文元，后端开发。

最近时间多，给了胡思乱想的机会。恰好分享，随便聊聊自己最近的想法，因为每一项理解不够深入，大家能聊聊就好。

目录：
1. [目前我脑中的`数据结构和算法`](https://github.com/Kevin922/algorithm004-04/blob/master/Week%20%E9%A2%84%E4%B9%A0%E5%91%A8/id_554/NOTE.md#%E7%9B%AE%E5%89%8D%E6%88%91%E8%84%91%E4%B8%AD%E7%9A%84%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95)
2. [散列表 - 键值对](https://github.com/Kevin922/algorithm004-04/blob/master/Week%20%E9%A2%84%E4%B9%A0%E5%91%A8/id_554/NOTE.md#%E6%95%A3%E5%88%97%E8%A1%A8---%E9%94%AE%E5%80%BC%E5%AF%B9)
3. [关于覃超老师的`五毒神掌`的想法](https://github.com/Kevin922/algorithm004-04/blob/master/Week%20%E9%A2%84%E4%B9%A0%E5%91%A8/id_554/NOTE.md#%E5%85%B3%E4%BA%8E%E8%A6%83%E8%B6%85%E8%80%81%E5%B8%88%E7%9A%84%E4%BA%94%E6%AF%92%E7%A5%9E%E6%8E%8C%E7%9A%84%E6%83%B3%E6%B3%95)


## 目前我脑中的`数据结构和算法`

`数据结构和算法`的关系是：
> 数据结构是数据的特定存储方式，算法是操作特定存储方式的数据的固定步骤。

预习周时，群里讨论过：为什么算法的思维脑图中有数据结构的概念呢？比如[算法-脑图](https://naotu.baidu.com/file/0a53d3a5343bd86375f348b2831d3610?token=5ab1de1c90d5f3ec)中，有`数组`、`栈`等。我理解这里的`栈`是动词，是对`栈`（数据结构、名词）的操作步骤。以此类推，`算法脑图`中的大部分概念都可以判断为动词，也恰好符合：

> 数据结构是数据的特定存储方式，算法是操作特定存储方式的数据的固定步骤。

单独考虑数据结构，`升维`思想可以划分不同的数据结构。

在覃超老师视频中`数据结构`的分类方式和[数据结构-脑图](https://naotu.baidu.com/file/b832f043e2ead159d584cca4efb19703?token=7a6a56eb2630548c)是不一样的。这里暂时把老师的分类叫做*老师版*，数据结构脑图的分类叫做*经典版*。两者的差别是`升维`。

为了说明`升维`在两者中的作用。尝试以*老师版*为基础融合*经典版*来画图。叶子节点上剔除了我个人相对熟悉的内容。目前理解有限，图中存在有纰漏，后续会一直修正。这是修正自己认知的过程。也推荐你在开始的时候，按自己的想法，画自己的脑图。这好像是我们写程序，一开始写出一个可以运行的，后续重构出一个优雅高效的。脑图如下：

![自己的数据结构-脑图](https://github.com/Kevin922/algorithm004-04/blob/master/Week%20%E9%A2%84%E4%B9%A0%E5%91%A8/id_554/Data%20Structure.png)

## 散列表 - 键值对
散列表是我非常喜欢的数据结构。理想情况，查询时间复杂度O(1)，增删改时间复杂度O(1)。当然，只是理想，散列冲突会改变时间复杂度。不过依然比链表的查询效率高。不需要扩容时，比数组的增删代价小。

通过键可以快速查到值，这样键值对的思想用途广泛。C++、Java提供了类库，Python、JavaScript、Go语言层面支持。Redis也采用键值的查询方式。Json、Xml、YAML语言，Java工程中的property文件等等，也可以从键值对的角度来看。

前不久做论坛，基于微服务架构，`帖子`和`用户`分为两个服务。帖子列表`postList`的分页查询接口需要返回发帖人userId的用户信息（姓名、头像）。用户服务提供了多个userId查询用户信息的接口，返回用户信息列表`userList`。如何给`postList`填充发帖人信息？

这个问题，你会怎么做？

我的Java代码，如下：

``` Java
List<Post> postList = getPostList();
// 去重userId
Set<Long> postUserIds = postList.stream().map(Post::getUserId).collection(Colleactors.toSet());

List<User> userList = getUserListFromUserServer(postUserIds);
// 字典 key - userId, value - user
Map<Long, User> userMap = 
          userList.stream().colleciton(Colleactors.toMap(User::getId, e -> e, (o1, o2) -> o1));
// 填充发帖人信息
for (Post post : postList) {
  // 字典中是否存在user
  if (userMap.get(post.getUserId) != null) {
    User poster = userMap.get(post.getUserId);
    // 填充发帖人信息
  }
}
```

上面代码，最基本的思想就是键值对，建立字典后不必通过第二次循环这种高消耗的操作来查询想要的数据。

看一个问题：LeetCode上第一题 [两数之和](https://leetcode-cn.com/problems/two-sum/)。思考一下呢。你会怎么解决？

下面是我在今年5月份的解法。顺便说，我第一反应是用两重循环，简单粗暴有效。第二反应是用键值对。这是在早晚地铁上偶尔想想完成的，现在回忆估计前后花了2天时间。代码实现是在IDE idea里面估计敲了30分钟完成的。解决了问题我也很高兴，不过潜意识里隐隐感觉这事有诈，时间成本太高了。*碎片化时间*的方法可能对我有毒。最后一小节的*五毒神掌*会讨论聊聊，书归正传，看代码。 

Java代码：

``` Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>(nums.length);
        // 我做题除非题目要去，一般不考虑空间，哈哈
        // 首先，数组 转为 散列表（字典、Map）
        for (Integer i = 0; i < nums.length; i++) {
            numIndexMap.put(nums[i], i);
        }
        // 遍历数组，根据target做减法，判断散列表中是否存在
        for (Integer i = 0; i < nums.length; i++) {
            // 存在，返回结果
            if (null != numIndexMap.get(target - nums[i])  
                && !numIndexMap.get(target - nums[i]).equals(i)) {
                Integer finalI = i;
                return new int[]{i, numIndexMap.get(target - nums[finalI])};
            }
        }
        // 不存在，返回空
        return new int[]{};
    }
}
```

上面代码可以优化，比如优化为一次循环效率更好，而且在一般情况，不必将全部数组转换为散列表。

这里想分享的是键值对的思想，能更方便地解决问题。

更进一步：[三数之和](https://leetcode-cn.com/problems/3sum/)。同样，思考一下呢？

我的解法，Java代码：

``` Java
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> targetMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            targetMap.put(nums[i], i);
        }

        List<List<Integer>> rst = new ArrayList<>(nums.length/3);
        Set<String> unique = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int target = -(nums[i] + nums[j]);
                if (targetMap.get(target) != null
                        && targetMap.get(target) != i
                        && targetMap.get(target) != j) {
                    Integer[] r = new Integer[]{nums[i], nums[j], target};
                    Arrays.sort(r);
                    String uniqueStr = r[0] + "," + r[1] + "," + r[2];
                    if (!unique.contains(uniqueStr)) {
                        unique.add(uniqueStr);
                        rst.add(Arrays.asList(r));
                    }
                }
            }
        }
        return rst;
    }
}
```

上面的代码思路：
1. 将`nums`看过目标结果集，nums转为哈希表
2. 两重循环，计算目标结果，判断是否存在与目标值匹配的组合
   1. 存在。我用了一个笨办法去重。结果放到返回值。
   2. 不存在。啥都不做。下一个。

但是，很遗憾，上面的编程方式，效率太低，超时而无法通过测试。

其实我也想用*划归思想*去解决*三数之和*，利用现有的*两数之和*作为函数，不过稍微仔细琢磨，感觉还是比较复杂，不如重新做。

有趣的是，LeetCode在*3数之和*的第一页解答中，大家普遍采用*排序 + 双指针*的办法。估计是哈希表的*去重*实在是个效率低的点。我想了4个小时了，暂时没想到*去重*如何优化。

LeetCode上关于散列表的题目目前119道。[附带链接，点击跳转。](https://leetcode-cn.com/tag/hash-table/)。其实我也好奇，我们刷题时候，要不要刷全部？

只考虑算法中的散列表（哈希表）过于单纯，工程中还会有其他因素。比如多线程下，Java中的`HashMap`并非线程安全，`ConCurrentHashMap`是线程安全。既然`ConCurrentHashMap`线程安全了，又是如何保证高并发的呢？简单讲，`ConCurrentHashMap`是多个`Segment`的组成，每次并发读写都会放在各个`Segment`执行。如果恰好并发写在了同一个`Segment`，那么就阻塞写。参考这篇[知乎文章](https://zhuanlan.zhihu.com/p/31614308)。类似分析文章有很多，随意google即可。只是一点感悟，这里的`Segment`有点像是`空间换时间`操作，逻辑上划分空间，并发操作不在同一空间，自然不会存在并发问题。

最后零碎想提的是：
1. 键值对是无序的。
2. 数组*array*和链表*linked list*是实现散列表*map*（哈希表）的基础数据结构，这点能从上图*数据结构-脑图*中看出。数组和链表是在数据结构一维基础部分。哈希表是在数据结构一维高级部分。

## 关于覃超老师的`五毒神掌`的想法
上面提到了：
> 我在写*两数之和*的时间跨度是2.5天，利用了中间的所谓*碎片化时间*。

这涉及到一个效率问题。毕竟更及时的反馈更有可能达成目标。第一次听到*五毒神掌*也就是*五遍刷题法*时，有效解答了我的问题。只需要多次重复、充分理解问题，这就可能不需要花费2.5天的时间。在有限的精力下，可能能完成熟练算法的目标。

还有*碎片化时间*这个概念。个人观点，这概念有毒。人并不真正拥有时间，时间可能人生的衡量单位，或者是一个物理的维度。但是人一定不会拥有时间。那人拿什么去学习生活？精力。人真正拥有的是精力。控制时间不如控制精力。每个人每天都是24小时，但是每个人的精力各有不同，每个人分配精力的方式也各有不同。昨天听到一个饭桌故事，投资大佬A在北上广伦敦都有房，但是大佬A从来不住。大佬A住酒店，美股开盘就人间蒸发。他认为酒店各种设施都有人帮他做好了，省心。

试一试，想想自己在过去6小时的精力分配在了哪里。合理安排精力更实在。

说回*五毒神掌*的事情。如果只是惊艳于这个想法，并不符合我骚想法多（做得少）的性格。多想一步。*五毒神掌*和*艾宾浩斯记忆曲线*有点像。有不少记忆单词的app，但是好像没有定期复习算法的app。我看现在的大陆LeetCode有部分题目是会员题目，像是闭关锁国。不知道卖*艾宾浩斯 算法 app*会不会实现盈利。

那么，假想功能：
1. 有题目，可以做题。
2. 做过的题会记录下来。
3. 周期性地提醒你复习做过的题。
4. 周期一开始时间间隔短，之后时间间隔长，并且越来越长。
5. 上面是一期功能。二期功能，用户在提醒时候，如果选择*记忆模糊*，那么提醒周期的时间间隔依然短。

好啦，不使用数据库，你会选择什么样的数据结构做功能设计呢？

我的想法：
1. 第一次做过的题目，放入*已完成*链表`doneList`，同时放入*第一次复习（立即复习）*链表`firstList`。
2. 选择*复习*后，展示`firstList`链表。每完成一道题目，从`firstList`中删除，放入*第二天复习*`tomorrowList`。
3. 第二天选择*复习*后，优先展示`tomorrowList`，然后放入`seeYouNextWeekRedBlackTree`。如果当天有做题，在`tomorrowList`之后展示`firstList`。
4. 下周复习`seeYouNextWeekRedBlackTree`采用红黑树，是希望比较当前时间是否已经过去一周了，同时希望能快速展示出*已经过去一周*的题目。链表的搜索效率不高，但是结构简单，插入删除速度快，可以像纸牌一样任意打乱顺序。
5. 假定，最后一次复习是一个月之后，那么`seeYouNextWeekRedBlackTree`做完之后，就放入`seeYouNextMonthRedBlackTree`。下个月再去复习。

因为我复习算法也不完全像是背单词那样的*短频快*，更像是每次做一张5题一组的小测验。每个人都有解题顺序和习惯，他们可以在点击*复习*之后自由选择先做哪一题，后做哪一题。可能今天只有1小时，只做了其中2题，剩下3题。没有关系，链表的增删成本低。基于以上原因，我没有选择数组。同样类似的软件，还有*驾照考试*。

这应该是个有意思的项目，或许我们可以做一个开源项目。

这是我的分享，感谢阅读 ^_^
