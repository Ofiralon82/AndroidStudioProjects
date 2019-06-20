package com.example.user.testapf.data_structures.graph.new_impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//802. Find Eventual Safe States - leetcode.com
public class Sol3 {
    int[][] graph;
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        this.graph = graph;
        ArrayList<Integer> result = new ArrayList<>();

        // for (int i = 0 ; graph.length > i ; i++)
        // {
        //     if (graph[i].length == 0)
        //     {
        //         result.add(i);
        //     }
        // }

        for (int j = 0 ; graph.length > j ; j++)
        {
            // if (!result.contains(j))
            {
                List<Integer> visited = new ArrayList<>();
                if (!hasCycle(j, visited))
                {
                    result.add(j);
                }
            }
        }

        Collections.sort(result);
        return result;
    }

    private boolean hasCycle(int index, List<Integer> visited)
    {
        if (visited.contains(index)) return true;
        visited.add(index);

        for (int i = 0 ; graph[index].length > i ; i++)
        {
            // if (!visited.contains(graph[index][i]))
            {
                if (hasCycle(graph[index][i], visited))
                {
                    return true;
                }

            }
//             else
//             {
//             boolean contains = IntStream.of(graph[graph[index][i]]).anyMatch(x -> x == index);

//                 if ( !contains)

//                 return true;
//             }

        }

        visited.remove(visited.size() - 1);
        return false;
    }
}