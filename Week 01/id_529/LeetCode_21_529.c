#include <stdlib.h>
struct ListNode* mergeTwoLists(struct ListNode* l1, struct ListNode* l2){
    struct ListNode *head = (struct ListNode *)malloc(sizeof(struct ListNode));
    struct ListNode *ret = head;
    head->next = NULL;
    while (l1 != NULL && l2 != NULL) {
        if (l1->val < l2->val) {
            head->next = l1;
            head = l1;
            l1 = l1->next;
        } else {
            head->next = l2; 
            head = l2;
            l2 = l2->next;
        }
    }
    
    if (l1 != NULL) {
        head->next = l1;       
    } else {
        head->next = l2;
    }
    return ret->next;
}

