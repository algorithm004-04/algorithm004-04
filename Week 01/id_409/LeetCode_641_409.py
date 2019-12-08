class DequeNode:
    def __init__(self, k):
        self.value = k
        self.prev_node = None
        self.next_node = None


class MyCircularDeque:
    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.head = None
        self.capacity = k
        self.size = 0


    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.size == self.capacity:
            return False
        node = DequeNode(value)
        if self.size == 0:
            node.next_node = node
            node.prev_node = node
            self.head = node
        else:
            node.next_node = self.head
            node.prev_node = self.head.prev_node
            self.head.prev_node.next_node = node
            self.head.prev_node = node
            self.head = node
        self.size += 1
        # print("insertFront", value)
        # self.show()
        return True


    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        # print("insertLast", value)
        if self.size == self.capacity:
            return False
        node = DequeNode(value)
        if self.size == 0:
            node.next_node = node
            node.prev_node = node
            self.head = node
        else:
            node.next_node = self.head
            # print('node', node.value, 'next', self.head.value)
            node.prev_node = self.head.prev_node
            # print('node', node.value, 'prev', self.head.prev_node.value)
            self.head.prev_node.next_node = node
            # print('head.prev_node',  self.head.prev_node.value, 'next', node.value)
            self.head.prev_node = node
            # print('head', self.head.value, 'prev', node.value)
        self.size += 1
        # self.show()
        return True


    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.size == 0:
            return False
        elif self.size == 1:
            self.head = None
        else:
            node = self.head
            node.next_node.prev_node = node.prev_node
            node.prev_node.next_node = node.next_node
            self.head = node.next_node
            
        self.size -= 1
        # print('deleteFront')
        # self.show()
        return True
        

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.size == 0:
            return False
        elif self.size == 1:
            self.head = None
        else:
            node = self.head.prev_node
            node.prev_node.next_node = node.next_node
            node.next_node.prev_node = node.prev_node
            self.head.prev_node = node.prev_node
        self.size -= 1
        # print("deleteLast")
        # self.show()
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.size == 0:
            return -1
        return self.head.value
        

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.size == 0:
            return -1
        return self.head.prev_node.value
        

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.size == 0
        

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.size == self.capacity
    
    def show(self):
        node = self.head
        res = "o -> {}".format(node.value)
        while node.next_node != self.head:
            res = "{} -> {}".format(res, node.next_node.value)
            node = node.next_node
        print(res)

        

