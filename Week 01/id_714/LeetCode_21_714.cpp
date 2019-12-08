// https://leetcode-cn.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution
{
public:
  ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
  {
    if (l1 == NULL)
    {
      return l2;
    }
    if (l2 == NULL)
    {
      return l1;
    }
    ListNode *new_list = NULL, *current_node = NULL;
    while (l1 != NULL && l2 != NULL)
    {
      if (l1->val < l2->val)
      {
        if (new_list == NULL)
        {
          new_list = l1;
          current_node = new_list;
        }
        else
        {
          current_node->next = l1;
          current_node = current_node->next;
        }
        l1 = l1->next;
      }
      else
      {
        if (new_list == NULL)
        {
          new_list = l2;
          current_node = new_list;
        }
        else
        {
          current_node->next = l2;
          current_node = current_node->next;
        }
        l2 = l2->next;
      }
    }
    current_node->next = l1 ? l1 : l2;
    return new_list;
  }
};