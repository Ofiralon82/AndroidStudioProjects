package com.example.user.testapf.algorithms;

import java.util.ArrayList;

public class MergeSort
{

    public MergeSort()
    {
        int arr[] = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        int i = 0;
    }

    // Arr is an array of integer type
// start and end are the starting and ending index of current interval of Arr

    public void mergeSort(int Arr[], int start, int end)
    {
        int fds = 0;
        if (start < end)
        {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid);
            mergeSort(Arr, mid + 1, end);
            merge(Arr, start, mid, end);
        }
    }


// example of merge sort in Java
// merge function take two intervals
// one from start to mid
// second from mid+1, to end
// and merge them in sorted order

    private void merge(int Arr[], int start, int mid, int end)
    {

        // create a temp array
        int temp[] = new int[end - start + 1];

        // crawlers for both intervals and for temp
        int i = start, j = mid + 1, k = 0;

        // traverse both arrays and in each iteration add smaller of both elements in temp
        while (i <= mid && j <= end)
        {
            if (Arr[i] <= Arr[j])
            {
                temp[k] = Arr[i];
                k += 1;
                i += 1;
            }
            else
            {
                temp[k] = Arr[j];
                k += 1;
                j += 1;
            }
        }

        // add elements left in the first interval
        while (i <= mid)
        {
            temp[k] = Arr[i];
            k += 1;
            i += 1;
        }

        // add elements left in the second interval
        while (j <= end)
        {
            temp[k] = Arr[j];
            k += 1;
            j += 1;
        }

        // copy temp to original interval
        for (i = start; i <= end; i += 1)
        {
            Arr[i] = temp[i - start];
        }
    }



    //with list

    public void mergeee(ArrayList<Integer> list)
    {
        startMerging(list, 0 , list.size() - 1);
    }

    private void startMerging(ArrayList<Integer> list, int start, int end)
    {
        if (start >= end)
        {
            return;
        }
        int mid = (start + end) / 2;
        startMerging(list, start, mid);
        startMerging(list, mid + 1, end);
        mergee1(list, start, mid, end);
    }

    private void mergee1(ArrayList<Integer> list, int start, int mid, int end)
    {
        ArrayList<Integer> temp = new ArrayList<>();

        int newStart = start;
        int newMid = mid + 1;

        while (newStart <= mid && newMid <= end)
        {
            if (list.get(newStart) < list.get(newMid))
            {
                temp.add(list.get(newStart));
                newStart++;
            }
            else
            {
                temp.add(list.get(newMid));
                newMid++;
            }
        }

        while (newStart <= mid)
        {
            temp.add(list.get(newStart));
            newStart++;
        }

        while (newMid <= end)
        {
            temp.add(list.get(newMid));
            newMid++;
        }

        int count = 0;
        for (int i = start ; i <= end ; i++)
        {
            list.set(i, temp.get(count));
            count++;
        }
    }


}
