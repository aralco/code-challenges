package com.cochabamba.geeksforgeeks.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountNodesOfLinkedList {
    //Function to count nodes of a linked list.
    public static int getCount(Node head)   {
        if(head==null)
            return 0;
        return 1 + getCount(head.next);
    }

    public static void printNodes(Node head)   {
        if(head==null) {
            return;
        }
        System.out.print(head.data+" ");
        printNodes(head.next);
    }

    public static void main(String[] args) {
        Node node0 = null;
        assertEquals(0, getCount(node0));
        printNodes(node0);
        System.out.println("\n *********");

        Node node1 = new Node(1);
        assertEquals(1, getCount(node1));
        printNodes(node1);
        System.out.println("\n *********");

        Node node2 = new Node(2);
        node1.next=node2;
        assertEquals(2, getCount(node1));
        printNodes(node1);
        System.out.println("\n *********");

        Node node3 = new Node(3);
        node2.next=node3;
        assertEquals(3, getCount(node1));
        printNodes(node1);
    }
}

class Node{
    int data;
    Node next;
    Node(int a){
        data = a;
        next = null;
    }
}
