package com.example.user.testapf.algorithms;

//https://www.codingame.com/playgrounds/1608/shortest-paths-with-dijkstras-algorithm/dijkstras-algorithm
public class Dijkstra
{
    int MAX = 1000;

    private int[][] graph2 = new int[][]
            { { 0, 2, 1, 1000, 1000 },
              { 2, 0, 1000, 5, 7 },
              { 1, 1000, 0, 3, 1000 },
              { 7, 5, 3, 0, 1 },
              { 1000, 7, 1000, 1, 0 } };

    int[] doneArray = new int[graph2.length];

    public Dijkstra() {
        doneArray[0] = 1;
        int current = getSmallestValue(0);

        while (!isFull()) {

            for (int i = 0 ; graph2[current].length > i ; i++) {
                if ( i == current) {
                    continue;
                }

                if (doneArray[i] == 1) {
                    continue;
                }

                if (graph2[0][current] + graph2[current][i] < graph2[0][i]) {
                    graph2[0][i] = graph2[0][current] + graph2[current][i];
                }
            }

            doneArray[current] = 1;
            current = getSmallestValue(current);
            int fdfasdfsa = 4324;
        }


        int gtre = 543;
        String gfd = "gfdgdfgd";
    }

    private boolean isFull() {
        for (int i = 0 ; doneArray.length > i ; i++) {
            if (doneArray[i] == 0) {
                return false;
            }
        }

        return true;
    }

    private int getSmallestValue(int number) {
        int result = 999999;
        int index = 999999;

        int[] relevant = graph2[number];

        for (int i = 0 ; relevant.length > i ; i++) {
            if ( i == number) {
                continue;
            }

            if (doneArray[i] == 1) {
                continue;
            }

            if (result > relevant[i]) {
                result = relevant[i];
                index = i;
            }

        }

        return index;
    }
}
