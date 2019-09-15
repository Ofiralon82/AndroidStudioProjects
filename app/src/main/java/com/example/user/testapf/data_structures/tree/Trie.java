package com.example.user.testapf.data_structures.tree;

import java.util.HashMap;

public class Trie {
    class TrieNode {
        char c;
        boolean isEnd = false;
        HashMap<Character, TrieNode> map = new HashMap<>();

        public TrieNode(){
        }

        public TrieNode (char c) {
            this.c = c;
        }
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        int index = 0;
        while (index < length) {
            TrieNode temp = node.map.get(word.charAt(index));
            if (temp == null) {
                TrieNode newTrieNode = new TrieNode(word.charAt(index));
                node.map.put(word.charAt(index), newTrieNode);
                node = newTrieNode;
            } else {
                node = temp;
            }
            index++;

            if (index == length) {
                node.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        int length = word.length();
        int index = 0;
        while (index < length) {
            TrieNode temp = node.map.get(word.charAt(index));
            if (temp == null) {
                return false;
            } else {
                node = temp;
            }
            index++;

            if (index == length && node.isEnd) {
                return true;
            }
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int length = prefix.length();
        int index = 0;
        while (index < length) {
            TrieNode temp = node.map.get(prefix.charAt(index));
            if (temp == null) {
                return false;
            } else {
                node = temp;
            }
            index++;

            if (index == length) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
