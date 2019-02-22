package com.example.user.testapf.general.recursion;

public class Fibonacci
{
    public int fibonacciRecursion(int n)
    {
        if (n <= 1)
        {
            return 0;
        }

        if (n == 2)//redundant
        {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public int fibonacciLoop(int n)
    {
        if (n <= 1)
        {
            return n;
        }

        int a = 0;
        int b = 1;

        for (int i = 2 ; n > i ; i++)
        {
            int temp = a;
            a = b;
            b = b + temp;
        }

        return b;
    }
}
