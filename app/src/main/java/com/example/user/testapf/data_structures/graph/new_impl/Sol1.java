package com.example.user.testapf.data_structures.graph.new_impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Sol1 {
    class Node
    {
        String val;
        ArrayList<Node> n = new ArrayList<>();

        public Node(String val)
        {
            this.val = val;
        }
    }

    HashMap<String, Node> map = new HashMap<>();
    String koko = "fdsfds";

    public int knight(int A, int B, int C, int D, int E, int F)
    {
        koko = "" + E + "," + F;
        for (int i = 0 ; A+ 1 > i ; i++)
        {
            for (int j = 0 ; B + 1 > j ; j++)
            {
                Node temp = new Node(i + "," + j);
                map.put("" + i + "," + j, temp);
            }
        }

        for (Map.Entry<String, Node> entry : map.entrySet())
        {
            Node value = entry.getValue();
            String key = entry.getKey();

            String[] fn = key.split(",");
            int x1 = Integer.parseInt(fn[0]);
            int y1 = Integer.parseInt(fn[1]);

            ArrayList<String> inte = new ArrayList<>();

            String number1 = "" + (x1 + 2) + "," + (y1 + 1);
            String number2 = "" + (x1 - 2) + "," + (y1 + 1);
            String number3 = "" + (x1 + 2) + "," + (y1 - 1);
            String number4 = "" + (x1 - 2) + "," + (y1 - 1);

            String number5 = "" + (x1 + 1) + "," + (y1 + 2);
            String number6 = "" + (x1 - 1) + "," + (y1 + 2);
            String number7 = "" + (x1 + 1) + "," + (y1 - 2);
            String number8 = "" + (x1 - 1) + "," + (y1 - 2);

            inte.add(number1);
            inte.add(number2);
            inte.add(number3);
            inte.add(number4);
            inte.add(number5);
            inte.add(number6);
            inte.add(number7);
            inte.add(number8);

            for (String num : inte)
            {
                if (map.get(num) != null)
                {
                    value.n.add(map.get(num));
                }
            }
        }

        boolean jh = hasConnection(map.get(C + "," + D), new ArrayList<String>(), new HashSet<String>());
        if (!jh) return -1;

        int cc = Integer.MAX_VALUE;

//        for (Integer nuu : lll)
//        {
//            if (cc > nuu)
//                cc = nuu;
//        }
        return cc;
    }

    int result = -1;
    ArrayList<ArrayList<String>> lll = new ArrayList<>();

    private boolean hasConnection(Node root, ArrayList<String> lp, HashSet<String> set)
    {
//        count++;
        for (Node node :root.n)
        {
            if (!set.contains(node.val))
            {
                lp.add(root.val);
                set.add(node.val);


                if (node.val.equals(map.get(koko).val))
                {
                    lll.add(lp);
                    return true;
                }
                else
                {
                    return hasConnection(node, lp, set);
                }
            }
        }

        return false;
    }
}

