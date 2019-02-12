package com.example.user.testapf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.testapf.questions.array.MaxSubArraySum;
import com.example.user.testapf.questions.binary_search.CountElementOccurence;

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

        CountElementOccurence c = new CountElementOccurence();
        List<Integer> A = Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9, 10, 10, 10);
        c.findCount2(A, 1);
    }
}
