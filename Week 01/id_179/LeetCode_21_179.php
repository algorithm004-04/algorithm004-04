<?php

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution
{

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    public function mergeTwoLists($l1, $l2)
    {
        if (empty($l1)) {
            return $l2;
        } elseif (empty($l2)) {
            return $l1;
        } elseif (empty($l1) && empty($l2)) {
            return null;
        } elseif ($l1->val > $l2->val) {
            $l2->next = self::mergeTwoLists($l1, $l2->next);
            return $l2;
        } else {
            $l1->next = self::mergeTwoLists($l1->next, $l2);
            return $l1;
        }
    }
}
