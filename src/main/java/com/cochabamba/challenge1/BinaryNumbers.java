package com.cochabamba.challenge1;

import java.util.Scanner;

/**
 * @author aralco
 * Day 10: Binary Numbers
 */
public class BinaryNumbers {
    public static String toBinary(int nBase10)   {
        int base = 2;
        int div;
        int res;
        String nBase2="";
        do {
            div = nBase10 / base;
            res = nBase10 % base;
            nBase2=res+nBase2;
            nBase10 = div;
        } while(div>0);
        return nBase2;
    }

    public static int consecutiveOnes(String nBase2) {
        int onesCounter=0;
        int maxOnes=0;
        if(nBase2.contains("1"))    {
            for(int i=0;i<nBase2.length();i++)  {
                if(nBase2.charAt(i)=='1')    {
                    onesCounter++;
                    maxOnes=onesCounter>maxOnes?onesCounter:maxOnes;
                } else  {
                    onesCounter=0;
                }
            }
        }
        return  maxOnes;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        System.out.println(toBinary(n));
//        System.out.println(Integer.toBinaryString(n));
        System.out.println(consecutiveOnes(toBinary(n)));
    }
}
