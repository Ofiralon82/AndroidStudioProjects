package com.example.user.testapf.questions.binary_search;

import java.util.ArrayList;

public class MatrixMedian
{
    //    1 3 5
    //    2 6 9
    //    3 6 9
    //still problem with this solution
    public int findMedian(ArrayList<ArrayList<Integer>> A)
    {
        int count = A.size() * A.get(0).size();
        int half = count/2 + 1;

        int number = 0;
        for (int i = 0 ; A.size() > i ; i++)
        {

            for (int j = 0 ; A.get(i).size() > j ; j++)
            {
                if (A.size() == 1)
                {
                    number = 0;
                }
                number += findCount(A.get(i), A.get(i).get(j));

                if (number >= half)
                {
                    return A.get(i).get(j);
                }
            }
        }

        return -1;
    }

    public int findCount(final ArrayList<Integer> A, int B)
    {
        if (A.size() < 1)
        {
            return 0;
        }

        if (A.size() == 1)
        {
            if (A.get(0) == B)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        int start = 0;
        int end = A.size() - 1;

        while (start <= end)
        {
            int mid = (start + end) / 2;

            if (B == A.get(mid))
            {
                return mid + 1;
            }

            if (start == end)
            {
                if (B > A.get(start))
                {
                    return start - 1;
                }
                else
                {
                    return start + 1;
                }
            }

            if (A.get(mid) > B)
            {
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return 0;
    }
}
