package com.example.user.testapf.general.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations
{
    public ArrayList<String> stringList = new ArrayList<>();

//    public List<Integer> findAnagrams(String s, String p) {
//        ArrayList<Integer> result = new ArrayList<>();
//        findAllPermutation(p, 0);
//        for (int i = 0 ; stringList.size() > i ; i++) {
//            if (s.contains(stringList.get(i))) {
//                int ind = s.indexOf(stringList.get(i));
//                result.add(s.indexOf(stringList.get(i)));
//                while(ind >= 0)
//                {
//                    ind = s.indexOf(stringList.get(i), ind + 1);
//                    result.add(s.indexOf(stringList.get(i)));
//                }
//            }
//        }
//
//        Collections.reverse(result);
//
//        return result;
//    }

    public int reverse(int x) {
        long y = x < 0 ? x*-1 : x;
        String number = "" + y;

        String reverse = new StringBuilder(number).reverse().toString();

        long longNumber = Long.parseLong(reverse);
        if (longNumber > Integer.MAX_VALUE) return 0;

        return ((int) longNumber) * (x > 0 ? 1 : -1);

//         if (x == 0) return 0;
//         long y = Math.abs(x);
//         String number = "";
//         while (y > 0) {
//             long temp = y % 10;
//             number += temp;
//             y = y/10;
//         }

//         long longNumber = Long.parseLong(number);
//         if (longNumber > Integer.MAX_VALUE) return 0;

//         return (int) longNumber;
    }

    public void findAllPermutation(String s, int index) {
        if (index == s.length()) {
            if (!stringList.contains(s))
            stringList.add(s);

            return;
        }

        StringBuilder builder = new StringBuilder(s);
//        findAllPermutation(builder.toString(), index + 1);
        int count = builder.length() - index;

        while (count > 0) {
            // char temp1 = builder.charAt(builder.size() - 1);
            char temp2 = builder.charAt(index);

            builder.deleteCharAt(index);
            builder.append(temp2);
            findAllPermutation(builder.toString(), index + 1);
            count--;
        }

    }

    public void getAllPermutations(ArrayList<Integer> list, int startIndex, ArrayList<ArrayList<Integer>> per)
    {
        if (startIndex == list.size())
        {
            per.add(list);
            return;
        }

        int count = 0;

        ArrayList<Integer> tempList = new ArrayList<>(list);

        while (list.size() - startIndex > count)
        {
            count++;

            int indexChild = tempList.get(list.size() - 1);
            tempList.remove(list.size() - 1);
            tempList.add(startIndex, indexChild);
            getAllPermutations(tempList, startIndex + 1, per);
        }
    }
}