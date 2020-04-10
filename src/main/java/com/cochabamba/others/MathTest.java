package com.cochabamba.others;

/**
 * Created by aralco on 10/2/15.
 */
public class MathTest {
    public static void main(String args[])  {
        int a = Integer.parseInt("10");
        int aC = Integer.valueOf("10");
        Integer b = Integer.parseInt("10");
        float c = Float.parseFloat("10");
        Float d = Float.parseFloat("10.00");
        Integer e = 10;
        int f = e+5;
        e=f;
        System.out.println("Number (int) is:"+a);
        System.out.println("Number (int) is:"+aC);
        System.out.println("Number (Integer) is:"+b);
        System.out.println("Number (float) is:"+c);
        System.out.println("Number (Float) is:"+d);
        System.out.println("Number (Integer) is:"+e);
        System.out.println("Number (int) is:"+f);
        System.out.println("Number (Integer) is fixed:"+e);
        System.out.println("Number (int) is fixed:"+f);
    }
}
