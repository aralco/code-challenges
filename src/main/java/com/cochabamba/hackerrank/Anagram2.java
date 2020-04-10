package com.cochabamba.hackerrank;

import java.util.Scanner;

public class Anagram2 {
    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new  Scanner(System.in);
        int len = s.nextInt();
        int[] strlen;
        String str;
        int strcount;
        int l;
        int casco = 'a';
        char chartemp1;
        int temp1;
        char chartemp2;
        int temp2;
        for(int i=0;i<len;i++){
            str = s.next();
            strcount=0;
            strlen = new int[26];
            if(str.length()%2!=0)
            {
                strcount=-1;
            }else{
                l=str.length()/2;
                for(int j=0;j<l;j++)
                {
                    chartemp1=str.charAt(j);
                    temp1=chartemp1-'a';
                    strlen[str.charAt(j)-'a']++;

                    chartemp2=str.charAt(j+l);
                    temp2=chartemp2-'a';
                    strlen[str.charAt(j+l)-'a']--;
                }
                for(int k=0;k<26;k++)
                    if(strlen[k]<0)
                        strcount+=Math.abs(strlen[k]);

            }
            System.out.println(strcount);
        }
    }
}
