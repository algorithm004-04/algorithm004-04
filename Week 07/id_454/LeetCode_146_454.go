/**
使用MAP+双向链表实现
*/


type doubleLinkedNode struct {
	key   int
	value int
	pre   *doubleLinkedNode
	post  *doubleLinkedNode
}

var (
	head doubleLinkedNode
	tail doubleLinkedNode
)

func addNode(node *doubleLinkedNode) {
	node.pre = &head
	node.post = head.post

	head.post.pre = node
	head.post = node
}

func removeNode(node *doubleLinkedNode) {
	pre := node.pre
	post := node.post

	pre.post = post
	post.pre = pre
}

func moveToHead(node *doubleLinkedNode) {
	removeNode(node)
	addNode(node)
}

func popTail() *doubleLinkedNode {
	res := tail.pre
	removeNode(res)
	return res
}

type LRUCache struct {
	cache    map[int]*doubleLinkedNode
	count    int
	capacity int
}

func Constructor(capacity int) LRUCache {
	head.post = &tail
	tail.pre = &head
	cache := make(map[int]*doubleLinkedNode)
	lru := LRUCache{
		cache:    cache,
		count:    0,
		capacity: capacity,
	}
	return lru
}

func (this *LRUCache) Get(key int) int {
	if node, ok := this.cache[key]; !ok {
		return -1
	} else {
		moveToHead(node)
		return node.value
	}
}

func (this *LRUCache) Put(key int, value int) {
	if node, ok := this.cache[key]; !ok {
		newNode := doubleLinkedNode{
			key:   key,
			value: value,
		}
		this.cache[key] = &newNode
		addNode(&newNode)

		this.count++
		if this.count > this.capacity {
			tail = *popTail()
			delete(this.cache, tail.key)
			this.count--
		}

	} else {
		node.value = value
		moveToHead(node)
	}
}