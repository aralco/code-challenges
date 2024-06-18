package com.cochabamba.interview.exagens;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.*;
//https://stackabuse.com/concurrency-in-java-the-executor-framework/
//https://www.baeldung.com/java-when-to-use-parallel-stream
//TODO make it run
public class Adder {
//    public static int sum(List<Callable<Integer>> functions,
//                          Consumer<Integer> onSumChanged) throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        functions.parallelStream().forEach(f -> {
//            Future<Integer> result = executorService.submit(f);
//            try {
//                onSumChanged.accept(result.get());
//                return result.get().intValue();
//            } catch (InterruptedException | ExecutionException e) {
//                System.out.println("Error occured while executing the submitted task");
//                e.printStackTrace();
//            } finally {
//                executorService.shutdown();
//            }
//        });
//    }

    public static void main(String[] args) throws Exception {
        Callable<Integer> expensiveFunction = () -> (int) IntStream.range(0, 200000000).count();
        Callable<Integer> cheapFunction = () -> (int) IntStream.range(0, 10000000).count();
        List<Callable<Integer>> functionList = Arrays.asList(expensiveFunction, cheapFunction);
        Consumer<Integer> onSumChanged = (sum) -> System.out.println("Current result: " + sum);

        // Computationally expensive functions need more time than cheaper functions.
        // Because of this, computationally cheaper functions, when run in parallel,
        // should be summed up before more expensive functions.
        // Expected output:
        // Current result: 10000000
        // Current result: 210000000
        // Final result: 210000000
//        int result = sum(functionList, onSumChanged);
//        System.out.println("Final result: " + result);
    }
}
