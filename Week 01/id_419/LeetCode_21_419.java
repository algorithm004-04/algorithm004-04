import java.util.ArrayList;
import java.util.List;

/**
 * Created by ybh on 2019/10/21.
 *
 * 21. 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode_21_419 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        List<ListNode> temp = new ArrayList<>();

        while (l1!=null && l2!=null){
            if(l1.val < l2.val){
                temp.add(l1);
                l1 = l1.next;
            }else {
                temp.add(l2);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            temp.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            temp.add(l2);
            l2 = l2.next;
        }

        for(int i=0;i<temp.size()-1;i++){
            temp.get(i).next = temp.get(i+1);
        }

        return temp.size()>0 ? temp.get(0) : null;

    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
