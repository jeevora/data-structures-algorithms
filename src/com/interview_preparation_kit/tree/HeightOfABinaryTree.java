package com.interview_preparation_kit.tree;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightOfABinaryTree {

    // O(n - n-1) with recursion
    // In-Oder traversals
    // For Graph the runtime is O(n + m)
    // where n is the number of nodes and
    // m is the number of edge
    // since Binary Tree is also a graph, the complexity is also
    // O(n + m)
    public static int height(Node root) {
        int count = 0;

        if (root.left != null)
            count = 1 + height(root.left);
        if (root.right != null)
            count = 1 + height(root.right);

        return count;
    }

    // O(n - n-1) with recursion and two count
    public static int heightWithTwoCount(Node root) {
        int left = 0, right = 0;

        if (root.left != null)
            left = 1 + height(root.left);

        if (root.right != null)
            right = 1 + height(root.right);

        return left > right ? left : right;
    }

    // O(n - n-1) with recursion library
    public static int heightWithMathMax(Node root) {
        if (root == null)
            return -1;
        else
            return 1 + Math.max( height(root.left), height(root.right) );
    }


    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) throws  IOException{
        Scanner scan = new Scanner(new File("src/com/ip_kit_sample_test_cases/tree_height_of_a_binary_tree/input/input00.txt"));
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
