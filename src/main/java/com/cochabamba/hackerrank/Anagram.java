package com.cochabamba.hackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Anagram {

    public static void anagram(int n, String[] input) {
        for(int i=0;i<n;i++) {
            String a=input[i].substring(0,input[i].length()/2);
            String b=input[i].substring(input[i].length()/2,input[i].length());
            if(a.length()==b.length())    {
                char[] ax = a.toCharArray();
                char[] bx = b.toCharArray();
                Arrays.sort(ax);
                Arrays.sort(bx);
                String axx=new String(ax);
                String bxx=new String(bx);
                if(axx.equals(bxx))   {
                    System.out.println("0");
                } else if(Math.abs(a.length()-b.length())<1)    {
                    Set<Character> notCommon = new HashSet<>();
                    int count=0;
                    boolean exists=false;
                    for(int j=0;j<ax.length;j++)   {
                        for(int k=0;k<bx.length;k++)   {
                            if(ax[j]!=bx[k])    {
                                exists=true;
                            }
                            if(exists && !notCommon.contains(ax[j]))  {
                                notCommon.add(ax[j]);
                            } else {
                                notCommon.remove(ax[j]);
                            }
                        }
                    }
                    System.out.println(notCommon.size());
                }
            } else  {
                System.out.println("-1");
            }
        }
    }

    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int n =Integer.parseInt(in.nextLine());
        String input[] = new String[n];
        for(int i=0;i<n;i++) {
            input[i]=in.nextLine();
        }
        anagram(n, input);
    }
}