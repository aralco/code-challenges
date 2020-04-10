package com.cochabamba.interview.adyen;

import java.util.Arrays;

/**
 * @author ariel.alcocer
 */
public class AdyenTrainingChallenge {
    public static void main(String[] args) {
        AdyenTrainingChallenge challenge1 = new AdyenTrainingChallenge();
        System.out.println(challenge1.solution(new int[]{1, 3, 6, 4, 1, 2}));//5
        System.out.println(challenge1.solution(new int[]{1, 2, 3}));//4
        System.out.println(challenge1.solution(new int[]{-1, -3}));//1

        System.out.println(challenge1.solution(new int[]{-1000, 0, -2, -3, 3, 4}));//1
        System.out.println(challenge1.solution(new int[]{-1, -3, -2, -3, -3}));//1
        System.out.println(challenge1.solution(new int[]{3, 3, 2, 10000, -1, -3}));//1
        System.out.println(challenge1.solution(new int[]{3, 3, 4, 12,12,41,1000000}));//1
        System.out.println(challenge1.solution(new int[]{3, 3, -4, 5, 12,12,41,-1000000}));//1
        System.out.println(challenge1.solution(new int[]{3, 3, -4, 5, 12,12,41,-1000000, 1, 2, 3, 4}));//6
    }
    //O(nlog(n))
    public int solution(int[] A) {
        Arrays.sort(A);
        int smallest=1;
        for(int a:A)   {
            if(a>0 && a==smallest)
                smallest++;
        }
        return smallest;
    }
}
