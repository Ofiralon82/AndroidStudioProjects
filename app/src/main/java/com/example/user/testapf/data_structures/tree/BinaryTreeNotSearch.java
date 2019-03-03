package com.example.user.testapf.data_structures.tree;

public class BinaryTreeNotSearch
{
    private static Node root;

    public Node getRoot()
    {
        return root;
    }

    public BinaryTreeNotSearch(int data)
    {
        root = new Node(data);

    }


    boolean isSum = false;
    int B;



    public int hasPathSum(Node A, int B)
    {
        this.B = B;
        rootToLeafSum(A, 0);
        return isSum ? 1 : 0;
    }

    private void rootToLeafSum(Node A, int sum)
    {
        if (isSum)
        {
            return;
        }

        if (A != null)
        {
            sum += A.getKey();

            if (sum == B)
            {
                isSum = true;
            }
            rootToLeafSum(A.getLeft(), sum);
            rootToLeafSum(A.getRight(), sum);
        }
    }

    public void add(Node parent, Node child, String orientation)
    {
        if (orientation.equals("left"))
        {
            parent.setLeft(child);
        }
        else
        {
            parent.setRight(child);
        }
    }

//        Binarytree tree = new Binarytree(3); //  3
//        tree.add(root, n1, "left"); //         1/ \
//        tree.add(root, n2, "right"); //            4
//        tree.add(n2, n3, "left"); //             2/ \
//        tree.add(n2, n4, "right"); //                5


    public static class Node {
        private int key;
        private Node left;
        private Node right;

        public Node(int key) {
            this.key = key;
            right = null;
            left = null;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public void setRight(Node right ) {
            this.right = right;
        }

        public Node getRight() {
            return right;
        }
    }
}


