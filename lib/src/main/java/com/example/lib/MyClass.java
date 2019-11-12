package com.example.lib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MyClass
{

//    https://github.com/malvee/Booking.com
    //https://github.com/nadisha/assignment/tree/master/src/com/booking/challenge


    /* start polygonBooking*/

//    private static void polygonChallange() {
//        int[] list = new int[3];
//        while(true)
//        {
//            Scanner in = new Scanner(System.in);
//            int n = in.nextInt();
//            int[] a = new int[n];
//            for(int i = 0 ; i < n ; i++){
//                a[i] = in.nextInt();
//            }
//
//            calcPoly(list, a);
//            System.out.print(list[0] + " " + list[1] + " " + list[2]);
//        }
//
//    }

    private static void calcPoly(List<String> list, int[] result) {
        for (int i = 0 ; list.size() > i ; i++) {
            String[] stringArray = list.get(i).split(" ");

            if (stringArray.length != 4) {
                result[2] = result[2] + 1;
                continue;
            }

            int[] array = new int[4];

            for (int j = 0 ; stringArray.length > j ; j++) {
                array[j] = Integer.parseInt(stringArray[j]);
            }

            if (array[0] <= 0 || array[1] <= 0 || array[2] <= 0 || array[3] <= 0) {
                result[2] = result[2] + 1;
                continue;
            }

            if (array[0] == array[1] && array[0] == array[2] && array[0] == array[3]) {
                result[0] = result[0] + 1;
                continue;
            }

            if (array[0] == array[2] && array[1] == array[3]) {
                result[1] = result[1] + 1;
                continue;
            }

            result[2] = result[2] + 1;
        }

    }

    public static void main1(String[] args){
         Scanner scan = new Scanner(System.in);
         List<String> list = new ArrayList<>();
         while(scan.hasNext()) {
             list.add(scan.nextLine());
         }
         scan.close();

         int[] result = new int[3];
        calcPoly(list, result);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    /* end  polygonBooking*/

    /* start  deltaEncodingnBooking*/

    public static void main2(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = r.readLine();

        String[] tempArray = line.split(" ");
        int[] numArray = new int[tempArray.length];
        for (int i = 0 ; tempArray.length > i ; i++) {
            numArray[i] = Integer.parseInt(tempArray[i]);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(numArray[0]);
        builder.append(" ");
        for (int i = 1 ; numArray.length > i ; i++) {
            int currDelta = numArray[i] - numArray[i - 1];

            if (currDelta > 127 || currDelta < -127) {
                builder.append("-128");
                builder.append(" ");
            }

            builder.append(currDelta);
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);

        System.out.print(builder.toString());
    }

    public static void main3(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        while(scan.hasNext()) {
            list.add(scan.nextInt());
        }
        scan.close();

        StringBuilder builder = new StringBuilder();
        builder.append(list.get(0));
        builder.append(" ");
        for (int i = 1 ; list.size() > i ; i++) {
            int currDelta = list.get(i) - list.get( i - 1);

            if (currDelta > 127 || currDelta < -127) {
                builder.append("-128");
                builder.append(" ");
            }

            builder.append(currDelta);
            builder.append(" ");
        }

        builder.deleteCharAt(builder.length() - 1);

        System.out.print(builder.toString());
    }

    /* end  deltaEncodingBooking*/

    /* start  anagramBooking*/

    public static void main6(String[] args){
        Scanner scan = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        while(scan.hasNext()) {
            list.add(scan.nextLine());
        }
        scan.close();

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0 ; list.size() > i ; i++) {
            String temp = list.get(i);
            char[] chars = list.get(i).toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            sorted = sorted.trim();

            if (map.get(sorted) == null) {
                List<String> tempList = new ArrayList<>();
                tempList.add(temp);
                map.put(sorted, tempList);
            } else {
                List<String> curr = map.get(sorted);
                curr.add(temp);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            res.add(entry.getValue());
        }

        Collections.sort(res, new Comparator<List<String>>(){

            @Override
            public int compare(List<String> one, List<String> two)
            {
                return one.get(0).compareTo(two.get(0));
            }
        });

        for (int i = 0 ; res.size() > i ;i++) {
            List<String> currList = res.get(i);
            StringBuilder builder = new StringBuilder();
            for (int j = 0; currList.size() > j ;j++) {
                builder.append(currList.get(j));
                if (j != currList.size() - 1) {
                    builder.append(",");
                }
            }

            System.out.println(builder.toString());
        }
    }

    /* end  anagramBooking*/

    /* start sumArrayBooking*/

    public static void main5(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int length = scan.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < length ; i++) {
            int curr = scan.nextInt();
            int needToFind = N - curr;
            if (set.contains(needToFind)) {
                System.out.print("1");
                return;
            }

            set.add(curr);
        }

        System.out.println("0");
    }

    /* end sumArrayBooking*/

    /* start sortHotelLIstBooking*/
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String words = scan.nextLine();
        words = words.replaceAll("\\,", "");
        words = words.replaceAll("\\.", "");
        String[] wordsArray = words.split(" ");
        int size = scan.nextInt();
        Map<Integer, Integer> map = new HashMap<>();

        int maxValue = 0;

        for (int i = 0 ; size > i ; i++) {
            int hotelId = scan.nextInt();
            scan.nextLine();
            String review = scan.nextLine();
            review = review.replaceAll("\\,", "");
            review = review.replaceAll("\\.", "");
            String[] reviewArray = review.split(" ");

            int count = 0;

            for (int j = 0 ; wordsArray.length > j ; j++) {
                String curr = wordsArray[j];

                for (int k = 0 ; reviewArray.length > k ; k++) {
                    if (reviewArray[k].equals(curr)) {
                        count++;
                    }
                }
            }

            if (map.containsKey(hotelId)) {
                map.put(hotelId, map.get(hotelId) + count);
                maxValue = Math.max(maxValue, map.get(hotelId) + count);
            } else {
                map.put(hotelId, count);
                maxValue = Math.max(maxValue, count);
            }
        }
        scan.close();
        ArrayList<Integer>[] arrayRes = new ArrayList[maxValue];
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            ArrayList<Integer> idList = new ArrayList<>();
            int revNumber = entry1.getValue();
            for (Map.Entry<Integer, Integer> entry2 : map.entrySet()) {
                if (entry2.getValue() == revNumber) {
                    idList.add(entry2.getKey());
                }
            }
            Collections.sort(idList);
            arrayRes[revNumber] = idList;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = arrayRes.length - 1 ; i >= 0; i--) {
            if (arrayRes[i] != null) {
                for (int j = 0 ; arrayRes[i].size() > j ; j++) {
                    builder.append(arrayRes[i].get(j));
                    builder.append(" ");
                }
            }
        }

        builder.deleteCharAt(builder.length() - 1);
        System.out.println(builder.toString());
    }

    /* end sortHotelLIstBooking*/

    public static void main(String[] args, int i) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String uu = bufferedReader.readLine();
        System.out.println(uu);
        String[] nm = uu.replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        System.out.println(n + "  " + m);
    }





    private static void getNumberAndPutArrayLengthAndPrint() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n ; i++){
            a[i] = in.nextInt();
        }

        for(int i = 0; i < n ; i++){
            System.out.print(a[i]);
        }
    }

    private static void getLoopOfInt() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextInt()) {
            System.out.println(scan.nextInt());
        }
    }

    private static void getLoopOfString() {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            System.out.println(scan.next());
        }
    }

    private static void getSingleStringAndInt()
    {
        Scanner scan = new Scanner(System.in);
        String b = scan.next();
        int a = scan.nextInt();
        int c = scan.nextInt();
        scan.close();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    public class Solution {

        // Complete the solve function below.
//        double solve(List<List<Integer>> p, List<List<Integer>> q) {
//
//
//        }

        public void main2(String[] args) throws IOException
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String[] nm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            List<List<Integer>> p = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] pRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> pRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int pItem = Integer.parseInt(pRowTempItems[j]);
                    pRowItems.add(pItem);
                }

                p.add(pRowItems);
            }

            List<List<Integer>> q = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                String[] qRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> qRowItems = new ArrayList<>();

                for (int j = 0; j < 2; j++) {
                    int qItem = Integer.parseInt(qRowTempItems[j]);
                    qRowItems.add(qItem);
                }

                q.add(qRowItems);
            }

//            double result = solve(p, q);

//            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

    public static class Polygons {

        private void calcPoly(int a, int b, int c, int d, int[] list) {
            if (a<=0 || b<=0 || c<=0 || d <= 0) {
                list[2] = list[2] + 1;
                return;
            }

            if (a==b && b==c && c==d) {
                list[0] = list[0] + 1;
                return;
            }

            if (a==c && b==d) {
                list[1] = list[1] + 1;
                return;
            }

            list[2] = list[2] + 1;
        }

        public void Polygons() throws FileNotFoundException
        {
            System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
            Scanner in = new Scanner(System.in);

            int[] list = new int[3];

            while (in.hasNext()) {
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                int d = in.nextInt();

                calcPoly(a, b, c, d, list);
            }

            System.out.println(list[0] + " " + list[1] + " " + list[2]);
        }
    }

    //get list:
    //import java.util.*;
    public static void withScanner() {
        Scanner scan = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

         while(scan.hasNext()) {
          list.add(scan.nextInt());
         }
         scan.close();

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }

//    import java.util.*;
//    import java.io.*;
    public static void withBuffer() throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        List<Integer> list = new ArrayList<>();

        while ((line = r.readLine()) != null) {
            list.add(Integer.parseInt(line));
        }

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }

    public static long roundPrice(int price, int n) {
        String priceStr = "" + price;
        boolean isPositive = price > 0 ? true : false;
        if (price == 0) {
            return (long) Math.pow(10, n);
        }

        if (Math.pow(10, n) > price && isPositive) {
            return (long) Math.pow(10, n);
        }

        if (priceStr.length() == 1) {
            return price;
        }

        char[] charArray = priceStr.toCharArray();
        for (int i = charArray.length - 1 ; i >= 0 ; i--) {
            if (n == 0) {
                if (isPositive) {
                    charArray[i] = (char) (charArray[i] + 1);
                }
                break;
            }

            charArray[i] = '0';
            n--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; charArray.length > i ; i++) {
            builder.append(charArray[i]);
        }

        long res = Long.parseLong(builder.toString());
        if (!isPositive) {
            res *= -1;
        }

        return res;
    }
}
