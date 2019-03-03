package com.example.user.testapf.algorithms;

import java.util.ArrayList;

public class InsertionSort
{
    public InsertionSort()
    {
        int[] array = {6, 4, 8, 3};
        insertionAlgorithm(array);

        int y = 0;
    }

    private void insertionAlgorithm(int[] array)
    {
        for (int i = 1 ; array.length > i ; i++)
        {
            int value = array[i];
            int hole = i;
            while (hole > 0 && value < array[hole - 1])
            {
                array[hole] = array[hole - 1];
                hole--;
            }
            array[hole] = value;
        }
    }

    private ArrayList<Integer> insertionAlgorithem(ArrayList<Integer> array)
    {
        for (int i = 1 ; array.size() > i ; i++)
        {
            int hole = i;
            int value = array.get(hole);

            while(hole > 0 && array.get(hole - 1) > value)
            {
                array.set(hole, array.get(hole - 1));
                hole--;
            }
            array.set(hole, value);
        }

        return array;
    }

}

//        value = 1
//        hole = 2
//
//        4 5 1 8
//
//        4 5 5 8
//
//        value = 1
//        hole = 1
//
//        4 4 5 8
//
//        value = 1
//        hole = 0
//
//        1 4 5 8
