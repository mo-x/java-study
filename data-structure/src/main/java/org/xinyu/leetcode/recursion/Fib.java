package org.xinyu.leetcode.recursion;


public class Fib {

    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        //fn = f(n-1) +f(n-2)
        //a= fn(f-1)
        //b= f(n-2)
        int a = 0, b = 1;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
