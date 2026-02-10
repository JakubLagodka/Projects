package org.example;

import org.example.ListNode;
import org.jetbrains.annotations.NotNull;


import org.example.ListNode;
import org.jetbrains.annotations.NotNull;//Add Two Numbers

import java.util.Optional;

import static org.example.ListNode.addNumbers;
//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order, and each of their nodes contains a single digit.
//Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//        Input: (2->4->3)+(5->6->4)
//Output: (7->0->8)



public class Main {
    public static void main(@NotNull final String[] args) {
        final ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        final ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

// (2->4->3)+(6->4->0)

        final ListNode result1 = addNumbers(listNode1, listNode2);
        ListNode walking = result1;
        while (walking != null) {
            System.out.printf("%d->", walking.getVal());
            walking = walking.next;
        }
        System.out.println();
        final ListNode result2 = addNumbers(new ListNode(2, new ListNode(4)), new ListNode(5, new ListNode(6)));
         walking = result2;
        while (walking != null) {
            System.out.printf("%d->", walking.getVal());
            walking = walking.next;
        }
    }
}