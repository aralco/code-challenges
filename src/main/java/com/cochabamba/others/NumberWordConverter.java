package com.cochabamba.others;

/**
 * Created by aralco on 10/27/15.
 */
public class NumberWordConverter {

    private static final String[] specialNames = {
            "", " thousand", " million", " billion", " trillion", " quadrillion", " quintillion"};

    private static final String[] tensNames = {
            ""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety" };

    private static final String[] numNames = {
            "", " one", " two", " three", " four"," five", " six"," seven"," eight",     " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen"," nineteen"   };

    private static String shortNumbers(int number) {
        String current;
        if (number % 100 < 20){
            current = numNames[number % 100];
            number /= 100;
        }
        else {
            current = numNames[number % 10];
            number /= 10;

            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " hundred" + current;
    }

    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }
        String prefix = "";
        String word = "";
        int pos = 0;

        do {
            int n = number % 1000;
            if (n != 0){
                String s = shortNumbers(n);
                word = s + specialNames[pos] + word;
            }
            pos++;
            number /= 1000;
        } while (number > 0);
        return (prefix + word).trim();
    }

    public static void main(String arg[])   {
        System.out.println(convert(0));
        System.out.println(convert(1));
        System.out.println(convert(10));
        System.out.println(convert(100));
        System.out.println(convert(1000));
        System.out.println(convert(10000));
        System.out.println(convert(100000));
        System.out.println(convert(1000000));
    }


}
