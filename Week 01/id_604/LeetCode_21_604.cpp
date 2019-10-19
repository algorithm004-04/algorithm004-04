//21题　合并两个有序链表
using namespace std;


  struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
  };

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        //ListNode *phread = new ListNode(-1);//定义一个哨兵----使用该方法会存在内存泄露
        //ListNode *prev = phread;

        ListNode phread = ListNode(-1);  //  创建栈空间对象即可。
        ListNode* prev = &phread;   // 注意这里需要取地址&

         while(l1 != NULL && l2 != NULL){

             if(l1->val <= l2->val){
                 prev->next = l1;
                 l1 = l1->next;
             }
             else {

                 prev->next = l2;
                 l2 = l2->next;
             }

             prev = prev->next;

         }

         //为空的元素就不用管啦，要merge剩下的元素
         //if(l1 == NULL) {
         //    prev->next = l2;
         //}
         //else {
         //    prev->next = l1;
         //}

         prev->next = l1 == NULL ? l2:l1;

        return phread.next;

    }
};

