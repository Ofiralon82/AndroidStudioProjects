package com.example.user.testapf.data_structures.tree;

public class TreeNodeTest
{
    public class TreeNode
    {
        int value;
        TreeNode left, right;

        public TreeNode(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public TreeNode root;

    public TreeNode add(int value)
    {
        if (root == null)
        {
            root = new TreeNode(value);
            return root;
        }

        return add(root, value);
    }

    private TreeNode add(TreeNode node, int value)
    {
        if (node == null)
        {
            return new TreeNode(value);
        }

        if (value == node.value)
        {

        }
        else if (value > node.value)
        {
            node.right = add(node.right, value);
        }
        else
        {
            node.left = add(node.left, value);
        }

        return node;
    }

    boolean isSum = false;
    int B;
    public int hasPathSum(TreeNode A, int B)
    {
        this.B = B;
        rootToLeafSum(A, 0);
        return isSum ? 1 : 0;
    }

    private void rootToLeafSum(TreeNode A, int sum)
    {
        if (isSum)
        {
            return;
        }

        if (A != null)
        {
            sum += A.value;

            if (sum == B)
            {
                isSum = true;
            }
            rootToLeafSum(A.left, sum);
            rootToLeafSum(A.right, sum);
            sum -= A.value;
        }

    }
}
