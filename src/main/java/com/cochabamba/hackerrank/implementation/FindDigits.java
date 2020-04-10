package com.cochabamba.hackerrank.implementation;

import java.util.Scanner;

public class FindDigits {
    public static long findDigit(long n)    {
        int count=0;
        long pivot=n;
        long digit;
        String container="";
        while(pivot>0)  {
            digit=pivot%10;
            if(digit>0 && n%digit==0)  {
                if(!container.contains(String.valueOf(digit)))  {
                    container=container+digit;
                }
                count++;
            }
            pivot=pivot/10;
        }
        return count;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long[] n = new long[t];
        for(int i=0;i<t;i++)    {
            n[i] = scanner.nextInt();
        }
        for (long aN : n) {
            System.out.println((findDigit(aN)));
        }
    }

}
