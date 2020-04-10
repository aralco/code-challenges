package com.cochabamba.interview;

import java.util.*;

/**
 * @author ariel.alcocer
 */
public class AdyenChallenge3 {
    public static void main(String[] args) {
        AdyenChallenge3 challenge3 = new AdyenChallenge3();
        System.out.println(Arrays.toString(challenge3.solution(2, 4)));
        System.out.println(Arrays.toString(challenge3.solution(3, 20)));
        System.out.println(Arrays.toString(challenge3.solution(5, 6)));
    }
    public String[] solution(int N, int K) {
        if (N == 0) {
            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        for (String p : solution(N - 1, K - 1)) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }
}
