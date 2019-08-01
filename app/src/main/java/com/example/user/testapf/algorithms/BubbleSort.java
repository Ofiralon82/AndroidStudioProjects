package com.example.user.testapf.algorithms;

//larger elements bubbling to the top of the array
//in-place algorithm
//O(n^2) time complexity
public class BubbleSort
{
    public BubbleSort()
    {
        int[] array = new int[10];
        array[0] = 4;
        array[1] = 14;
        array[2] = 5434;
        array[3] = 1;
        array[4] = 0;
        array[5] = -20;
        array[6] = 654;
        array[7] = 55;
        array[8] = 56;
        array[9] = 876;

        bubbleSort(array, 0);

        int fgdsg = 543;
        String gfd = "gfgfdgd";
    }

    private void bubbleSort(int[] array, int index)
    {
        if (index == array.length)
        {
            return;
        }

        for (int i = 0 ; array.length - 1 - index > i ; i++)
        {
            if (array[i] > array[i + 1])
            {
                swap(array, i, i + 1);
            }
        }

        bubbleSort(array, ++index);
    }

    private void swap(int[] array, int i, int j)
    {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    //Udemy
    public class Main {

        public void main(String[] args) {

            int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

            for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0;
                 lastUnsortedIndex--) {
                for (int i = 0; i < lastUnsortedIndex; i++) {
                    if (intArray[i] > intArray[i + 1]) {
                        swap(intArray, i, i + 1);
                    }
                }
            }

            for (int i = 0; i < intArray.length; i++) {
                System.out.println(intArray[i]);
            }


        }

        public void swap(int[] array, int i, int j) {

            if (i == j) {
                return;
            }

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;

        }
    }
}
