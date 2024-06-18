package com.cochabamba.geeksforgeeks;

import java.util.Scanner;

/**
 * @author ariel.alcocer
 */
public class FindingMiddleElementInLinkedList {
    public static void main(String[] args)  {
        //Read input data
        Scanner scanner = new Scanner(System.in);
        int testCasesNumber = scanner.nextInt();
        for(int t=0;t<testCasesNumber;t++)   {
            int n = scanner.nextInt();
            LinkedList list = new LinkedList();
            for(int i=0;i<n;i++)  {
                list.addToTheLast(new Node(scanner.nextInt()));
            }
            FindingMiddleElementInLinkedList middle = new FindingMiddleElementInLinkedList();
//            System.out.println(middle.getMiddle(list.head));
            System.out.println(middle.getMiddleOptimus(list.head));
        }
    }

    //// Function to find middle element a linked list
    int getMiddleOptimus(Node head)
    {
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    int getMiddle(Node head) {
        int size = 0;
        if(head!=null)
            size++;
        Node pivot = head;

        while(pivot.next!=null) {
            pivot = pivot.next;
            size++;
        }
        Node tmp = head;
        for(int i=0;i<size/2;i++)   {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    static class Node {
        int data;
        Node next;
        Node(int d)  {
            data = d;
            next = null;
        }
    }

    static class LinkedList {
        Node head;  // head of list
        public void addToTheLast(Node node) {
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
        }
    }
}


