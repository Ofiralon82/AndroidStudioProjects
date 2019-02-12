package com.example.user.testapf.questions.array;

import java.util.List;

public class MaxSubArraySum
{
    //Brute-Force Algorithm בכח הזרוע
    private int sum = Integer.MIN_VALUE;

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A) {

        if (A.size() == 1)
        {
            return A.get(0);
        }

        for ( int i = 1 ; A.size() > i ; i++)
        {
            calc(A, i);
        }

        return sum;
    }

    private void calc(final List<Integer> A, int length)
    {
        int temp = 0;

        for ( int i = 0 ; A.size() > i ; i++)
        {
            if (i + length > A.size())
            {
                continue;
            }

            for (int j = i ; i + length > j ; j++ )
            {
                temp += A.get(j);
            }

            if (temp > sum)
            {
                sum = temp;
            }

            temp = 0;
        }
    }


    // naive way
//    public int maxSubArray(final List<Integer> A) {
//
//        if (A.size() == 1)
//        {
//            return A.get(0);
//        }
//
//        for (int i = 0; A.size() - 1 >= i ; i++)
//        {
//            calc(A, i);
//        }
//
//        return sum;
//    }
//
//    private void calc(final List<Integer> A, int start)
//    {
//        int tempSum = 0;
//
//        for (int i = start; (A.size() - 1) >= i; i++)
//        {
//            tempSum += A.get(i);
//
//            if (tempSum > sum)
//            {
//                sum = tempSum;
//            }
//        }
//    }
}


