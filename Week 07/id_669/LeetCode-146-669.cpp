/*
 * @lc app=leetcode.cn id=146 lang=cpp
 *
 * [146] LRU缓存机制
 *
 * https://leetcode-cn.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (44.44%)
 * Likes:    308
 * Dislikes: 0
 * Total Accepted:    24.6K
 * Total Submissions: 55.2K
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n' +
  '[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) -
 * 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 
 * 进阶:
 * 
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 
 * 示例:
 * 
 * LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * 
 * 
 */

// @lc code=start
class LRUCache {
public:
    LRUCache(int capacity) {
        _capacity = capacity;
    }
    
    int get(int key) {
        auto it = cache.find(key);
        if(it == cache.end())
            return -1;  // 没有找到对应的元素
        update(it);  // 更改为最近访问
        return it->second.first;  // 返回key对应的value
        
    }
    
    void put(int key, int value) {
        auto it = cache.find(key);
        if(it != cache.end()) {
            //key在cache中
            //将其改为最近访问
            update(it); 
        } else {
            if(cache.size() == _capacity){
                cache.erase(used.back());  // 删除最后一个、即最不经常用的元素
                used.pop_back();
            }
            used.push_front(key);
        }
        //因为每次加入元素，都会让该元素成为最近使用的
        //因此，我们也就将对应的{value, 当前元素在used中位置（指针）}设置cache中key对应的value
        cache[key] = {value, used.begin()};
    }
private:
    //用于表示used
    typedef list<int> LI; 
    
    //用于表示cache中的value属性
    //是cache与used之间联系的桥梁
    //key:对应题中的value；
    //value：key对应的数据在used中的存储位置
    typedef pair<int, LI::iterator> PII;    
    
    //用于表示cache
    //key：对应题中的key
    //value：是一个pair，其中key是题中给出的value值，而value是个指针，表示其在used中出现的位置，方便进行更新操作
    typedef unordered_map<int, PII> HIPII;  
    
    //定义一个cache，用于保存加入的数据
    HIPII cache;
    
    //保持一个list，用来表示元素的访问最近访问属性
    //list的值为题中给定的key
    //其中front为最近访问的，back是最不常访问的
    LI used;    
    int _capacity;
    
    //更改访问到的节点的“最近访问属性”
    void update(HIPII::iterator it) {
        int key = it->first;
        //删除当前元素在used中的占位信息
        //需要注意的是，erase是通过指针进行删除的
        //这也是我们保持iterator的原因
        used.erase(it->second.second);
        used.push_front(key);  // 将该元素设为新的最近使用元素
        //以指针指向的位置作为cache与used之间的联系，
        //方便在加入、重新访问该元素对“最近访问属性”进行修改
        it->second.second = used.begin();
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
// @lc code=end

