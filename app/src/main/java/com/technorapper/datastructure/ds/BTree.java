package com.technorapper.datastructure.ds;


import java.util.Objects;

public class BTree {
    // Root of Binary Tree
    NodeB root;



    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(NodeB node)
    {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(NodeB node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(NodeB node)
    {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left sutree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    // Wrappers over above recursive functions
    void printPostorder()  {     printPostorder(root);  }
    void printInorder()    {     printInorder(root);   }
    void printPreorder()   {     printPreorder(root);  }

    // Driver method
    public static void main(String[] args)
    {
        BTree tree = new BTree();
        tree.root = new NodeB(1);
        tree.root.left = new NodeB(2);
        tree.root.right = new NodeB(3);
        tree.root.left.left = new NodeB(4);
        tree.root.left.right = new NodeB(5);

       // System.out.println("Preorder traversal of binary tree is ");
       // tree.printPreorder();

      //  System.out.println("\nInorder traversal of binary tree is ");
     //   tree.printInorder();

      //  System.out.println("\nPostorder traversal of binary tree is ");
       // tree.printPostorder();

        System.out.println(returnSol("xxyyxyxxyxyy")+"");
    }


    public static int returnSol(String s) {

        char[] str = s.toCharArray();

        int xnum = 0;
        int yNum = 0;

        for (char c : str) {
            if (c == 'x') {
                xnum++;
            } else if (c == 'y')
                yNum++;
        }

        if (xnum % 2 == 0 && yNum % 2 == 0) {
            if (xnum == yNum)
                return 1;
            else return 0;
        } else return 0;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 5;
    }
}
