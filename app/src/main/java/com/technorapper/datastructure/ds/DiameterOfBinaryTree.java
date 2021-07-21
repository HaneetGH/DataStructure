package com.technorapper.datastructure.ds;

import java.util.ArrayList;

class DiameterOfBinaryTree {

    Node root;
    // Global static variable
    static int d1 = -1;
    static int d2 = -1;
    static int dist = 0;

    // Method to calculate the diameter and return it to
    // main
    int diameter(Node root) {
        // base case if tree is empty
        if (root == null)
            return 0;

        // get the height of left and right sub-trees
        int lheight = height(root.left);
        int rheight = height(root.right);

        // get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right subtree + 1
         */
        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
    }

    // A wrapper over diameter(Node root)
    int diameter() {
        return diameter(root);
    }

    int maxDia = 0;

    int diameterOfBinnaryTree(Node node) {

        dfs(node);

        return maxDia;
    }

    int dfs(Node node) {
        int left, right;
        if (node == null)
            return -1;
        left = dfs(node.left);
        right = dfs(node.right);

        maxDia = Math.max(maxDia, 2 + left + right);


        return 1 + Math.max(left, right);
    }

    // Returns level of key k if it is present
// in tree, otherwise returns -1
    static int findLevel(Node root, int k,
                         int level) {

        // Base Case
        if (root == null) {
            return -1;
        }

        // If key is present at root, or in left
        // subtree or right subtree, return true;
        if (root.value == k) {
            return level;
        }

        int l = findLevel(root.left, k, level + 1);
        return (l != -1) ? l : findLevel(root.right, k,
                level + 1);
    }

    public static Node findDistUtil(Node root, int n1,
                                    int n2, int lvl) {

        // Base case
        if (root == null) {
            return null;
        }

        // If either n1 or n2 matches with root's
        // key, report the presence by returning
        // root (Note that if a key is ancestor of
        // other, then the ancestor key becomes LCA
        if (root.value == n1) {
            d1 = lvl;
            return root;
        }
        if (root.value == n2) {
            d2 = lvl;
            return root;
        }

        // Look for n1 and n2 in left and right subtrees
        Node left_lca = findDistUtil(root.left, n1,
                n2, lvl + 1);
        Node right_lca = findDistUtil(root.right, n1,
                n2, lvl + 1);

        // If both of the above calls return Non-null,
        // then one key is present in once subtree and
        // other is present in other, So this node is the LCA
        if (left_lca != null && right_lca != null) {
            dist = (d1 + d2) - 2 * lvl;
            return root;
        }

        // Otherwise check if left subtree
        // or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static int findDistance(Node root, int n1, int n2) {
        d1 = -1;
        d2 = -1;
        dist = 0;
        Node lca = findDistUtil(root, n1, n2, 1);

        // If both n1 and n2 were present
        // in Binary Tree, return dist
        if (d1 != -1 && d2 != -1) {
            return dist;
        }

        // If n1 is ancestor of n2, consider
        // n1 as root and find level
        // of n2 in subtree rooted with n1
        if (d1 != -1) {
            dist = findLevel(lca, n2, 0);
            return dist;
        }

        // If n2 is ancestor of n1, consider
        // n2 as root and find level
        // of n1 in subtree rooted with n2
        if (d2 != -1) {
            dist = findLevel(lca, n1, 0);
            return dist;
        }
        return -1;
    }

    // The function Compute the "height" of a tree. Height
    // is the number of nodes along the longest path from the
    // root node down to the farthest leaf node.
    static int height(Node node) {
        // base case tree is empty
        if (node == null)
            return 0;

        // If tree is not empty then height = 1 + max of
        //  left height and right heights
        return (1
                + Math.max(height(node.left),
                height(node.right)));
    }

    // Driver Code
    public static void main(String args[]) {
        // creating a binary tree and entering the nodes
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // Function Call

        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(10);
        list.add(15);

        System.out.println(
                "The distanceBetween : "
                        + tree.check(list, 8)+"");
    }

    private int distanceBetween(int i, int i1) {


        return findDistance(root, i, i1);
    }


//[1, 3, 8, 10, 15]
    //key=12

    private int check(ArrayList<Integer> arr, int key) {
        int startIndex = 0;
        int sizeForIndexCal = 0;
        boolean isKeySearch = true;
        ArrayList<Integer> halfArray = new ArrayList<>();
        while (isKeySearch) {
            if (arr.get(arr.size() / 2) == key) {

                return arr.get(arr.size() / 2); // 1st false 2nd false  false
            } else if (arr.size() == 1) {

                return startIndex; // 1st false 2nd falsen 3nd true
            } else if (arr.get(arr.size() / 2) < key) {
                sizeForIndexCal = arr.size() / 2; // 3
                halfArray.addAll(arr.subList(arr.size() / 2 + 1, arr.size())); // true//
            } else if (arr.get(arr.size() / 2) > key) {
                sizeForIndexCal = 0;
                halfArray.addAll(arr.subList(0, arr.size() / 2));
            }
            startIndex = startIndex + sizeForIndexCal + 1;

            arr.clear();
            arr.addAll(halfArray);
            halfArray.clear();
        }
        return 0;


    }


}
