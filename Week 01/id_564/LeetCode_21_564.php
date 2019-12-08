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
        $newNode = new ListNode(0);
        $currentNode = $newNode;

        while ($l1 != null && $l2 != null) {
            if ($l1->val <= $l2->val) {
                $currentNode->next = $l1;
                $l1 = $l1->next;
            } else {
                $currentNode->next = $l2;
                $l2 = $l2->next;
            }
            $currentNode = $currentNode->next;
        }
        $currentNode->next = $l1 == null ? $l2 : $l1;

        return $newNode->next;
    } 

    function mergeTwoLists1($l1, $l2) {
        if ($l1 == NULL) {
            return $l2;
        }
        if ($l2 == NULL) {
            return $l1;
        }

        if ($l1->val < $l2->val) {
            $l1->next = $this->mergeTwoLists($l1->next, $l2);
            return $l1;
        } else {
            $l2->next = $this->mergeTwoLists($l1, $l2->next);
            return $l2;
        } 
    }
}

?>


