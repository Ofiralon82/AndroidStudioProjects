package com.example.user.testapf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;






class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode convertBST(TreeNode root) {

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(13);

        a.left = b;
        a.right = c;

        root = a;

        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        int sum = 0;
        for (int i = 0 ; list.size() > i ; i++) {
            sum += list.get(i).val;
        }

        for (int i = 0 ; list.size() > i ; i++) {
            list.get(i).val = sum;
            sum = sum - list.get(i).val;
        }

        return root;
    }

    private void inOrder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;

        inOrder(node.left, list);
        list.add(node);
        inOrder(node.right, list);
    }
}