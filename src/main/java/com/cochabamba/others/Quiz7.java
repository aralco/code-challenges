package com.cochabamba.others;

public class Quiz7 {
    public static void main(String[] args) {
        //500
        Integer n0 = 5;
        increase(n0);
        //Cannot invoke "java.lang.Integer.intValue()" because "n1" is null
        Integer n1 = null;
        increase(n1);
    }

    public static void increase(int n)  {
        System.out.println(n*100);
    }

}

