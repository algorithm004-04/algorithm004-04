/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(l1 == NULL) return l2;
        if(l2 == NULL) return l1;
        ListNode* pre = new ListNode(-1);
        ListNode* p = pre;
        while(l1 != NULL && l2 != NULL){
            if(l1->val < l2->val){
                p->next = l1;
                l1 = l1->next;
            }
            else{
                p->next = l2;
                l2 = l2->next;
            }
            p = p->next;
        }
        p->next = l1 !=NULL ? l1 : l2;
        return pre->next;
    }
};
//�ϲ�������������  ListNode* p1 = l1;
        
   /*     if(l1 != NULL){
            while( l1 != NULL){
                pre -> next = l1;
                l1 = l1 ->next;
                pre = pre ->next;
            }
        }
        if(l2 != NULL){
            while( l2 != NULL){
                pre ->next = l2;
                l2 = l2 -> next;
                pre = pre ->next;
            }
            
        }
        pre ->next = NULL;  */
//�ȼ���
  // pre ->next = l1 != NULL ? l1 : l2;   
