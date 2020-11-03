package com.technorapper.datastructure.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class Solution {
    public boolean findTarget(TreeNode root, int k) {

        int neededVal = k - root.data;
        if (printTree(root, neededVal)) {
            return true;
        } else
            return traverseTree(root, k);

    }
    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for(int n: nums)
            bitmask ^= n;

        int diff = bitmask&(-bitmask);

        int x = 0;
        for(int n: nums){
            if((diff&n) != 0)
                x ^= n;
        }

        return new int[]{x,bitmask^x};
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
                int neededVal = k - localTreee.left.data;
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
                    int neededVal = k - localTreee.right.data;
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

                if (localTreee.left.data == neededVal) {
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


                    if (localTreee.right.data == neededVal) {
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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;
        Res res = new Res();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        Integer level = 0;
        while(q.size()>0){
            level += 1;
            Queue<TreeNode> nxtq = new LinkedList<TreeNode>();
            Integer layerSum = 0;
            while(q.size()>0){
                TreeNode curNode = q.poll();
                layerSum += curNode.data;
                if(curNode.left!=null){
                    nxtq.offer(curNode.left);
                }
                if(curNode.right!=null){
                    nxtq.offer(curNode.right);
                }
            }
            if(res.sum!=null){
                if(layerSum > res.sum){
                    res = new Res((Integer)level, (Integer)layerSum);
                }
            }else{
                res = new Res(level, layerSum);
            }
            q = nxtq;
        }
        return res.level;
    }
}

class Res{
    Integer level;
    Integer sum;
    public Res(){
    }
    public Res(Integer level, Integer sum){
        this.level = level;
        this.sum = sum;
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
