package org.example;

public class Main {
//    You are given two non-empty linked lists representing two non-negative integers.
//    The digits are stored in reverse order, and each of their nodes contains a single digit.
//    Add the two numbers and return the sum as a linked list.
//    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//            Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: (7 -> 0 -> 8)
//342 + 465 = 807
    public static ListNode addTwoNumbersLeetCode(ListNode l1, ListNode l2) {
        if(l1.val==0 && l1.next == null){
            return l2;
        }
        boolean isNew = true;
        ListNode output = null;
        ListNode tmp = null;
        int nextValue = 0;
        int sum = 0;
        while (l1.val != 0 || l1.next != null || l2.next != null|| l2.val != 0) {
            sum = nextValue;
            sum += l1.val + l2.val;
            nextValue = 0;
            if (sum >= 10) {
                nextValue += 1;
                sum -= 10;
            }
            if(isNew) {
                if(nextValue==0){
                    output = tmp = new ListNode(sum);
                }else {
                    output = tmp = new ListNode(sum,new ListNode(nextValue));
                }
            } else {
                if(nextValue==0){
                    tmp.next = new ListNode(sum);
                }else {
                    tmp.next = new ListNode(sum,new ListNode(nextValue));
                }
                tmp = tmp.next;
            }
            if(l1.next == null){
                l1.next = new ListNode(0);
            }
            l1 = l1.next;
            if(l2.next == null){
                l2.next = new ListNode(0);
            }
            l2 = l2.next;
            isNew = false;
        }

        return output;
    }
    public static void main(String[] args) {
        addTwoNumbersLeetCode(new ListNode(2,new ListNode(4,new ListNode(3))),new ListNode(5,new ListNode(6,new ListNode(4))));
    }
}