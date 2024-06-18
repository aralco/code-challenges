package com.cochabamba.interview.deviget.official;

import java.util.Arrays;
import java.util.Collections;

public class Test {
    public static void main(String[] args)  {
        String[] strings = new String[] {"abD", "aB", "ABC", "cDe", "CDd"};
        //Collections.sort(strings, String::compareTo);
        Collections.sort(Arrays.asList(strings), String::compareToIgnoreCase);
        for (String s:strings) {
            System.out.println(s);
        }
    }
}
