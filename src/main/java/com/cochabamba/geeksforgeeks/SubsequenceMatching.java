package com.cochabamba.geeksforgeeks;
import java.util.Scanner;

public class SubsequenceMatching {
    public static void main(String[] args)  {
        String[] patterns = new String[] {"R", "RY", "RYY"};
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for(int t=1;t<=testCases;t++) {
            String text = scanner.nextLine();
            for(String p:patterns)
                match(text, p);

        }
    }

    static void match(String text, String pattern) {
        for(int i=0;i<=text.length()-pattern.length();i++)    {
            int j;
            for(j=0;j<pattern.length();j++)    {
                if(pattern.charAt(j)!=text.charAt(i+j))
                    break;
            }
            if(j==pattern.length())
                System.out.println("Pattern found at index "+(i));
        }
    }
}
