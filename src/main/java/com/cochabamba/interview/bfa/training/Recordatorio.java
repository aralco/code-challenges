package com.cochabamba.interview.bfa.training;

import org.junit.Assert;

import java.util.LinkedList;

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

        Assert.assertEquals("C", linkedList.get(2));
        System.out.println(linkedList.get(2));
        System.out.println("linkedList: "+linkedList);
        System.out.println("*****************************");

        linkedList.set(2, "shit");
        System.out.println("linkedList: "+linkedList);
        Assert.assertEquals("shit", linkedList.get(2));
        System.out.println(linkedList.get(2));
        System.out.println("*****************************");

        linkedList.add("Z");
        System.out.println("linkedList: "+linkedList);
        Assert.assertEquals("Z", linkedList.getLast());
        System.out.println("*****************************");

        String removedItem = linkedList.remove(2);
        System.out.println("linkedList: "+linkedList);
        Assert.assertEquals("shit", removedItem);
        System.out.println(removedItem);
        System.out.println("*****************************");
    }
}
