package com.example.user.testapf.algorithms;

import java.util.Stack;

public class Solution
{
    public Solution()
    {
        TreeNode root = new TreeNode(8);

        TreeNode a = new TreeNode(1000);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(1);

        root.left = b;
        root.right = a;
        root.right.right = d;
        root.left.left = c;

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

        inOrderTraversion(originalNode, queueOfNodes);

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

    private static void inOrderTraversion(TreeNode node, Stack<TreeNode> queueOfNodes)
    {
        if (node != null)
        {
            inOrderTraversion(node.left, queueOfNodes);
            queueOfNodes.push(node);
            inOrderTraversion(node.right, queueOfNodes);
        }

    }
}
