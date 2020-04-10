package com.cochabamba.hackerrank.warmup;

import java.util.Scanner;

public class ASimpleArraySum {

    static void sumArray(int array[])  {
        int arraySum=0;
        for(int i=0;i<array.length;i++)    {
            arraySum=arraySum+array[i];
        }
        System.out.println(arraySum);
    }

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

