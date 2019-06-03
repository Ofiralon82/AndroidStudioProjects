package com.example.user.testapf.general.recursion;

import java.util.ArrayList;

public class Permutations
{
    public void getAllPermutations(ArrayList<Integer> list, int startIndex, ArrayList<ArrayList<Integer>> per)
    {
        if (startIndex == list.size())
        {
            per.add(list);
            return;
        }

        int count = 0;

        ArrayList<Integer> tempList = new ArrayList<>(list);

        while (list.size() - startIndex > count)
        {
            count++;

            int indexChild = tempList.get(list.size() - 1);
            tempList.remove(list.size() - 1);
            tempList.add(startIndex, indexChild);
            getAllPermutations(tempList, startIndex + 1, per);
        }
    }
}