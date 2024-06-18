package com.cochabamba.interview.amazon;

/**
 * @author ariel.alcocer
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getMinMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY plates as parameter.
     */

    public static int getMinMoves(List<Integer> plates) {
        Integer min = Collections.min(plates);
        Integer max = Collections.max(plates);
        int minPos = plates.indexOf(min);
        int maxPos = plates.indexOf(max);
        int minSwaps=0;
        if(isOrdered(plates, minPos, maxPos))   {
            return minSwaps;
        } else if(minPos<maxPos && maxPos<=plates.size()-1){
            minSwaps=minPos+(plates.size()-1-maxPos);
        } else if(minPos>maxPos && minPos<=plates.size()-1 && maxPos>=0){
            minSwaps=minPos+(plates.size()-1-maxPos)-1;
        }

        return minSwaps;
    }

    private static boolean isOrdered(List<Integer> plates, int minPos, int maxPos)   {
        return ((plates.get(0)==plates.get(minPos)) && (plates.get(plates.size()-1)==plates.get(maxPos)));
    }

}
public class AmazonChallenge10022022_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int platesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> plates = IntStream.range(0, platesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.getMinMoves(plates);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}


