package com.cochabamba.hackerrank.interviewkit.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    //refinement
    static int sockMerchant2(int n, int[] socksArray) {
        Arrays.sort(socksArray);
        int pairs=0;
        if(socksArray.length>1) {
            int size = n;
            int i;
            while(size>1)   {
                i=1;
                if(socksArray[size-1]==socksArray[size-2])    {
                    pairs++;
                    i++;
                }
                size=size-i;
            }
        }
        return pairs;
    }

    static int sockMerchant(int n, int[] socksArray) {
        Arrays.sort(socksArray);
        int pairs=0;
        if(socksArray.length>1) {
            Map<Integer,Integer> pairMap = new HashMap<>(1);
            int size = n;
            int counter=1;
            while(size>1)   {
                if(socksArray[size-1]==socksArray[size-2])    {
                    counter++;
                    pairMap.put(socksArray[size-1], counter);
                } else  {
                    pairMap.put(socksArray[size-1], counter);
                    counter=1;
                    pairMap.put(socksArray[size-2], counter);
                }
                size--;
            }
            for (int v:pairMap.values())   {
                while(v>=2)   {
                    pairs++;
                    v=v-2;
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] socksArray = new int[n];
        for(int i=0;i<n;i++)    {
            socksArray[i] = scanner.nextInt();
        }
        System.out.println(sockMerchant(n, socksArray));
        System.out.println(sockMerchant2(n, socksArray));
    }
}
