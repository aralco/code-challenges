package com.cochabamba.arrays;

import java.util.Scanner;

/**
 * @author aralco
 */

public class ArraysDS {

    /**
     *
     * This main method reads an array in one line e.g. 1 2 3 4 and prints in reverse order
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int [] array = new int[n];
        String stringInput = in.nextLine();
        String [] arrayInput = stringInput.split("\\s+");
        int k=0;
        for(int i=n-1;i>=0;i--)    {
            array[k] = Integer.parseInt(arrayInput[i]);
            System.out.print(array[k]+" ");
            k++;
        }
    }

}

