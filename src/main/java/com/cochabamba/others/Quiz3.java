package com.cochabamba.others;

import java.util.stream.IntStream;

public class Quiz3 {
    public static void main(String[] args) {
        char[] chars = new char[]{'\u0097'};
        System.out.println(chars);
        String str = new String(chars);
        System.out.println(str);
        byte[] bytes = str.getBytes();
        System.out.println(bytes[0]);
        System.out.println(bytes[1]);
        System.out.println(bytes.length);
    }
}
