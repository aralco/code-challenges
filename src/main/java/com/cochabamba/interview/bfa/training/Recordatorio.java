package com.cochabamba.interview.bfa.training;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Recordatorio {
    public static void main(String[] args)   {
        LinkedList<String> linkedList = new LinkedList();
        System.out.println("linkedList: "+linkedList);
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println("linkedList: "+linkedList);
        System.out.println("*****************************");

        assertEquals("C", linkedList.get(2));
        System.out.println(linkedList.get(2));
        System.out.println("linkedList: "+linkedList);
        System.out.println("*****************************");

        linkedList.set(2, "shit");
        System.out.println("linkedList: "+linkedList);
        assertEquals("shit", linkedList.get(2));
        System.out.println(linkedList.get(2));
        System.out.println("*****************************");

        linkedList.add("Z");
        System.out.println("linkedList: "+linkedList);
        assertEquals("Z", linkedList.getLast());
        System.out.println("*****************************");

        String removedItem = linkedList.remove(2);
        System.out.println("linkedList: "+linkedList);
        assertEquals("shit", removedItem);
        System.out.println(removedItem);
        System.out.println("*****************************");
    }
}
