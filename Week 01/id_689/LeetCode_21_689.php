<?php
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function mergeTwoLists($l1, $l2) {
        $preHead = new ListNode(-1);
        $pre = $preHead;
        while ($l1 && $l2) {
            if ($l1 < $l2) {
                $pre->next = $l1;
                $l1 = $l1->next;
            } else {
                $pre->next = $l2;
                $l2 = $l2->next;
            }

            $pre = $pre->next;
        }

        $pre->next = $l1 ? $l1 : $l2;

        return $preHead->next;
    }
}