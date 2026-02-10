//You are given the heads of two sorted linked lists list1 and list2.
//
//Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//Return the head of the merged linked list.
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
public class Main {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode tmp = mergedList;
        boolean beg = true;
        while ( list1 != null && list2 != null  ){
            if(!beg){
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
            beg = false;
            if(  list1.val > list2.val){
                tmp.val = list2.val;


                list2 = list2.next;
            }
            else{
                tmp.val = list1.val;

                list1 = list1.next;
            }
        }
        while ( list2 != null ) {
            tmp.next = new ListNode();
            tmp = tmp.next;
            tmp.val =list2.val ;

            list2 = list2.next;

        }
        while ( list1 != null ) {
            tmp.next = new ListNode();
            tmp = tmp.next;
            tmp.val = list1.val ;

            list1 = list1.next;
        }
        return mergedList;
    }

    public static void main( String[] args ) {
        ListNode listNode1 = new ListNode( 1, new ListNode( 2, new ListNode( 4 ) ) );
        ListNode listNode2 = new ListNode( 1, new ListNode( 3, new ListNode( 4 ) ) );
        ListNode result = mergeTwoLists(listNode1,listNode2);
        System.out.println(result);
    }
}
