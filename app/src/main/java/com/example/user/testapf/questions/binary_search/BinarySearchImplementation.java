package com.example.user.testapf.questions.binary_search;

public class BinarySearchImplementation
{
    public BinarySearchImplementation() {
        int[] array = {-22, -15, 1, 7, 20, 35, 55};

        int sol1 = iterativeBinarySearch(array, -15);
        int sol11 = recurciveBinarySearch(array, -15, 0, array.length - 1);

        int sol2 = iterativeBinarySearch(array, 35);
        int sol22 = recurciveBinarySearch(array, 35, 0, array.length - 1);

        int sol3 = iterativeBinarySearch(array, 8888888);
        int sol33 = recurciveBinarySearch(array, 8888888, 0, array.length - 1);

        int sol4 = iterativeBinarySearch(array, 1);
        int sol44 = recurciveBinarySearch(array, 1, 0, array.length - 1);

        int ffdas = 543;
        String gfdgfsgdf = "gfdsa";
    }

    public static int iterativeBinarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] == value) {
                return mid;
            }
            else if (array[mid] > value) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int recurciveBinarySearch(int[] array, int value, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        if (array[mid] == value) {
            return mid;
        }
        else if (array[mid] > value) {
            end = mid - 1;
            return recurciveBinarySearch(array, value, start, end);
        }
        else {
            start = mid + 1;
            return recurciveBinarySearch(array, value, start, end);
        }
    }
}
