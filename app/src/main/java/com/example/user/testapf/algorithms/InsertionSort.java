package com.example.user.testapf.algorithms;

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
