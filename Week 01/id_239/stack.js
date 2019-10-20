/**
 *
 * 使用javascript数组来实现Stack
 *
 * 栈的特点：
 * 先进后出，插入和删除都只能在栈尾进行操作
 *
 *
 * 栈常见的几个操作：
 * push(); //从栈尾插入新元素
 * pop();  //从取出栈尾元素，并且删除它
 * peek(); //取出栈顶的元素，但不删除它
 * clear(); //清除栈内所有元素
 * length(); //获取栈内元素的个数
 * */


//1. 构造函数是版本

function Stack () {
    this.data = [];
    this.index = 0; //索引，记录当前实例的索引
    this.push = push;
    this.pop = pop;
    this.peek = peek;
    this.clear = clear;
    this.length = length;

    function push (element) {
        this.data[this.index++] = element;
    }
    function pop () {
        return this.data[--this.index];
    }
    function peek () {
        return this.data[this.index - 1];
    }
    function clear () {
        this.index = 0;
    }
    function length () {
        return this.index;
    }
}


let stack = new Stack();
stack.push('小明1');
stack.push('小明2');
stack.push('小明3');

console.log(stack.length()); //3

console.log(stack.pop()); //小明3

console.log(stack.length()); //2

console.log(stack.peek());// 小明2

console.log(stack.length()); // 2

stack.clear();

console.log(stack.length()); //0


