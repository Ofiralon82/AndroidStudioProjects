package com.example.user.testapf.data_structures.graph.new_impl;

import java.util.ArrayList;
import java.util.HashSet;

public class NormalGraph
{
    class Node
    {
        int val;
        ArrayList<Node> n = new ArrayList<>();

        public Node(int val)
        {
            this.val = val;
        }
    }

    public Node makeGraph()
    {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.n.add(node2);
        node2.n.add(node3);
        node3.n.add(node4);
        node4.n.add(node5);

        return node1;
    }

    public boolean isCycling(Node root)
    {
        HashSet<Integer> set = new HashSet<>();

        if (cycle(root, -1, set))
        {
            return true;
        }

        return false;
    }

    private boolean cycle(Node root, int parent, HashSet<Integer> set)
    {
        set.add(root.val);

        for (Node node : root.n)
        {
            if (!set.contains(node.val))
            {
                if (cycle(node, root.val, set))
                {
                    return true;
                }
            }
            else if (node.val != parent)
            {
                return true;
            }
        }

        return false;
    }
}
