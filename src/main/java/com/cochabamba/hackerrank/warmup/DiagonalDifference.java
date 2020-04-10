package com.cochabamba.hackerrank.warmup;

import java.util.Scanner;

public class DiagonalDifference {

    static void diagonalDifference(int matrix[][])  {
        int diagonal1=0;
        int diagonal2=0;
        for (int i=0;i<matrix.length;i++)   {
            for(int j=i;j<matrix[i].length;j=matrix[i].length) {
                diagonal1=diagonal1+matrix[i][j];
            }
        }
        for (int i=0;i<matrix.length;i++)   {
            for(int j=(matrix[i].length-1)-i;j<matrix[i].length;j=matrix[i].length) {
                diagonal2=diagonal2+matrix[i][j];
            }
        }
        System.out.println(Math.abs(diagonal1-diagonal2));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int [][] matrix = new int[n][n];
        for(int line=0;line<n;line++)   {
            String stringInput = in.nextLine();
            String [] arrayInput = stringInput.split("\\s+");
            for(int i=0;i<n;i++)    {
                matrix[line][i] = Integer.parseInt(arrayInput[i]);
            }
        }
        diagonalDifference(matrix);
    }

}
