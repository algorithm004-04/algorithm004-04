/**
 * 使用javascript数组模拟 队列的实现
 *
 * 队列的特点：
 * 先进先出，插入只能在对尾进行操作，删除只能在对首进行操作
 *
 * 队列常见的几个操作：
 * enqueue(); //向对尾插入一个新元素
 * dequeue(); //删除对首的元素
 * first(); // 获取对首的元素
 * end(); //获取对尾的元素
 *  toString(); //显示对内所有元素
 *  empty(); //队列是否为空
 * */


function Queen () {
    this.data = [];
    this.enqueue = enqueue;
    this.dequeue = dequeue;
    this.first = first;
    this.end = end;
    this.toString = toString;
    this.isEmpty = isEmpty;

    function enqueue (x) {
        this.data.push(x);
    }
    function dequeue () {
        return this.data.pop();
    }
    function first () {
        return this.data[0];
    }
    function end () {
        return this.data[this.data.length - 1];
    }
    function toString () {
        return this.data.join('\n');
    }
    function isEmpty () {
        return this.data.length === 0;
    }
}


/**
 *
 * 双端队列：double-end queen , 即栈和队列的结合，既可以在头部插入，也可以删除，同时，既可以在尾部插入，也可以删除
 * addFront(); //头部插入元素
 * addEnd(); //尾部插入元素
 * removeFront(); //删除头部元素
 * removeEnd(); //删除尾部元素
 * peekFront(); //查看头部元素
 * peekEnd(); //查看尾部元素
 * toString(); //
 * isEmpty(); //查看是否为空
 * clear(); //清除队列
 * */

function Deque () {
    this.data = [];
    this.addFront = addFront;
    this.addEnd = addEnd;
    this.removeFront = removeFront;
    this.removeEnd = removeEnd;
    this.peekFront = peekFront;
    this.peekEnd = peekEnd;
    this.toString = toString;
    this.isEmpty = isEmpty;
    this.clear = clear;

    function addFront (x) {
        this.data.unshift(x);
    }
    function addEnd (x) {
        this.data.push(x);
    }
    function removeFront () {
        return this.data.shift();
    }
    function removeEnd () {
        return this.data.pop();
    }
    function peekFront () {
        return this.data[0];
    }
    function peekEnd () {
        return this.data[this.data.length - 1];
    }
    function toString () {
        return this.data.join('\n');
    }
    function isEmpty () {
        return this.data.length === 0;
    }
    function clear () {
        this.data = [];
    }
}
