package com.cochabamba.others;

import java.util.Scanner;

public class Solution2 {

    static void sumArray(int array[])  {
        int arraySum=0;
        for(int i=0;i<array.length;i++)    {
            arraySum=arraySum+array[i];
        }
        System.out.println(arraySum);
    }

    /**
     *
     * This main method reads an array in one line e.g. 1 2 3 4
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int [] array = new int[n];
        String stringInput = in.nextLine();
        String [] arrayInput = stringInput.split("\\s+");
        for(int i=0;i<n;i++)    {
            array[i] = Integer.parseInt(arrayInput[i]);
        }
        sumArray(array);
    }

}
