package com.example.user.testapf.questions.binary_search;

import java.util.Arrays;
import java.util.List;

public class CountElementOccurence
{
    //my solution: correct answer but O(n). see more for o(nLogn)
    public int findCount(final List<Integer> A, int B)
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
                int number = 0;

                for (int i = mid; (A.size() - 1) >= i; i++)
                {
                    if (B == A.get(i))
                    {
                        number++;
                    }
                    else
                    {
                        break;
                    }
                }

                for (int i = mid - 1; i >= 0; i--)
                {
                    if (B == A.get(i))
                    {
                        number++;
                    }
                    else
                    {
                        break;
                    }
                }

                return number;
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

    //right answer:  o(nLogn)
    public int findCount2(final List<Integer> A, int B)
    {
        int firstOccurence = binarySearchFirstOrLastOcurrence(A, B, true);
        if (firstOccurence != -1)
        {
            int lastOccurence = binarySearchFirstOrLastOcurrence(A, B, false);
            int result = lastOccurence - firstOccurence;
            if (result == 0)
            {
                return 1;
            }

            return result + 1;
        }

        return 0;
    }

    public int binarySearchFirstOrLastOcurrence(final List<Integer> A, int B, boolean findFirst)
    {
        if (A.size() < 1)
        {
            return -1;
        }

        if (A.size() == 1)
        {
            if (A.get(0) == B)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }

        int start = 0;
        int end = A.size() - 1;
        int result = -1;

        while (start <= end)
        {
            int mid = (start + end) / 2;

            if (B == A.get(mid))
            {
                result = mid;
                if (findFirst)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else
            {
                if (A.get(mid) > B)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }

        return result;
    }
}

