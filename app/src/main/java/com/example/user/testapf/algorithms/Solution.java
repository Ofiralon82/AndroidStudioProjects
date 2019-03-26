package com.example.user.testapf.algorithms;

import java.util.Stack;

public class Solution
{
    public Solution()
    {
        TreeNode root = new TreeNode(11);

        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(44);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(12);

        root.left = a;
        root.right = b;

        a.left = c;
        a.right = d;

        boolean fds = isValidBinaryTree(root);

        int dsadas = 453;
        String fdsdfs = "fdas";

    }
    class TreeNode
    {
        int val;
        TreeNode left, right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public static boolean isValidBinaryTree(TreeNode node)
    {
        Stack<TreeNode> queueOfNodes = new Stack<>();

        TreeNode originalNode = node;

        inOrderTraversion(originalNode, queueOfNodes, "");

        if (!isValide)
        {
            return false;
        }

        while (!queueOfNodes.isEmpty())
        {
            TreeNode current = queueOfNodes.pop();

            if (current.left != null)
            {
                if (current.val <= current.left.val)
                {
                    return false;
                }
            }

            if (current.right != null)
            {
                if (current.val > current.right.val)
                {
                    return false;
                }
            }
        }

        return true;
    }

    static int min = Integer.MIN_VALUE;
    static boolean isValide = true;

    private static void inOrderTraversion(TreeNode node, Stack<TreeNode> queueOfNodes, String s)
    {
        if (!isValide)
        {
            return;
        }

        if (node != null)
        {
            if (!s.equals(""))
            {
//                max = Math.max(max, val);
//                min = Math.max(min, val);
                if (s.equals("LEFT") && node.val > min)
                {
                    isValide = false;
                }
                else if (s.equals("RIGHT") && node.val < min)
                {
                    isValide = false;
                }
            }

            inOrderTraversion(node.left, queueOfNodes, "LEFT");
            queueOfNodes.push(node);
            inOrderTraversion(node.right, queueOfNodes, "RIGHT");
        }
    }
}
