package com.cochabamba.hackerrank.implementation;

import java.math.BigInteger;
import java.util.Scanner;

public class SherlockAndTheBeast {

    public static BigInteger findDecentNumber(int n) {
        BigInteger isDecent=BigInteger.ZERO;
        int fiveCount=n;
        int threeCount=0;

        while (isDecent.equals(BigInteger.ZERO)) {
            if(fiveCount%3==0 && threeCount%5==0)   {
                isDecent=generateDecentNumber(fiveCount, threeCount);
            }
            fiveCount--;
            threeCount++;
            if(threeCount>n && isDecent.equals(BigInteger.ZERO))    {
                isDecent=BigInteger.valueOf(-1);
            }
        }
        return isDecent;
    }

    public static BigInteger generateDecentNumber(int fives, int threes)    {
        StringBuilder decentNumber = new StringBuilder();
        for(int i=0;i<fives;i++)   {
            decentNumber.append("5");
        }
        for(int i=0;i<threes;i++)   {
            decentNumber.append("3");
        }
        return new BigInteger(decentNumber.toString());
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int[] n = new int[t];
        for(int i=0;i<t;i++)    {
            n[i] = scanner.nextInt();
        }
        for (int aN : n) {
            System.out.println(findDecentNumber(aN));
        }
    }
}
