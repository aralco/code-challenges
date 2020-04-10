package com.cochabamba.challenge1;

import java.util.Scanner;

/**
 * @author aralco
 * Day 6: Let's Review
 */

public class LetsReview {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i=0;i<T;i++)    {
            String s = scanner.next();
            StringBuilder even = new StringBuilder();
            StringBuilder odd = new StringBuilder();
            for(int j=0;j<s.length();j++)   {
                if(j%2==0)  {
                    even.append(s.charAt(j));
                } else  {
                    odd.append(s.charAt(j));
                }
            }
            System.out.println(even.toString()+" "+odd.toString());
        }
    }
}
