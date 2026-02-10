package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeTest {

    @Test
    public void shouldReturnFalse(){
        final Node listNode = new Node(2, new Node(4, new Node(3)));

        assertFalse(Node.containsLoop(listNode));
    }
    @Test
    public void shouldReturnTrue(){
        final Node listNode = new Node(3);
        final Node listNode2 = new Node(3);
        listNode.setNext(listNode2);
        listNode2.setNext(listNode);

        assertTrue(Node.containsLoop(listNode));
    }
}