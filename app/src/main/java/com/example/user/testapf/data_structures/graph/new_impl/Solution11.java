package com.example.user.testapf.data_structures.graph.new_impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution11
{

    class Node
    {
        int val;
        ArrayList<Integer> list = new ArrayList<>();

        public Node(int val)
        {
            this.val = val;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    ArrayList<Integer> koko = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        HashSet<Integer> set = new HashSet<>();



        for (int i = 0 ; prerequisites.length > i ; i++)
        {
            if (!set.contains(prerequisites[i][0]))
            {
                Node node = new Node(prerequisites[i][0]);
                node.list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], node);
                set.add(prerequisites[i][0]);
            }
            else
            {
                map.get(prerequisites[i][0]).list.add(prerequisites[i][1]);
            }
        }

        int number = 0;

        for (int i = 0 ; i < numCourses ; i++)
        {
            if (map.get(i) != null)
            {
                number = i;
                break;
            }
        }

        if (prerequisites.length == 0) return true;

        for (Map.Entry<Integer, Node> entry : map.entrySet())
        {
            Integer key = entry.getKey();
            Node value = entry.getValue();

            HashSet<Integer> generalSet = new HashSet<>();

            if (!generalSet.contains(key))
            {
                if (isCyclic(value, generalSet, -1))
                {
                    return false;
                }
            }



        }

        return true;
    }

    // HashSet<Integer> generalSet = new HashSet<>();

    int popo = 0;
    int trtr = -1;

    public boolean isCyclic(Node node, HashSet<Integer> generalSet, int parent)
    {
        // if (node == null) return false;

        // if (generalSet.contains(node.val))
        // {
        //     return true;
        // }

        generalSet.add(node.val);

        ArrayList<Integer> list = node.list;

        for (int i = 0 ; list.size() > i ; i++)
        {

            if ((map.get(list.get(i)) == null)) continue;

            if (!generalSet.contains(list.get(i)))
            {
                if (isCyclic(map.get(list.get(i)),generalSet, node.val)) return true;
            }
            else
            {
                return true;
            }
            // if ((map.get(list.get(i))
        }




        return false;
    }
}