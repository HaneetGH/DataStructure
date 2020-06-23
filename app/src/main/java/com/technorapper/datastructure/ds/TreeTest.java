package com.technorapper.datastructure.ds;

import java.util.Stack;

public class TreeTest {

 
    public static void main(String[] args) {

        TreeNode treeNode = TreeTest();
        treeNode.printTree();
    }


    public static TreeNode TreeTest() {
        int[] array = {5, 10, 2, 6, 1};
        TreeNode treeNode = new TreeNode(5);
        for (int i : array) {
            treeNode.insert(i);
        }
        return treeNode;
    }


}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;


    TreeNode(int data) {
        this.data = data;
    }

    public void printTree() {
        if (left != null) {
            left.printTree();
        }
        System.out.println(data);
        if (right != null) {
            right.printTree();
        }

    }

    public void insert(int val) {
        if (val <= data) {
            if (left == null)
                left = new TreeNode(val);
            else
                left.insert(val);
        } else {
            if (right == null)
                right = new TreeNode(val);
            else
                right.insert(val);
        }
    }


}