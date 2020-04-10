package com.cochabamba.hackerrank.warmup;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author aralco
 */
public class ExtraLongFactorials {
    public static BigInteger fact(BigInteger n) {
        if(n.equals(BigInteger.ZERO))    {
            return BigInteger.ONE;
        }
        return n.multiply(fact(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        System.out.println(fact(n));
    }
}
