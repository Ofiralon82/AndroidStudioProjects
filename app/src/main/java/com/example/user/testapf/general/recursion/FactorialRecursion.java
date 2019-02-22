package com.example.user.testapf.general.recursion;

public class FactorialRecursion
{
    public int factorial(int n)
    {
        if (n == 0)
        {
            return 1;
        }
        else
        {
            return n * factorial(n - 1);
        }
    }


}
