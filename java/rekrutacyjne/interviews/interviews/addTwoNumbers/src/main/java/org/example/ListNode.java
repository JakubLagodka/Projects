package org.example;

public class ListNode {
    final int val;
    ListNode next;

    ListNode(int value) {
        this(value, null);
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}