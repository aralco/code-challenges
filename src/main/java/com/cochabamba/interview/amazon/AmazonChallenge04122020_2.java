package com.cochabamba.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ariel.alcocer
 */
public class AmazonChallenge04122020_2 {

    public static void main(String[] args) {
        AmazonChallenge04122020_2 test1 = new AmazonChallenge04122020_2();
        List<Integer> result1 = test1.lengthEachScene(Arrays.asList('a', 'b', 'c'));
        System.out.println(result1);

        AmazonChallenge04122020_2 test2 = new AmazonChallenge04122020_2();
        List<Integer> result2 = test2.lengthEachScene(Arrays.asList('a', 'b', 'c', 'a'));
        System.out.println(result2);

        AmazonChallenge04122020_2 test3 = new AmazonChallenge04122020_2();
        List<Integer> result3 = test3.lengthEachScene(Arrays.asList(
                'a', 'b', 'a','b', 'c', 'b','a', 'c', 'a','d', 'e', 'f',
                'e', 'g', 'd','e', 'h', 'i','j', 'h', 'k','l', 'i', 'j'));
        System.out.println(result3);

        AmazonChallenge04122020_2 test4 = new AmazonChallenge04122020_2();
        List<Integer> result4 = test4.lengthEachScene(Arrays.asList('a', 'b', 'c', 'd','a', 'e', 'f', 'g','h', 'i', 'j', 'e'));
        System.out.println(result4);

        AmazonChallenge04122020_2 test5 = new AmazonChallenge04122020_2();
        List<Integer> result5 = test5.lengthEachScene(Arrays.asList('a', 'b', 'c', 'a'));
        System.out.println(result5);

    }

    List<Integer> lengthEachScene(List<Character> inputList)    {
        ArrayList<Integer> result = new ArrayList<>();

        return result;
    }
}
