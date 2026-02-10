package org.example;

//Write a body for the following method:

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//that will check if there is a cycle and return such information.
//
//Assuming the elements in the list unique:
//A -> B -> C -> D -> null - doesn't have a cycle
//A -> B -> C -> D -> A - do have a cycle
public class Node {
    private final int value;
    private Node next;

    public Node(final int value) {
        this(value, null);
    }

    public Node(final int value, final Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static boolean containsLoopWithoutCheckingHashCode(Node node) {

        Node currentNode = node;
        List<Node> nodes = new ArrayList<>();
        while (currentNode.getNext()!=null){
            for (Node node1 : nodes) {
                if (node1==currentNode){
                    return true;
                }
            }
            nodes.add(currentNode);
            currentNode = currentNode.getNext();
        }
        return false;
    }
    public static boolean containsLoop(Node node) {

        Node currentNode = node;
        Set<Node> nodes = new HashSet<>();
        while (currentNode.getNext()!=null){
                if (nodes.contains(currentNode)){
                    return true;
                }
            nodes.add(currentNode);
            currentNode = currentNode.getNext();
        }
        return false;
    }
}
