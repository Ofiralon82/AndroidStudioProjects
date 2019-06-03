package com.example.user.testapf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.testapf.data_structures.graph.GraphImpl;
import com.example.user.testapf.data_structures.test.Node;
import com.example.user.testapf.data_structures.test.TreeImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MainActivity extends AppCompatActivity
{
    ArrayList<ArrayList<Integer>> lll = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TreeNode A = new TreeNode("" + "A");
        TreeNode B = new TreeNode("" + "B");
        TreeNode C = new TreeNode("" + "C");
        TreeNode D = new TreeNode("" + "D");
        TreeNode E = new TreeNode("" + "E");
        TreeNode F = new TreeNode("" + "F");

        A.left = B;
        A.right = C;
        C.left = F;
        B.left = D;
        B.right = E;
//        getAllPath(A);

        TreeImpl tree = new TreeImpl();
        Node root = tree.getRoot();
        tree.pathFromLeafToRoot(root, "");




        int fds= 453;


    }

//    Print all paths that go from the leaf nodes of a binary tree to the root node of the tree.

//      A
//    /   \
//   B     C
//  / \   /
//  D E   F
//
//    So this tree would print:
//
//    DBA
//    EBA
//    FCA

// ArrayList<String> result = new ArrayList<>();

    public void getAllPath(TreeNode root)
    {
        inOrderTraversal(root, "");
        // return result;
    }

    ArrayList<String> list = new ArrayList<>();

    public void inOrderTraversal(TreeNode root, String path)
    {
        if (root == null) return;
        inOrderTraversal(root.left, path + (root.left == null ? "" : root.left.val));

        if (root.left == null && root.right == null) //it's a leaf
        {
            String s = new StringBuilder(path).reverse().toString();
            list.add(s);
//            System.print(String.reverse(path)); // i forgot the exact syntax
        }

        inOrderTraversal(root.right, path + (root.right == null ? "" : root.right.val));
    }

//    new StringBuilder(hi).reverse().toString()


//    Given an array of integers, we would like to determine whether given array is monotonic (non-decreasing/non-increasing) or not.

// True:  1 2 3 4
// True:  4 3 3 2
// False: 1 3 2 1

    public boolean isMonotonic(int[] array)
    {

        int first = array[0];
        int last = array[array.length - 1];

        if (first == last)
        {
            for (int i = 0 ; array.length > i ; i++)
            {
                if (i == array.length - 1) break;
                if (array[i] != array[i+1])
                {
                    return false;
                }
            }

            return true;
        }

        // int maxNumber = first;
        if (first > last)
        {
            for (int i = 0 ; array.length > i ; i++)
            {
                if (i == array.length - 1) break;
                if (array[i] < array[i+1])
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            for (int i = 0 ; array.length > i ; i++)
            {
                if (i == array.length - 1) break;
                if (array[i] > array[i+1])
                {
                    return false;
                }
            }

            return true;
        }

    }

    public void mergeSort(ArrayList<Integer> list, int start, int end)
    {
        if (start >= end) return;

        int mid = (start + end)/2;

        mergeSort(list, start, mid - 1);
        mergeSort(list, mid + 1, end);
        merge(list, start, mid , end);
    }

    private void merge(ArrayList<Integer> list, int start, int mid, int end)
    {
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = start ; i <= mid ; i++)
        {
            temp1.add(list.get(i));
        }

        for (int i = mid + 1 ; i <= end ; i++)
        {
            temp2.add(list.get(i));
        }

        ArrayList<Integer> temp3 = new ArrayList<>();
        int temp1Count = 0;
        int temp2Count = 0;
        for (int i = 0 ; end - start + 1 > i ; i++)
        {
            if (temp1Count == temp1.size())
            {
                temp3.add(temp2.get(temp2Count));
                temp2Count++;
                continue;
            }

            if (temp2Count == temp2.size())
            {
                temp3.add(temp1.get(temp1Count));
                temp1Count++;
                continue;
            }

            if (temp1.get(temp1Count) > temp2.get(temp2Count))
            {
                temp3.add(temp2.get(temp2Count));
                temp2Count++;
            }
            else
            {
                temp3.add(temp1.get(temp1Count));
                temp1Count++;
            }
        }
        int count = 0;
        for (int i = start ; i <= end ; i++)
        {
            list.set(i, temp3.get(count));
            count++;
        }
    }

    public void allP( ArrayList<Integer> list, int start)
    {
        if (list.size() - 1 == start)
        {
            lll.add(list);
            return;
        }

        start++;

        for (int i = 0; list.size() > i ; i++)
        {
            Collections.swap(list, start, list.size() - 1);
            allP(list, start);
        }
    }


    class TreeNode
    {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String x)
        {
            val = x;
            left = null;
            right = null;
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Solution s = new Solution();
//        String ggg = s.findDigitsInBinary(2);

        GraphImpl g = new GraphImpl();
        GraphImpl koko = g.createGraph();

        GraphImpl.GraphNode node = new GraphImpl.GraphNode(1);

        ArrayList<Integer> ooo1 = g.depthFirstTraversal(koko, node);

        ArrayList<Integer> ooo2 = g.breadthFirstTraversal(koko, node);



        int ed = 543;
        String gfd = "gfds";


    }

    public class Solution {
        public String findDigitsInBinary(int A)
        {
            StringBuilder builder = new StringBuilder();

            while (A != 0)
            {
                if (A % 2 == 0)
                {
                    builder.append("0" + builder.toString());
                }
                else
                {
                    builder.append("1" + builder.toString());
                }

                A = A/2;
            }

            return builder.toString();
        }
    }

}
