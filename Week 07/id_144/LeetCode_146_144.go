/*
 * @lc app=leetcode id=146 lang=golang
 *
 * [146] LRU Cache
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * algorithms
 * Medium (27.18%)
 * Likes:    3734
 * Dislikes: 153
 * Total Accepted:    364.7K
 * Total Submissions: 1.3M
 * Testcase Example:  '["LRUCache","put","put","get","put","get","put","get","get","get"]\n[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]'
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * 
 * The cache is initialized with a positive capacity.
 * 
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * 
 * Example:
 * 
 * 
 * LRUCache cache = new LRUCache( 2 /* capacity */ );
 * 
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * 
 * 
 * 
 * 
 */

import "container/list"

// @lc code=start
type entry struct {
	key   int
	value int
}

type LRUCache struct {
	capacity int
	ll       *list.List
	cache    map[int]*list.Element
}

func Constructor(capacity int) LRUCache {
	return LRUCache{
		capacity: capacity,
		ll:       list.New(),
		cache:    make(map[int]*list.Element),
	}
}

func (this *LRUCache) Get(key int) int {
	if this.cache == nil {
		return -1
	}
	if ele, hit := this.cache[key]; hit {
		this.ll.MoveToFront(ele)
		return ele.Value.(*entry).value
	}
	return -1
}

func (this *LRUCache) Put(key int, value int) {
	if this.cache == nil {
		this.cache = make(map[int]*list.Element)
		this.ll = list.New()
	}
	if ee, ok := this.cache[key]; ok {
		this.ll.MoveToFront(ee)
		ee.Value.(*entry).value = value
		return
	}
	ele := this.ll.PushFront(&entry{key, value})
	this.cache[key] = ele
	if this.capacity != 0 && this.ll.Len() > this.capacity {
		oldest := this.ll.Back()
		if oldest != nil {
			this.ll.Remove(oldest)
			kv := oldest.Value.(*entry)
			delete(this.cache, kv.key)
		}
	}
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */
// @lc code=end

