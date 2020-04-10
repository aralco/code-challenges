package com.cochabamba.hackerrank.interviewkit.warmup;

/**
 * @author ariel.alcocer
 */
import java.io.*;
import java.util.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int visitedValleys = 0;
        boolean startValleySequence=false;
        int stepCounter = 0;
        for(int i=0;i<s.length();i++)    {
            stepCounter=(s.charAt(i)=='U')?stepCounter+1:stepCounter-1;
            if(stepCounter==-1)
                startValleySequence=true;
            if(startValleySequence && stepCounter==0) {
                visitedValleys++;
                startValleySequence=false;
            }
        }
        return visitedValleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);
        scanner.close();
    }
}
