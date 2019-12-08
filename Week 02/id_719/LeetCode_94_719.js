/**
 * 
递归
    思路
        递归方法求解
    伪代码
        set a new array result
        traverse the tree and put every node into the result
        return result

        traverse the tree（利用递归模板）
 *
 */

var inorderTraversalNode = (node, callback) => {
    //recursion terminator
    if (node == null) {
        return;
    }
    //process login in current level
    let left_node = node.left;
    let right_node = node.right;
    //drill down
    inorderTraversalNode(left_node, callback);
    callback(node);    // this callback(node) is current level
    inorderTraversalNode(right_node, callback);
    //reverse the current level state
};

var inorderTraversal = function(root) {
    let result = [];
    inorderTraversalNode(root, node => {
        result.push(node.val);
    });
    return result;
};


/**
 *        
 * 虽然思路挺容易懂的，但看栈遍历的方法，通过代码debug一步一步才看懂：
                    1
                  4   2
                     3
    按[1, 4, 2, 3]举例
    先将root和其所有左节点加入stack中
    拿出栈顶节点
    value --> 4 加入result中
    current --> 右节点 --> null
    遍历下一层，因为栈里面还有节点，所有继续遍历
    current 因为是null,所有拿出栈顶节点
    value --> 1 加入 result 中
    current --> 右节点 --> 2
    current != null --> 2 加入栈， 2 的所有左节点加入栈
    3 --> 在栈顶
    current --> 3 --> result push
    right == null
      
总结：
    拿到一个节点，把所有左节点加入栈中
    最左的节点的value加入result
    它的根节点的value加入result
    根节点有右节点，拿到右节点，再所有加入到栈中，依次继续循环。
 */

/**
 * 伪代码：
    退出： current == null && stack.length == 0
    当前循环： 
        current != null
            将current 的所有左节点加入栈

        current 变栈顶
        result 加入current.val 
        current = current.right

    下一循环：
        跟上面循环一样

 * 
 */
 
var inorderTraversal = function(root) {
    var result = [];
    var tmpStack = [];
    var currNode = root;
    while (currNode != null || tmpStack.length != 0) {
        while (currNode != null) {
            tmpStack.push(currNode);
            currNode = currNode.left;
        }
        currNode = tmpStack.pop();
        result.push(currNode.val);
        currNode = currNode.right;
    }
    return result;
}



