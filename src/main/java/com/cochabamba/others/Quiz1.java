package com.cochabamba.others;

public class Quiz1 {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            return 0;
        } finally {
            System.out.println("in finally block");
            return 1;
        }
    }
}
