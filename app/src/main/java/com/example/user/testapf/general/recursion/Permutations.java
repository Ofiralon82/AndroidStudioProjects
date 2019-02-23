package com.example.user.testapf.general.recursion;

import java.util.ArrayList;

public class Permutations
{
    public void getAllPermutations(ArrayList<Integer> ho, int a, ArrayList<ArrayList<Integer>> list)
    {
        if (a == ho.size())
        {
            list.add(ho);
        }

        int count = 0;

        ArrayList<Integer> temp = new ArrayList<>(ho);

        while (ho.size() - a > count)
        {
            count++;

            int aaa = temp.get(ho.size() - 1);
            temp.remove(ho.size() - 1);
            temp.add(a, aaa);
            getAllPermutations(temp, a + 1, list);
        }
    }
}
