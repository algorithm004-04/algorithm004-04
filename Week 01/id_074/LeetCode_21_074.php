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
        
        $p = $l1;
        $q = $l2;
        data = array(); while(data=array();while(p != null) {
        $data[] = $p->val;
        $p = $p->next;
        }
        
            while($q != null) {
                $data[] = $q->val;
                $q = $q->next;
            }
            $heard = null;
            if ($data) {
                rsort($data);
                foreach ($data as $v) {
                    if ($heard == null) {
                        $heard = new ListNode($v);
                    } else {
                        $new = new ListNode($v);
                        $new->next = $heard;
                        $heard = $new;
                    }
                }
            }
           
            return $heard;
        }
        

}