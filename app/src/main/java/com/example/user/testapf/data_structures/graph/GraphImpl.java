package com.example.user.testapf.data_structures.graph;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GraphImpl
{
    private Map<GraphNode, List<GraphNode>> map = new HashMap<>();

    public Map<GraphNode, List<GraphNode>> getMap()
    {
        return map;
    }

    public GraphImpl createGraph() {
        GraphImpl graph = new GraphImpl();
        graph.addNode(1);//bob
        graph.addNode(2);//alice
        graph.addNode(3);//mark
        graph.addNode(4);//rob
        graph.addNode(5);//maria
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        return graph;
    }

    public ArrayList<Integer> depthFirstTraversal(GraphImpl graph, GraphNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            GraphNode temp = stack.pop();

            if (!set.contains(temp.number))
            {
                result.add(temp.number);
                set.add(temp.number);

                for (GraphNode v : graph.getMap().get(temp)) {
                    stack.push(v);
                }
            }
        }

        return result;
    }

    public ArrayList<Integer> breadthFirstTraversal(GraphImpl graph, GraphNode root)
    {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<GraphNode> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(root);

        while (!q.isEmpty())
        {
            GraphNode temp = q.poll();

            if (!set.contains(temp))
            {
                for (GraphNode v : graph.getMap().get(temp)) {
                    q.add(v);
                    set.add(temp.number);
                    result.add(temp.number);
                }
            }
        }

        return result;
    }

    @SuppressLint("NewApi")
    public void addNode(int number)
    {
        map.putIfAbsent(new GraphNode(number), new ArrayList<GraphNode>());
    }

    @SuppressLint("NewApi")
    public void removeNode(int number)
    {
        final GraphNode v = new GraphNode(number);

        map.values()
                .stream()
                .map(new Function<List<GraphNode>, Object>()
                {
                    @Override
                    public Object apply(List<GraphNode> e)
                    {
                        return e.remove(v);
                    }
                })
                .collect(Collectors.toList());

        map.remove(new GraphNode(number));
    }

    public void addEdge(int number1, int number2) {
        GraphNode v1 = new GraphNode(number1);
        GraphNode v2 = new GraphNode(number2);
        map.get(v1).add(v2);
        map.get(v2).add(v1);
    }

    public void removeEdge(int number1, int number2) {
        GraphNode v1 = new GraphNode(number1);
        GraphNode v2 = new GraphNode(number2);
        List<GraphNode> eV1 = map.get(v1);
        List<GraphNode> eV2 = map.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }

    public static class GraphNode
    {
        int number;

        public GraphNode(int number)
        {
            this.number = number;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            GraphNode graphNode = (GraphNode) o;
            return number == graphNode.number;
        }

        @SuppressLint("NewApi")
        @Override
        public int hashCode()
        {
            return Objects.hash(number);
        }
    }


}
