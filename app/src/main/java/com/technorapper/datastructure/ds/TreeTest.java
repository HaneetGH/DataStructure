package com.technorapper.datastructure.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class TreeTest {


    public static void main(String[] args) {

        TreeNode treeNode = TreeTest();
        //  treeNode.printTree();

        int[] inorder = {9, 3, 15, 20, 7};

        int[] postordder = {9, 15, 7, 20, 3};
        //maxLevelSum1(treeNode);

       // buildTree(inorder, postordder);

        int[] array = {4,1,-1,2,-1,2,3};

        topKFrequent(array, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1)
            return nums;

        int[] result = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, (map.get(i)) + 1);
            } else {
                map.put(i, 1);
            }
        }




        int count = -1;

        Object[] a = map.entrySet().toArray();
        Arrays.sort(a, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        for (Object e : a) {


            result[++count]= ((Map.Entry<Integer, Integer>) e).getKey();
            if(count==k-1)
                break;
        }



        return result;
    }

    TreeNode root;

    public List<List<Integer>> getList(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();
        Stack<TreeNode> StackList = new Stack();
        Queue<TreeNode> QueueList = new LinkedList();

        while (QueueList.isEmpty() == false) {
            node = QueueList.peek();
            QueueList.remove();
            StackList.push(node);

            if (node.right != null)
                QueueList.add(node.right);

            if (node.left != null)
                QueueList.add(node.left);

            while (StackList.empty() == false) {
                node = StackList.peek();
                System.out.print(node.data + " ");
                System.out.print(node.data + " ");
                StackList.pop();
            }

        }
        return list;


    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    public static TreeNode TreeTest() {
        int[] array = {7, 0, 7, -8, 0, 0};
        TreeNode treeNode = new TreeNode(1);
        for (int i : array) {
            treeNode.insert(i);
        }
        return treeNode;
    }

    public static int maxLevelSum(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int level = 1;
        TreeNode rootLocal = root;
        while (rootLocal != null) {
            level++;
            sum = (rootLocal.left != null ? rootLocal.left.data : 0) + (rootLocal.right != null ? rootLocal.right.data : 0);
            map.put(level, sum);
            rootLocal = rootLocal.left;
        }

        map = sortByValue(map);

        return (new ArrayList<Integer>(map.keySet())).get(0);


    }

    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static int maxLevelSum1(TreeNode root) {
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

    static class Res {
        Integer level;
        Integer sum;

        public Res() {
        }

        public Res(Integer level, Integer sum) {
            this.level = level;
            this.sum = sum;
        }
    }

    static int rootindex = 0;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        rootindex = postorder.length - 1;
        return buildTreeRec1(inorder, 0, inorder.length - 1, postorder);
    }

    static private TreeNode buildTreeRec1(int[] inorder, int start, int end, int[] postorder) {
        if (start > end)
            return null;
        if (start == end)
            return new TreeNode(postorder[rootindex--]);
        TreeNode root = new TreeNode(postorder[rootindex--]);
        for (int i = start; i <= end; i++)
            if (inorder[i] == root.data) {
                root.right = buildTreeRec1(inorder, i + 1, end, postorder);
                root.left = buildTreeRec1(inorder, start, i - 1, postorder);
                return root;
            }
        return root;
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

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strArray = sentence.split(" ");

        for(int i = 0 ;i<strArray.length;i++)
        {

            if(searchWord.length() <= strArray[i].length())
            {
                if(strArray[i].startsWith(searchWord)) {
                    return i;
                }
            }
        }
        return 0;
    }
}