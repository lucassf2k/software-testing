package com.lucassf2k.main;

public class Fibonacci {
    public static long calculate(final int n) {
        if (n < 0 || n > 46) return -1;
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            var temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
