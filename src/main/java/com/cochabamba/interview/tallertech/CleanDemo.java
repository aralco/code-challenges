package com.cochabamba.interview.tallertech;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CleanDemo {

    public static void main(String[] args) {
        System.out.println("hola");
        char[] string1 = new char[]{'a','b','c'};
        System.out.println(string1);
        System.out.println(string1[0]-'a');
        System.out.println(string1[0]-'b');
        System.out.println(string1[0]-'c');
        System.out.println(string1[0]-'d');

    }

    @Test
    public void test(){
        assertTrue(true);
    }
}
