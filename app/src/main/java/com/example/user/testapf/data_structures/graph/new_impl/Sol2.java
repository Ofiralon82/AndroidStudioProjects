package com.example.user.testapf.data_structures.graph.new_impl;

import java.util.ArrayList;

public class Sol2 {

    int length = 0;
    int count = 0;
    ArrayList<String> A = null;
    String B = "";

    public int exist(ArrayList<String> A, String B)
    {
        // HashMap<Character, Node> map = new HashMap<>();
        this.A = A;
        this.B = B;
        // ArrayList<ArrayList<Character>> charList = new ArrayList<>();

        length = A.get(0).length();
        count = A.size();

        for (int i = 0 ; count > i ; i++)
        {
            for (int j = 0 ; length > j ; j++)
            {
                if (A.get(i).charAt(j) == B.charAt(0))
                {
                    if (searchForPath(0, i, j))
                        return 1;

                }
            }
        }

        return  0;
    }

    boolean rr = false;

    private boolean searchForPath(int k, int i , int j)
    {

        if (k == B.length())
        {
            // rr = true;
            return true;
        }

        if (j >= length || j < 0 || i < 0 || i >= count)
            return false;

        if (A.get(i).charAt(j) != B.charAt(k))
            return false;

        return searchForPath(k + 1, i, j + 1) ||
                searchForPath(k + 1, i, j - 1) || searchForPath(k + 1, i - 1, j)
                || searchForPath(k + 1, i + 1, j);

        // Character c = null;


        //         if ( j + 1 != length)
        //         {
        //             c = A.get(i).charAt(j + 1);

        //             if (c == B.charAt(k))
        //             searchForPath(k + 1, i, j + 1);
        //         }

        // if (j != 0)
        // {
        //     c = A.get(i).charAt(j - 1);

        //     if (c == B.charAt(k))
        //     searchForPath(k + 1, i, j - 1);
        // }

        // if (i != 0)
        // {
        //     c = A.get(i - 1).charAt(j);

        //     if (c == B.charAt(k))
        //     searchForPath(k + 1, i - 1, j);
        // }

        // if (i + 1 != count)
        // {
        //     c = A.get(i + 1).charAt(j);

        //     if (c == B.charAt(k))
        //     searchForPath(k + 1, i + 1, j);
        // }

        // return false;
    }
}
