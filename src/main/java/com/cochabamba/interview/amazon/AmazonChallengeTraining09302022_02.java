package com.cochabamba.interview.amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AmazonChallengeTraining09302022_02 {
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        for(int i=1;i<=n;i++)    {
            if(isMultiple(i, 3) && isMultiple(i, 5)) {
                System.out.println("FizzBuzz");
            } else if(isMultiple(i, 3) && !isMultiple(i, 5)) {
                System.out.println("Fizz");
            } else if(!isMultiple(i, 3) && isMultiple(i, 5)) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    private static boolean isMultiple(int a, int b) {
        boolean isMultiple = false;
        if(a<b) {
            isMultiple = false;
        } else {
            if(a%b==0)  {
                isMultiple = true;
            } else {
                isMultiple = false;
            }
        }
        return isMultiple;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        fizzBuzz(n);

        bufferedReader.close();
    }

}
