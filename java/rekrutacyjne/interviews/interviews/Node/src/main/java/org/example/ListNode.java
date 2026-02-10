package org.example;

import java.util.Optional;

public class ListNode {
    private final int val;
     ListNode next;

     ListNode(final int val) {
        this(val, null);
    }

     ListNode(final int val, final ListNode next) {
        this.val = val;
        this.next = next;
    }

     int getVal() {
        return val;
    }
     static ListNode addNumbers(final ListNode listNode1, final ListNode listNode2) {
        ListNode walking1 = listNode1;
        ListNode walking2 = listNode2;
        ListNode result = null;
        ListNode walkingResult = null;
        int pos2 = 0;
        while (walking1 != null || walking2 != null) {
            final int walkingValue1 = Optional.ofNullable(walking1).map(ListNode::getVal).orElse(0);
            final int walkingValue2 = Optional.ofNullable(walking2).map(ListNode::getVal).orElse(0);
            final int i = walkingValue1 + walkingValue2 + pos2;
            final int pos1 = i % 10;
            pos2 = i / 10;
            if (result == null) {
                result = walkingResult = new ListNode(pos1);
            } else {
                walkingResult.next = new ListNode(pos1);
                walkingResult = walkingResult.next;
            }
            if (walking1 != null) {
                walking1 = walking1.next;
            }
            if (walking2 != null) {
                walking2 = walking2.next;
            }
        }
        walkingResult.next = pos2 == 0 ? walkingResult.next : new ListNode(pos2);
        return result;
    }
}