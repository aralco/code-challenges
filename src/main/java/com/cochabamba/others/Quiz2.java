package com.cochabamba.others;

import java.util.stream.IntStream;

public class Quiz2 {
    public static void main(String[] args) {
        int sum = IntStream.iterate(1, i -> i + 1)
                .limit(5)
                .peek(i -> {})
                .filter(i -> i % 2 == 0)
                .sum();

        System.out.println(sum);
    }
}
