package com.example.user.testapf.data_structures.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeImpl
{
    public Node root;

    public static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int value)
        {
            this.data = value;
            right = null;
            left = null;
        }
    }

    public BinaryTreeImpl createBinaryTree()
    {
        BinaryTreeImpl bt = new BinaryTreeImpl();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(1);

        return bt;
    }

    public Node addRecursive(Node current, int value)
    {
        if (current == null)
        {
            return new Node(value);
        }

        if (value < current.data)
        {
            current.left = addRecursive(current.left, value);
        }
        else if (value > current.data)
        {
            current.right = addRecursive(current.right, value);
        }
        else
        {
            // data already exists
            return current;
        }

        return current;
    }

    public void add(int value)
    {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value)
    {
        if (current == null)
        {
            return false;
        }

        if (value == current.data)
        {
            return true;
        }
        return value < current.data
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value)
    {
        return containsNodeRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value)
    {
        if (current == null)
        {
            return null;
        }

        if (value == current.data)
        {
            // Node to delete found
            if (current.left == null && current.right == null)
            {
                return null;
            }

            if (current.right == null)
            {
                return current.left;
            }

            if (current.left == null)
            {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.data)
        {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root)
    {
        return root.left == null ? root.data : findSmallestValue(root.left);
    }

    public void delete(int value)
    {
        root = deleteRecursive(root, value);
    }

    //tree Height
    int findHeight(TreeNode aNode) {
        if (aNode == null) {
            return -1;
        }

        int lefth = findHeight(aNode.left);
        int righth = findHeight(aNode.right);

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }

    //Depth-First Search:
    // in-order
    public void traverseInOrder(Node node)
    {
        if (node != null)
        {
            traverseInOrder(node.left);
            System.out.print(" " + node.data);
            traverseInOrder(node.right);
        }
    }

    //Pre-order
    public void traversePreOrder(Node node)
    {
        if (node != null)
        {
            System.out.print(" " + node.data);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    //Post-order
    public void traversePostOrder(Node node)
    {
        if (node != null)
        {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.data);
        }
    }

    //Breadth-First Search:
    public void traverseLevelOrder()
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty())
        {

            Node node = nodes.remove();

            System.out.print(" " + node.data);

            if (node.left != null)
            {
                nodes.add(node.left);
            }

            if (node.right != null)
            {
                nodes.add(node.right);
            }
        }
    }

    //traversal no recursion:

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

    //in order
    public ArrayList<Integer> inorderTraversal(TreeNode A)
    {
        ArrayList<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = A;

        while (curr != null || !stack.isEmpty())
        {
            while (curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }
}
