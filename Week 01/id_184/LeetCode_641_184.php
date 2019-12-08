<?php
/*
 * @lc app=leetcode.cn id=641 lang=php
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {

    public $_size = 0;

    /**
     * 表长
     */
    public $_length = 0;

    public $_array;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     * @param Integer $k
     */
    function __construct($k) {
        $this -> _length = $k; //表长
        $this -> _size   = 0;
        $this -> _array  = array();
    }
  
    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertFront($value) {
        if ($this -> isFull()) {
            return false;
        }

        array_unshift($this -> _array, $value);
        $this -> _size ++;
        return true;
    }
  
    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     * @param Integer $value
     * @return Boolean
     */
    function insertLast($value) {
        if ($this -> isFull()) {
            return false;
        }
        array_push($this -> _array, $value);
        $this -> _size ++;
        return true;
    }
  
    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteFront() {
        if ($this -> isEmpty()) {
            return false;
        }

        array_shift($this -> _array);
        $this -> _size --;
        return true;
    }
  
    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     * @return Boolean
     */
    function deleteLast() {
        if ($this -> isEmpty()) {
            return false;
        }
        array_pop($this -> _array);
        $this -> _size --;
        return true;
    }
  
    /**
     * Get the front item from the deque.
     * @return Integer
     */
    function getFront() {
        if (!$this -> _array) {
            return -1;
        }

        return $this -> _array[0];
    }
  
    /**
     * Get the last item from the deque.
     * @return Integer
     */
    function getRear() {
        if (!$this -> _array) {
            return -1;
        }

        return $this -> _array[$this -> _size - 1];
    }
  
    /**
     * Checks whether the circular deque is empty or not.
     * @return Boolean
     */
    function isEmpty() {
        if ($this -> _size == 0) {
            return true;
        }

        return false;
    }
  
    /**
     * Checks whether the circular deque is full or not.
     * @return Boolean
     */
    function isFull() {
        if ($this -> _size == $this -> _length) {
            return true;
        }
        return false;
    }

    function loopArr()
    {
        if ($this -> isEmpty()) {
            return -2;
        }

        return implode('-', $this -> _array);
    }
}

$obj = new MyCircularDeque(5);

echo $obj -> loopArr();
echo "\n";

$ret_1 = $obj->insertFront(4);
$ret_1 = $obj->insertFront(3);
$ret_1 = $obj->insertFront(2);

$obj -> insertLast(77);
$obj -> insertLast(77);

//$obj -> insertLast(77);
echo $obj -> loopArr();
echo "\n";

$obj -> deleteFront();
$obj -> deleteLast();

echo $obj -> loopArr();
echo "\n";


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * $obj = MyCircularDeque($k);
 * $ret_1 = $obj->insertFront($value);
 * $ret_2 = $obj->insertLast($value);
 * $ret_3 = $obj->deleteFront();
 * $ret_4 = $obj->deleteLast();
 * $ret_5 = $obj->getFront();
 * $ret_6 = $obj->getRear();
 * $ret_7 = $obj->isEmpty();
 * $ret_8 = $obj->isFull();
 */
// @lc code=end

