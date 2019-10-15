# 杂谈

### 前言 -- 为啥这篇分享是这样
嗨，大家好，我是阎文元，后端开发。

最近时间多，给了胡思乱想的机会。恰好分享，随便聊聊自己最近的想法，因为每一项理解不够深入、不成体系，所以，只能是`杂`。

虽然是`杂谈`，也给自己一个小目标：起码能说明白hashmap对我个人思维的影响。

### 目前我脑中的`数据结构和算法`

`数据结构和算法`的关系是：
> 数据结构是数据的特定存储方式，算法是操作特定存储方式的数据的固定步骤。

预习周时，群里讨论过：为什么算法的思维脑图中有数据结构的概念呢？比如[算法-脑图](https://naotu.baidu.com/file/0a53d3a5343bd86375f348b2831d3610?token=5ab1de1c90d5f3ec)中，有`数组`、`栈`等。我理解这里的`栈`是动词，是对`栈`（数据结构、名词）的操作步骤。以此类推，`算法脑图`中的大部分概念都可以判断为动词，也恰好符合：

> 数据结构是数据的特定存储方式，算法是操作特定存储方式的数据的固定步骤。

单独考虑数据结构，`升维`思想可以划分不同的数据结构。

在覃超老师视频中`数据结构`的分类方式和[数据结构-脑图](https://naotu.baidu.com/file/b832f043e2ead159d584cca4efb19703?token=7a6a56eb2630548c)是不一样的。这里暂时把老师的分类叫做*老师版*，数据结构脑图的分类叫做*经典版*。两者的差别是`升维`。

为了说明`升维`在两者中的作用。尝试以*老师版*为基础融合*经典版*来画图。叶子节点上剔除了我个人相对熟悉的内容。目前理解有限，图中存在有纰漏，后续会一直修正。这是修正自己认知的过程。也推荐你在开始的时候，按自己的想法，画自己的脑图。这好像是我们写程序，一开始写出一个可以运行的，后续重构出一个优雅高效的。脑图如下：

![自己的数据结构-脑图](https://github.com/Kevin922/algorithm004-04/blob/master/Week%20%E9%A2%84%E4%B9%A0%E5%91%A8/id_554/Data%20Structure.png)

最后是算法。知道了算法固定步骤，但是每一个又各有不同。我一开始觉得这是一个个的问题，等我去一个个地解决，然后再一个个地熟练。最近想，可能我首先需要不做一个三季人，常见算法都写过，常见题型都看过。然后再像背九九乘法表一样，熟练掌握。

### 我最喜欢的数据结构 - 散列表
前不久在做论坛，基于微服务的架构，`帖子`和`用户`分为两个服务。帖子列表`postList`的分页查询接口需要返回发帖人userId的用户信息（姓名、头像）。用户服务提供了多个userId查询用户信息的接口，返回用户信息列表`userList`。如何给`postList`填充发帖人信息？

这是一个简单的问题，你会怎么做？

我的Java代码，如下：

``` Java
List<Post> postList = getPostList();
// 去重userId
Set<Long> postUserIds = postList.stream().map(Post::getUserId).collection(Colleactors.toSet());

List<User> userList = getUserListFromUserServer(postUserIds);
// 字典 key - userId, value - user
Map<Long, User> userMap = userList.stream().colleciton(Colleactors.toMap(User::getId, e -> e, (o1, o2) -> o1));
// 填充发帖人信息
for (Post post : postList) {
  // 字典中是否存在user
  if (userMap.get(post.getUserId) != null) {
    User poster = userMap.get(post.getUserId);
    // 填充发帖人信息
  }
}
```

HashMap的特性呢？
1. Java中的HashMap
2. HashMap冲突问题
3. HashMap应用
4. HashMap无序

HashMap的题型呢？
题型分析呢？


### 关于覃超老师的`五毒神掌`的想法
1. 刷题效率问题。
2. 如果自己实现一个『提醒自己复习』的软件呢？



  

