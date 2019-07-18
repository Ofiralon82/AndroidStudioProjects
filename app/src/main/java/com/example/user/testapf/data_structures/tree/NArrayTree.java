package com.example.user.testapf.data_structures.tree;

import java.util.List;

public class NArrayTree
{
    public class Node
    {
        List<Node> nodes;
        int value;
    }

    public void preOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        System.out.print(root.value);
        for (Node node : root.nodes)
        {
            preOrderTraversal(node);
        }

    }
}
