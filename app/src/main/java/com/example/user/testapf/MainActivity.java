package com.example.user.testapf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.user.testapf.algorithms.BinarySearch;
import com.example.user.testapf.algorithms.SelectionSort;
import com.example.user.testapf.data_structures.test.TreeImpl;
import com.example.user.testapf.general.questions.GoogleVoters;
import com.example.user.testapf.algorithms.MergeSort;
import com.example.user.testapf.data_structures.graph.new_impl.Graph;
import com.example.user.testapf.data_structures.hashmap.MyMapImpl2;
import com.example.user.testapf.data_structures.linked_list.udemy_linked_list_task.IntegerLinkedList;
import com.example.user.testapf.general.recursion.Permutations;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
{
    ArrayList<ArrayList<Integer>> lll = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TreeNode A = new TreeNode("" + "A");
        TreeNode B = new TreeNode("" + "B");
        TreeNode C = new TreeNode("" + "C");
        TreeNode D = new TreeNode("" + "D");
        TreeNode E = new TreeNode("" + "E");
        TreeNode F = new TreeNode("" + "F");

        A.left = B;
        A.right = C;
        C.left = F;
        B.left = D;
        B.right = E;
//        getAllPath(A);

//        TreeImpl tree = new TreeImpl();
//        Node root = tree.getRoot();
//        tree.treeHight(root, 0);

        Graph.koko();


        MyMapImpl2<Integer, String> qqq = new MyMapImpl2<>();
        qqq.put(444, "444");
        qqq.put(445, "445");
        qqq.put(446, "446");
        qqq.remove(446);
        qqq.put(449, "449");
        qqq.put(452, "452");
        qqq.put(455, "455");
        qqq.put(458, "458");
        qqq.put(458, "koko");
        qqq.put(461, "461");
        qqq.put(464, "464");
        qqq.put(467, "467");
        qqq.put(470, "470");


        String fdgsfds = qqq.get(432);
        String fdgsfds2 = qqq.get(444);


        int fds= 453;


    }

//    Print all paths that go from the leaf nodes of a binary tree to the root node of the tree.

//      A
//    /   \
//   B     C
//  / \   /
//  D E   F
//
//    So this tree would print:
//
//    DBA
//    EBA
//    FCA

// ArrayList<String> result = new ArrayList<>();

    public void getAllPath(TreeNode root)
    {
        inOrderTraversal(root, "");
        // return result;
    }

    ArrayList<String> list = new ArrayList<>();

    public void inOrderTraversal(TreeNode root, String path)
    {
        if (root == null) return;
        inOrderTraversal(root.left, path + (root.left == null ? "" : root.left.val));

        if (root.left == null && root.right == null) //it's a leaf
        {
            String s = new StringBuilder(path).reverse().toString();
            list.add(s);
//            System.print(String.reverse(path)); // i forgot the exact syntax
        }

        inOrderTraversal(root.right, path + (root.right == null ? "" : root.right.val));
    }

//    new StringBuilder(hi).reverse().toString()


//    Given an array of integers, we would like to determine whether given array is monotonic (non-decreasing/non-increasing) or not.

// True:  1 2 3 4
// True:  4 3 3 2
// False: 1 3 2 1

    public boolean isMonotonic(int[] array)
    {

        int first = array[0];
        int last = array[array.length - 1];

        if (first == last)
        {
            for (int i = 0 ; array.length > i ; i++)
            {
                if (i == array.length - 1) break;
                if (array[i] != array[i+1])
                {
                    return false;
                }
            }

            return true;
        }

        // int maxNumber = first;
        if (first > last)
        {
            for (int i = 0 ; array.length > i ; i++)
            {
                if (i == array.length - 1) break;
                if (array[i] < array[i+1])
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            for (int i = 0 ; array.length > i ; i++)
            {
                if (i == array.length - 1) break;
                if (array[i] > array[i+1])
                {
                    return false;
                }
            }

            return true;
        }

    }

    public void mergeSort(ArrayList<Integer> list, int start, int end)
    {
        if (start >= end) return;

        int mid = (start + end)/2;

        mergeSort(list, start, mid - 1);
        mergeSort(list, mid + 1, end);
        merge(list, start, mid , end);
    }

    private void merge(ArrayList<Integer> list, int start, int mid, int end)
    {
        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = start ; i <= mid ; i++)
        {
            temp1.add(list.get(i));
        }

        for (int i = mid + 1 ; i <= end ; i++)
        {
            temp2.add(list.get(i));
        }

        ArrayList<Integer> temp3 = new ArrayList<>();
        int temp1Count = 0;
        int temp2Count = 0;
        for (int i = 0 ; end - start + 1 > i ; i++)
        {
            if (temp1Count == temp1.size())
            {
                temp3.add(temp2.get(temp2Count));
                temp2Count++;
                continue;
            }

            if (temp2Count == temp2.size())
            {
                temp3.add(temp1.get(temp1Count));
                temp1Count++;
                continue;
            }

            if (temp1.get(temp1Count) > temp2.get(temp2Count))
            {
                temp3.add(temp2.get(temp2Count));
                temp2Count++;
            }
            else
            {
                temp3.add(temp1.get(temp1Count));
                temp1Count++;
            }
        }
        int count = 0;
        for (int i = start ; i <= end ; i++)
        {
            list.set(i, temp3.get(count));
            count++;
        }
    }

    public void allP( ArrayList<Integer> list, int start)
    {
        if (list.size() - 1 == start)
        {
            lll.add(list);
            return;
        }

        start++;

        for (int i = 0; list.size() > i ; i++)
        {
            Collections.swap(list, start, list.size() - 1);
            allP(list, start);
        }
    }


    class TreeNode
    {
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String x)
        {
            val = x;
            left = null;
            right = null;
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Permutations p = new Permutations();
        ArrayList<Integer> fff = p.findAnagrams("abab", "ab");


        GoogleVoters fgd = new GoogleVoters();

        SelectionSort strgwewe = new SelectionSort();

//        IntegerLinkedList fgdsikgfdgfd = new IntegerLinkedList();

        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();

        int fdsd = 543;
        String gjfd = "gfd";
//        String ggg = s.findDigitsInBinary(2);

//        GraphImpl g = new GraphImpl();
//        GraphImpl koko = g.createGraph();
//
//        GraphImpl.GraphNode node = new GraphImpl.GraphNode(1);
//
//        ArrayList<Integer> ooo1 = g.depthFirstTraversal(koko, node);
//
//        ArrayList<Integer> ooo2 = g.breadthFirstTraversal(koko, node);


        TreeImpl.rootToLeaf(TreeImpl.getRoot(), "");


//        Solution sss = new Solution();
//
//        ArrayList<String> fff = new ArrayList<>();
//        fff.add("ABCE");
//        fff.add("SFCS");
//        fff.add("ADEE");
//
//        Solution11 sdfcfsdf = new Solution11();
//        int[][] tt = new int[2][2];
//        int[]  one = new int[2];
//        one[0] = 1;
//        one[1] = 0;
//
//        int[]  two = new int[2];
//        two[0] = 2;
//        two[1] = 1;
//
//        tt[0] = one;
//        tt[1] = two;
//
//        boolean pp = sdfcfsdf.canFinish(3, tt);

//        NormalGraph fds = new NormalGraph();
//        boolean popo = fds.isCycling(fds.makeGraph());

//        Sol2 sol2 = new Sol2();
//
//        ArrayList<String> list = new ArrayList<>();
//        list.add("FEDCBECD");
//        list.add("FABBGACG");
//        list.add("CDEDGAEC");
//        list.add("BFFEGGBA");
//        list.add("FCEEAFDA");
//        list.add("AGFADEAC");
//        list.add("ADGDCBAA");
//        list.add("EAABDDFF");
//
//        int juikghjfds = sol2.exist(list, "BCDCB");

//        int[] kk = new int[0];
//        int[] kk1 = new int[]{0, 2, 3, 4};
//        int[] kk2 = new int[]{3};
//        int[] kk3 = new int[]{4};
//        int[] kk4 = new int[0];
//
//        int[][] oo = new int[5][];
//        oo[0] = kk;
//        oo[1] = kk1;
//        oo[2] = kk2;
//        oo[3] = kk3;
//        oo[4] = kk4;
//
//        Sol3 sol3 = new Sol3();
//        List<Integer> result = sol3.eventualSafeNodes(oo);

        MergeSort sort = new MergeSort();

        ArrayList<Integer> koko = new ArrayList<>();
        koko.add(6);
        koko.add(4);
        koko.add(1);
        koko.add(9);
        koko.add(8);
        koko.add(5);
        koko.add(2);

        sort.mergeee(koko);


        ArrayList<Integer> koko1 = new ArrayList<>();
        koko1.add(3);
        koko1.add(3);
        koko1.add(3);
        koko1.add(4);
        koko1.add(5);
        koko1.add(6);
        koko1.add(7);

        BinarySearch binarySearch = new BinarySearch();
        int bool = binarySearch.getStartingIndex(koko1, 3);


//        AVLTree AVLTree = new AVLTree();
//
//        AVLTree.Node node = new AVLTree().new Node(10);
//        AVLTree.insert(node, 11);
//        AVLTree.Node gfdhgfhgf = AVLTree.insert(node, 12);

//        BinaryTreeImpl binaryTreeImpl = new BinaryTreeImpl();
//        BinaryTreeImpl.Node node = binaryTreeImpl.addRecursive(null, 6);
//        binaryTreeImpl.addRecursive(node, 4);
//        binaryTreeImpl.addRecursive(node, 8);
//        binaryTreeImpl.addRecursive(node, 3);
//        binaryTreeImpl.addRecursive(node, 5);
//        binaryTreeImpl.addRecursive(node, 7);
//        binaryTreeImpl.addRecursive(node, 9);
//        binaryTreeImpl.traverseInOrder(node);
//
//        binaryTreeImpl.returnMirror(node);
//        binaryTreeImpl.traverseInOrder(node);




        int ed = 543;
        String gfd = "gfds";


    }


}
