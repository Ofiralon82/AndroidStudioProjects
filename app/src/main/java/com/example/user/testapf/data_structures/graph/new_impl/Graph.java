package com.example.user.testapf.data_structures.graph.new_impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph
{
    private static int V;   // No. of vertices
    public static ArrayList<Integer> array = new ArrayList<>();

    // Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adj[v].add(w);  // Add w to v's list.
    }

    private void DFS(int start, boolean visited[])
    {
        array.add(start);
        visited[start] = true;

        Iterator<Integer> i = adj[start].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFS(n, visited);
        }
    }

    private void BFS(int start)
    {

        boolean val[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        val[start] = true;
        array.add(start);

        while (!queue.isEmpty())
        {
            LinkedList<Integer> tempList = adj[queue.poll()];

            for (Integer integer : tempList)
            {
                if (!val[integer])
                {
                    val[integer] = true;
                    queue.add(integer);
                    array.add(integer);
                }
            }

        }



    }

    public static void koko()
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        array = new ArrayList<>();
        g.DFS(2, new boolean[V]);

        int i = 0;
        String fgds = "fds";
    }
}
