package com.example.user.testapf.general.questions;

import java.util.ArrayList;
import java.util.Collections;

public class GoogleVoters
{
    public ArrayList<Integer> result = new ArrayList<>();
    ArrayList<Integer> reList = new ArrayList<>();

    public GoogleVoters()
    {
        reList.add(1);
        reList.add(5);
        reList.add(6);
        reList.add(8);
        reList.add(9);

        for (int i = 1 ; i <= 650 ; i++)
        {
            ArrayList<Integer> numberAsList = getListFromNumber(i);

            if (containsOnlyProb(numberAsList))
            {
                int num = i;
                int reversNum = rev(i);

                if (num != reversNum)
                {
                    if (reversNum <= 650)
                    {
                        result.add(num);
                    }
                }
            }
        }
    }

    private boolean containsOnlyProb(ArrayList<Integer> numberAsList)
    {
        for (int i = 0 ; numberAsList.size() > i ; i++)
        {
            boolean kkk = false;
            for (int j = 0 ; reList.size() > j ; j++)
            {
                if (numberAsList.get(i).equals(reList.get(j)))
                {
                    kkk = true;
                    break;
                }
            }

            if (!kkk)
            {
                return false;
            }
        }

        return true;
    }

    private int rev(int i)
    {
        ArrayList<Integer> ii = getListFromNumber(i);
        Collections.reverse(ii);

        for (int k = 0 ; ii.size() > k ; k++)
        {
            if (ii.get(k) == 6)
            {
                ii.set(k, 9);
            }
            else
            {
                if (ii.get(k) == 9)
                {
                    ii.set(k, 6);
                }
            }
        }


        int reversedNumber = 0;

        int size = ii.size() - 1;
        for (int k = 0 ; ii.size() > k ; k++)
        {
            reversedNumber = reversedNumber + (ii.get(k) * (int) (Math.pow(10, size)));
            size--;
        }

        return reversedNumber;
    }

    private ArrayList<Integer> getListFromNumber(int number)
    {
        ArrayList<Integer> list = new ArrayList<>();

        while (number > 0)
        {
            int newNumber = number;
            newNumber %= 10;
            list.add(newNumber);
            number /= 10;
        }

        Collections.reverse(list);
        return list;
    }
}
