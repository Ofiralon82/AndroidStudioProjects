package com.example.user.testapf.questions.string;

public class SubStringInString
{
    public int strStr(final String A, final String B)
    {
        if (A.length() == 0 || B.length() == 0)
        {
            return -1;
        }

        for (int i = 0; A.length() > i; i++)
        {
            int tempI = i;

            for (int j = 0; B.length() > j; j++)
            {
                if (A.length() < tempI + 1)
                {
                    break;
                }

                if (A.charAt(tempI) == B.charAt(j))
                {
                    if (j == B.length() - 1)
                    {
                        return i;
                    }
                    tempI++;
                }
                else
                {
                    break;
                }
            }
        }

        return -1;
    }

}
