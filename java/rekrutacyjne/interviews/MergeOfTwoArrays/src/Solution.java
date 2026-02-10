/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode tmp = mergedList;
        boolean beg = true;
        while(list1 != null && list2 != null){
            if(!beg){
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
            beg = false;
            if(list1.val > list2.val){
                tmp.val = list2.val;
                list2 = list2.next;
            }
            else{
                tmp.val = list1.val;
                list1 = list1.next;
            }
        }
        while(list2!=null){
            if(!beg){
                tmp.next = new ListNode();
                tmp=tmp.next;
            }

            tmp.val=list2.val;
            list2 = list2.next;
            beg = false;
        }
        while(list1!=null){
            if(!beg){
                tmp.next = new ListNode();
                tmp=tmp.next;
            }
            tmp.val=list1.val;
            list1 = list1.next;
            beg = false;
        }
        if(beg){
            return null;
        }
        return mergedList;
    }
}