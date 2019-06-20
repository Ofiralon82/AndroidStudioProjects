package com.example.user.testapf.algorithms;

import java.util.ArrayList;

public class BinarySearch
{
    int binarySearch(int Arr[], int n, int target) {

        //set stating and ending index
        int start = 0, end = n-1;

        while(start <= end) {
            // take mid of the list
            int mid = (start + end) / 2; //notice that start+end can overflow max Integer. ==> int mid = start + (end-start)/2;

            // we found a match
            if(Arr[mid] == target) {
                return mid;
            }
            // go on right side
            else if(Arr[mid] < target) {
                start = mid + 1;
            }
            // go on left side
            else {
                end = mid - 1;
            }
        }
        // element is not present in list
        return -1;
    }


    //with list

    public boolean binarySearch(ArrayList<Integer> list, int target)
    {
        int start = 0;
        int end = list.size() - 1;


        while (true)
        {
            int mid = (start + end) / 2;

            if (list.get(mid) == target)
            {
                return true;
            }

            if (list.get(mid) > target && list.get(start) <= target)
            {
                end = mid - 1;
            }
            else if (list.get(mid) < target && list.get(end) >= target)
            {
                start = mid + 1;
            }
            else
            {
                return false;
            }
        }
    }

    public int getStartingIndex(ArrayList<Integer> list, int target)
    {
        int start = 0;
        int end = list.size() - 1;

        int lastIndex = -1;

        while (start <= end)
        {
            int mid = (start + end) / 2;

            if (list.get(mid) == target)
            {
                lastIndex = mid;
                end = mid - 1;
            }

            if (list.get(mid) > target)
            {
                end = mid - 1;
            }

            if (list.get(mid) < target)
            {
                start = mid + 1;
            }
        }

        return lastIndex;
    }
}
