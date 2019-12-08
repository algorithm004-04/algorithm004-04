/**
     * 递归
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if ( l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return  l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
