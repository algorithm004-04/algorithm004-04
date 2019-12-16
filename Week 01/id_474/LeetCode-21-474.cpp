
/**
* Definition for singly-linked list.
* struct ListNode {
*     int val;
*     ListNode *next;
*     ListNode(int x) : val(x), next(NULL) {}
* };
*/

/*
    方法一： 递归

    时间复杂度：O(n) 空间复杂度：O(n)
*/

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if (NULL == l1) {
            return l2;
        }
        else if (NULL == l2) {
            return l1;
        }
        else if (l1->val < l2->val) {
            l1->next = mergeTwoLists(l1->next, l2);
            return l1;
        }
        else {
            l2->next = mergeTwoLists(l1, l2->next);
            return l2;
        }        
    }
};
/*
	方法二：迭代

    时间复杂度：O(n) 空间复杂度：O(1)
*/

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* preHead = new ListNode(-1);
        ListNode* pre = preHead;

        while (NULL != l1 && NULL != l2){
            if (l1->val <= l2->val) {
                pre->next = l1;
                l1 = l1->next;
            }
            else {
                pre->next = l2;
                l2 = l2->next;
            }

            pre = pre->next;
        }

        pre->next = NULL == l1 ? l2 : l1;

        return preHead->next;
    }
};  