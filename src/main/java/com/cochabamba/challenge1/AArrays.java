package com.cochabamba.challenge1;

import java.util.Scanner;

/**
 * @author aralco
 * Day 7: Arrays
 */

public class AArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
        }
        for(int j=arr.length-1;j>=0;j--)    {
            System.out.print(arr[j]+" ");
        }
        in.close();
    }
}
