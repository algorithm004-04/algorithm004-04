/*
 * @lc app=leetcode id=641 lang=golang
 *
 * [641] Design Circular Deque
 *
 * https://leetcode.com/problems/design-circular-deque/description/
 *
 * algorithms
 * Medium (49.93%)
 * Likes:    131
 * Dislikes: 30
 * Total Accepted:    9.1K
 * Total Submissions: 18.3K
 * Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
 *
 * Design your implementation of the circular double-ended queue (deque).
 * 
 * Your implementation should support following operations:
 * 
 * 
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the
 * operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the
 * operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the
 * operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the
 * operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty,
 * return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return
 * -1.
 * isEmpty(): Checks whether Deque is empty or not. 
 * isFull(): Checks whether Deque is full or not.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to
 * be 3
 * circularDeque.insertLast(1);            // return true
 * circularDeque.insertLast(2);            // return true
 * circularDeque.insertFront(3);            // return true
 * circularDeque.insertFront(4);            // return false, the queue is full
 * circularDeque.getRear();              // return 2
 * circularDeque.isFull();                // return true
 * circularDeque.deleteLast();            // return true
 * circularDeque.insertFront(4);            // return true
 * circularDeque.getFront();            // return 4
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 * 
 * 
 */

 type MyCircularDeque struct {
	data     *list.List
	capacity int
}

/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{new(list.List), k}
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	// already full
	if this.data.Len() >= this.capacity {
		return false
	}
	newNode := this.data.PushFront(value)
	if newNode != nil {
		return true
	}
	return false
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	// already full
	if this.data.Len() >= this.capacity {
		return false
	}
	newNode := this.data.PushBack(value)
	if newNode != nil {
		return true
	}
	return false
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	front := this.data.Front()
	if front != nil {
		node := this.data.Remove(front)
		if node != nil {
			return true
		}
	}
	return false
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	back := this.data.Back()
	if back != nil {
		node := this.data.Remove(back)
		if node != nil {
			return true
		}
	}
	return false
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	front := this.data.Front()
	if front != nil {
		return this.data.Front().Value.(int)
	}
	return -1
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	back := this.data.Back()
	if back != nil {
		return this.data.Back().Value.(int)
	}
	return -1
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.data.Len() == 0
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.data.Len() == this.capacity
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */

