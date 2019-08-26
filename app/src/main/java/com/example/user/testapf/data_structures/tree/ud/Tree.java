package com.example.user.testapf.data_structures.tree.ud;

public class Tree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }

        return null;
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }

        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot.getLeftChild(), value));
        }
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), value));
        }
        else {
            // Cases 1 and 2: node to delete has 0 or 1 child(ren)
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            }
            else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }

            // Case 3: node to delete has 2 children

            // Replace the value in the subtreeRoot node with the smallest value
            // from the right subtree
            subtreeRoot.setData(subtreeRoot.getRightChild().min());

            // Delete the node that has the smallest value in the right subtree
            subtreeRoot.setRightChild(delete(subtreeRoot.getRightChild(), subtreeRoot.getData()));
        }

        return subtreeRoot;
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        else {
            return root.max();
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

//    Interview Question #1:
//
//    Write an efficient algorithm thats able to compare two binary search trees.
//    The method returns true if the trees are identical (same topology with same values in the nodes)
//    otherwise it returns false.
    public boolean compareTrees(TreeNode rootA, TreeNode rootB) {
        if (rootA == null || rootB == null) {
            return rootA == rootB;
        }

        if (rootA.getData().compareTo(rootB.getData()) != 0) {
            return false;
        }

        return compareTrees(rootA.getLeftChild(), rootB.getLeftChild()) &&
                compareTrees(rootA.getRightChild(), rootB.getRightChild());
    }

//    Interview Question #3:
//
//    Write an efficient algorithm to calculate the total sum of ages in a family tree.
//    A family tree is a binary search tree in this case where all the nodes contain
//    a Person object with [name,age] attributes.
//
//    Hint: we have to make a tree traversal so the running time of the algoritm will be O(N) linear running time

    //solution - traverse in post order!
    private int getAgesSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int sum, leftSum, rightSum = 0;

        leftSum = getAgesSum(node.getLeftChild());
        rightSum = getAgesSum(node.getRightChild());

        sum = node.getData() + leftSum + rightSum;
        return sum;
    }
}
