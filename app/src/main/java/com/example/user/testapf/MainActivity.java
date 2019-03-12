package com.example.user.testapf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.testapf.algorithms.Solution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TreeNode t1 = new TreeNode(11);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(5);

        Queue<Integer> op = new LinkedList<>();

        Stack<String> fds = new Stack<>();

        t1.left = t2;
        t1.right = t3;

        t1.left.left = t4;
        t1.left.right = t5;
        t1.right.left = t6;
        int fdsf= isValidBST(t1);
        int y = 0;
        String gfd = "gfd";


        Solution s = new Solution();
    }

    boolean isValid = true;

    public int isValidBST(TreeNode A)
    {
        preOrder(A);
        return isValid ? 1 : 0;
    }

    private TreeNode preOrder(TreeNode node)
    {
        if (!isValid)
            return null;

        if (node != null)
        {
            TreeNode leftNode = preOrder(node.left);
            if (leftNode != null)
            {
                if (node.val < leftNode.val)
                    isValid = false;
            }

            TreeNode rightNode = preOrder(node.right);
            if (rightNode != null)
            {
                if (node.val > rightNode.val)
                    isValid = false;
            }

            return node;
        }

        return null;
    }

    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x)
        {
            val = x;
            left = null;
            right = null;
        }
    }

}
