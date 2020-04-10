package com.cochabamba.hackerrank.warmup;

import java.util.Scanner;

public class Staircase {

    static void stairCase(int n)  {
        for(int i=1;i<=n;i++)    {
            StringBuilder row = new StringBuilder();
            for(int k=n-i;k>0;k--)    {
                row.append(" ");
            }for(int j=1;j<=i;j++)    {
                row.append("#");
            }
            System.out.println(row);
        }

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        stairCase(n);
    }
}
