package com.example.user.testapf.data_structures.test;

import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

//         7
//       /   \
//      6     8
//     / \   / \
//    5   9 4   10

//DFS:
//inorder - 5, 6, 9, 7, 4, 8, 10
//pre order - 7, 6, 5, 9, 8, 4, 10
//post order - 5, 9, 6, 4, 10, 8, 7

//BFS:
// 7, 6, 8, 5, 9, 4, 10

public class TreeImpl
{
    public ArrayList<Integer> array = new ArrayList<>();

    public Node getRoot()
    {
        Node n1 = new Node(10);
        Node n2 = new Node(9);
        Node n3 = new Node(8);
        Node n4 = new Node(7);
        Node n5 = new Node(6);
        Node n6 = new Node(5);
        Node n7 = new Node(4);

        n4.left = n5;
        n4.right = n3;
        n5.right = n2;
        n5.left = n6;
        n3.left = n7;
        n3.right = n1;

        return n4;
    }

    public ArrayList<String> stringArray = new ArrayList<>();
    public void pathFromLeafToRoot(Node root, String path)
    {
        if (root == null) return;

        pathFromLeafToRoot(root.left, path + root.value);

        pathFromLeafToRoot(root.right, path + root.value);

        if (root.right == null && root.left == null)
        {
            stringArray.add(path + root.value);
        }
    }

    //todo: not ready
    public void inOrderNotRec(Node root)
    {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            Node tempNode = stack.pop();
            while (tempNode.left != null)
            {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }

            Node tempNode2 = stack.pop();
            array.add(tempNode2.value);

            if (tempNode2.right != null)
            {
                stack.push(tempNode2.right);
            }

        }
    }

    public void BFS(Node root)
    {
        if (root == null) return;

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node temp = queue.poll();
            array.add(temp.value);

            if (temp.left != null)
            {
                queue.add(temp.left);
            }

            if (temp.right != null)
            {
                queue.add(temp.right);
            }
        }
    }

    public void inOrder(Node root)
    {
        if (root == null) return;

        inOrder(root.left);
        Log.e("kkk", "" + root.value);
        array.add(root.value);
        inOrder(root.right);
    }

    public void preOrder(Node root)
    {
        if (root == null) return;

        Log.e("kkk", "" + root.value);
        array.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root)
    {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        Log.e("kkk", "" + root.value);
        array.add(root.value);
    }


}
