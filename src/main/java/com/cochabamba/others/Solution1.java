package com.cochabamba.others;

import java.util.Scanner;

public class Solution1 {

    static void sumArray(int array[])  {
        int arraySum=0;
        for(int i=0;i<array.length;i++)    {
            arraySum=arraySum+array[i];
        }
        System.out.println(arraySum);
    }

    /**
     *
     * This main method reads an array one item by line
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int [] array = new int[n];
        for(int i=0;i<n;i++)    {
            array[i] = Integer.parseInt(in.nextLine());
        }
        sumArray(array);
    }

}
