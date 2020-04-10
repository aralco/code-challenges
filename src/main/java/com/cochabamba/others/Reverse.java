package com.cochabamba.others;

/**
 * @author aralco
 */
public class Reverse {

    public static int reverseNumber(int n)  {
        int reversedNumber = 0;
        while(n>0) {
            reversedNumber = reversedNumber*10 + n%10;
            n = n/10;
        }
        return reversedNumber;
    }

    public static String reverseString(String s)    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--)   {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args)  {
        String string = "amazonas";
        int number = 13452;
        System.out.println("com.cochabamba.others.Reverse String: "+string+", "+reverseString(string));
        System.out.println("com.cochabamba.others.Reverse number: "+number+", "+reverseNumber(number));
    }
}
