package com.technorapper.datastructure.ds;

import java.util.Stack;


class Solution {
    public boolean findTarget(TreeNode root, int k) {

        int neededVal = k - root.val;
        if (printTree(root, neededVal)) {
            return true;
        } else
            return traverseTree(root, k);

    }

    private static boolean traverseTree(TreeNode treeNode, int k) {
        TreeNode localTreee = treeNode;
        boolean isTrueo = false;
        Stack<TreeNode> visitedNode = new Stack<>();
        Stack<TreeNode> AlreadyVisitedNode = new Stack<>();
        AlreadyVisitedNode.push(treeNode);
        visitedNode.push(treeNode);

        while (localTreee != null) {


            if (!AlreadyVisitedNode.contains(localTreee.left) && localTreee.left != null) {

                visitedNode.push(localTreee.left);
                AlreadyVisitedNode.push(localTreee.left);
                int neededVal = k - localTreee.left.val;
                localTreee = localTreee.left;

                if (printTree(treeNode, neededVal)) {
                    isTrueo = true;
                }
            } else {
                if (!visitedNode.empty())
                    localTreee = visitedNode.pop();
                else
                    localTreee = null;
                if (localTreee != null && localTreee.right != null && !AlreadyVisitedNode.contains(localTreee.right)) {


                    visitedNode.push(localTreee.right);
                    AlreadyVisitedNode.push(localTreee.right);
                    int neededVal = k - localTreee.right.val;
                    localTreee = localTreee.right;

                    if (printTree(treeNode, neededVal)) {
                        isTrueo = true;
                    }
                }
            }
        }

        return isTrueo;

    }

    private static boolean printTree(TreeNode treeNode, int neededVal) {
        TreeNode localTreee = treeNode;
        boolean isFound = false;
        Stack<TreeNode> visitedNode = new Stack<>();
        Stack<TreeNode> AlreadyVisitedNode = new Stack<>();
        AlreadyVisitedNode.push(treeNode);
        visitedNode.push(treeNode);

        while (localTreee != null) {
            int val = 0;


            if (!AlreadyVisitedNode.contains(localTreee.left) && localTreee.left != null) {

                if (localTreee.left.val == neededVal) {
                    isFound = true;
                }

                visitedNode.push(localTreee.left);
                AlreadyVisitedNode.push(localTreee.left);
                localTreee = localTreee.left;
            } else {
                if (!visitedNode.empty())
                    localTreee = visitedNode.pop();
                else
                    localTreee = null;
                if (localTreee != null && localTreee.right != null && !AlreadyVisitedNode.contains(localTreee.right)) {


                    if (localTreee.right.val == neededVal) {
                        isFound = true;
                    }
                    visitedNode.push(localTreee.right);
                    AlreadyVisitedNode.push(localTreee.right);
                    localTreee = localTreee.right;
                }
            }
        }

        return isFound;


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
