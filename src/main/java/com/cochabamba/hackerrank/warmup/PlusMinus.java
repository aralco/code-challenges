package com.cochabamba.hackerrank.warmup;

import java.math.BigDecimal;
        import java.math.MathContext;
        import java.text.DecimalFormat;
        import java.util.Scanner;

public class PlusMinus {

    static void plusMinus(int array[])  {
        DecimalFormat df = new DecimalFormat("#.0000");

        BigDecimal result;
        double posSum = 0;
        double neutralSum=0;
        double negSum=0;

        for(int i=0;i<array.length;i++)    {
            if(array[i]>0) {
                posSum++;
            } else if(array[i]==0)  {
                neutralSum++;
            } else  {
                negSum++;
            }
        }
        result = new BigDecimal(posSum/array.length);
        System.out.println(df.format(result));

        result = new BigDecimal(negSum/array.length, new MathContext(5));
        System.out.println(df.format(result));

        result = new BigDecimal(neutralSum/array.length, new MathContext(5));
        System.out.println(df.format(result));

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
        plusMinus(array);
    }
}
