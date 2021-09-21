package com.technorapper.datastructure.ds;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;


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
        for (int n : nums)
            bitmask ^= n;

        int diff = bitmask & (-bitmask);

        int x = 0;
        for (int n : nums) {
            if ((diff & n) != 0)
                x ^= n;
        }

        return new int[]{x, bitmask ^ x};
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
        if (root == null) return 0;
        Res res = new Res();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        Integer level = 0;
        while (q.size() > 0) {
            level += 1;
            Queue<TreeNode> nxtq = new LinkedList<TreeNode>();
            Integer layerSum = 0;
            while (q.size() > 0) {
                TreeNode curNode = q.poll();
                layerSum += curNode.data;
                if (curNode.left != null) {
                    nxtq.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nxtq.offer(curNode.right);
                }
            }
            if (res.sum != null) {
                if (layerSum > res.sum) {
                    res = new Res((Integer) level, (Integer) layerSum);
                }
            } else {
                res = new Res(level, layerSum);
            }
            q = nxtq;
        }
        return res.level;
    }
}

class Res {
    Integer level;
    Integer sum;

    public Res() {
    }

    public Res(Integer level, Integer sum) {
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


class A {
    int x;

    public static void main(String[] args) {


        int[] price = {5, 7, 12, 14, 2, 3, 8};
        int sizeOfArray = price.length - 1;
        int startingPos = 0;

        System.out.println(givinMaxProfile(price, sizeOfArray, startingPos) + "");

        Parent aa = new Parent();
        Child bb = new Child();

        Parent ab = new Child();


        bb.getName();
        ab.getName();
        aa.getName();


    }
    public static class Parent {
        public void getName() {

        }
    }

    public static class Child extends Parent {
        public void getName() {

        }
    }
    static int josephus(int n, int k) {
        if (n == 1)
            return 1;
        else

            return (josephus(n - 1, k) + k - 1) % n + 1;

        //Joseph Current josephus(n - 1, k) will change sward with  k - 1 and % n + 1 cause happeing in circle


    }


    static int givinMaxProfile(int[] price, int sizeOfArray, int startingPos) {

        if (sizeOfArray >= startingPos) return 0;
        int maxWhichHeCanBuild = 0;
        for (int i = startingPos; i < sizeOfArray; i++) {


            for (int j = i + 1; j <= sizeOfArray; j++) {

                if (price[j] > price[i]) {

                    int maxiMumResult = price[j] - price[i] + givinMaxProfile(price, startingPos, i - 1) + givinMaxProfile(price, j + 1, sizeOfArray);

                    maxWhichHeCanBuild = Math.max(maxWhichHeCanBuild, maxiMumResult);
                }

            }


        }

        return maxWhichHeCanBuild;


    }

    static int givinMaxProfile1(int[] price, int sizeOfArray, int startingPos) {

        if (sizeOfArray <= startingPos) return 0;
        int maxWhichHeCanBuild = 0;
        for (int i = 1; i < sizeOfArray; i++) {


            if (price[i] > price[i - 1]) {

                maxWhichHeCanBuild += price[i] - price[i - 1];


            }


        }

        return maxWhichHeCanBuild;


    }
/*
Test case 1
Input : "a-bC%dEf-ghIj"
Output : "j-Ih%gfE-dCba"

*/

    public void reverse(String str) {
        char[] strArray = str.toCharArray();

        int right = strArray.length - 1;
        int left = 0;

        while (left < right) {

            if (!Character.isAlphabetic(strArray[left])) {
                left++;
            } else if (!Character.isAlphabetic(strArray[right]))
                right--;

            else {
                char tempChar = strArray[left];
                strArray[left] = strArray[right];
                strArray[right] = tempChar;
                left++;
                right--;

            }
        }

    }



}
