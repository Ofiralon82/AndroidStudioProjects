package com.example.user.testapf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.testapf.questions.array.MaxSubArraySum;
import com.example.user.testapf.questions.binary_search.CountElementOccurence;
import com.example.user.testapf.questions.binary_search.MatrixMedian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        new InsertionSort();
//        new MergeSort();

//        MaxSubArraySum s = new MaxSubArraySum();
//        List<Integer> A = new ArrayList<>();
//        A.add(-163);
//        A.add(-20);
//        s.maxSubArray(A);

//        CountElementOccurence c = new CountElementOccurence();
//        List<Integer> A = Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10);
//        c.findCount2(A, 1);

        //    1 3 5
        //    2 6 9
        //    3 6 9
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(2);
//        a.add(5);
//        ArrayList<Integer> b = new ArrayList<>();
//        b.add(2);
//        b.add(6);
//        b.add(9);
//        ArrayList<Integer> c = new ArrayList<>();
//        c.add(3);
//        c.add(6);
//        c.add(9);
//
//        ArrayList<ArrayList<Integer>> aaa = new ArrayList<>();
//        aaa.add(a);
//        aaa.add(b);
//        aaa.add(c);
//
//        MatrixMedian m = new MatrixMedian();
//        m.findMedian(aaa);

        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        ArrayList<Integer> aa = new ArrayList<>();
        aa.add(2);
        ArrayList<Integer> aaa = new ArrayList<>();
        aaa.add(2);
        ArrayList<Integer> aaaa = new ArrayList<>();
        aaaa.add(2);
        ArrayList<Integer> aaaaa = new ArrayList<>();
        aaaaa.add(2);
        ArrayList<Integer> aaaaaa = new ArrayList<>();
        aaaaaa.add(2);
        ArrayList<Integer> aaaaaaa = new ArrayList<>();
        aaaaaaa.add(2);



        ArrayList<ArrayList<Integer>> ff = new ArrayList<>();
        ff.add(a);
        ff.add(aa);
        ff.add(aaa);
        ff.add(aaaa);
        ff.add(aaaaa);
        ff.add(aaaaaa);
        ff.add(aaaaaaa);

        MatrixMedian m = new MatrixMedian();
        m.findMedian(ff);
    }

    public int isPalindrome(String A)
    {
        if (A.length() == 0)
        {
            return 0;
        }

        A = A.toLowerCase();
        A = A.replaceAll("[\\W]|_", "");


        for (int i = 0 ; (A.length() - 1)/2 >= i ; i++)
        {

            if (A.charAt(i) != A.charAt(A.length() - 1 - i))
            {
                return 0;
            }
        }

        return 1;
    }
}
