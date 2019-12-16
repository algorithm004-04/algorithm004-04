class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.q, self.k = [], k

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if len(self.q) < self.k:
            self.q.insert(0, value)
            return True
        else:
            return False

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if len(self.q) < self.k:
            self.q += [value]
            return True
        else:
            return False

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if len(self.q) != 0:
            self.q.pop(0)
            return True
        else:
            return False
        

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if len(self.q) != 0:
            self.q.pop()
            return True
        else:
            return False

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if len(self.q) != 0:
            return self.q[0]
        else:
            return -1
        

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if len(self.q) != 0:
            return self.q[-1]
        else:
            return -1

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        if len(self.q) == 0:
            return True
        else:
            return False
            
        

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        if len(self.q) == self.k:
            return True
        else:
            return False
