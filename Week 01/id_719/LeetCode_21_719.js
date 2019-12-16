// 迭代法

var mergeTwoLists = function(l1, l2) {
    const headNode = new ListNode("head");
    let current = headNode;
    while (l1 && l2) {
        if (l1.val > l2.val) {
            current.next = l2;
            l2 = l2.next;
        } else {
            current.next = l1;
            l1 = l1.next;
        }
        current = current.next;
    }
    current.next = l1 || l2;
    return headNode.next;
};


// 递归

var mergeTwoListsRecursion = function(l1, l2) {
    if(l1 === null){
        return l2;
    }
    if(l2 === null){
        return l1;
    }
    if(l1.val < l2.val){
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    }else{
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }
};