package com.cochabamba.others;

import java.util.Scanner;

/**
 * @author ariel.alcocer
 */
public class Palindrome {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        System.out.println(word+", Is Palindrome:"+isPalindrome(word));
    }

    public static boolean isPalindrome(String word)    {
        StringBuilder stringBuilder = new StringBuilder(word);
        System.out.println("BEFORE:"+stringBuilder.toString());
        stringBuilder.reverse();
        System.out.println("AFTER:"+stringBuilder.toString());
        return stringBuilder.toString().equals(word);
    }
}
