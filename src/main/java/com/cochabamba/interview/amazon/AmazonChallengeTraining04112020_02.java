package com.cochabamba.interview.amazon;

import java.util.Arrays;

/**
 * @author ariel.alcocer
 */
public class AmazonChallengeTraining04112020_02 {

    public static void main(String[] args) {
        AmazonChallengeTraining04112020_02 training04112020_02 = new AmazonChallengeTraining04112020_02();
        System.out.println(training04112020_02.generalizedGCD(5, new int[]{2,3,4,5,6}));
        System.out.println(training04112020_02.generalizedGCD(5, new int[]{2,4,6,8,10}));

    }
    public int generalizedGCD(int num, int[] arr) {
        Arrays.sort(arr);
        int max=arr[arr.length-1];
        int gcd=1;
        boolean isGCD =true;
        for(int k=2;k<=max;k++) {
            for (int i = 0; i < arr.length; i++) {
                if((arr[i]%k) != 0) {
                    isGCD = false;
                    break;
                }
            }
            if(isGCD)
                gcd=k;
            isGCD=false;
        }
        return gcd;
    }
}
