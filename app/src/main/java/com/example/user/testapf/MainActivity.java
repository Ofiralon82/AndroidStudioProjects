package com.example.user.testapf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.testapf.questions.array.MaxSubArraySum;

import java.util.ArrayList;
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

        MaxSubArraySum s = new MaxSubArraySum();
        List<Integer> A = new ArrayList<>();
        A.add(-163);
        A.add(-20);
        s.maxSubArray(A);
    }
}
