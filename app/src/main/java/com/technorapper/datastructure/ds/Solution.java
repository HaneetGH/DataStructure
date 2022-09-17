package com.technorapper.datastructure.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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


      /*  int[] price = {5, 7, 12, 14, 2, 3, 8};
        int sizeOfArray = price.length - 1;
        int startingPos = 0;

        System.out.println(givinMaxProfile(price, sizeOfArray, startingPos) + "");

        Parent aa = new Parent();
        Child bb = new Child();

        Parent ab = new Child();


        bb.getName();
        ab.getName();
        aa.getName();
*/
        int[][] str = {{2, 9, 4}, {20, 7, 15}, {18, 12, 19}};
        String s = "cbaebabacd", p = "abc";
        System.out.println(findAnagrams(s, p));


    }

    static int solutionc(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] matrix = new int[3][costs.length];

        for (int j = 0; j < costs.length; j++) {
            if (j == 0) {
                matrix[0][j] = costs[j][0];
                matrix[1][j] = costs[j][1];
                matrix[2][j] = costs[j][2];
            } else {
                matrix[0][j] = Math.min(matrix[1][j - 1], matrix[2][j - 1]) + costs[j][0];
                matrix[1][j] = Math.min(matrix[0][j - 1], matrix[2][j - 1]) + costs[j][1];
                matrix[2][j] = Math.min(matrix[0][j - 1], matrix[1][j - 1]) + costs[j][2];
            }
        }

        int result = Math.min(matrix[0][costs.length - 1], matrix[1][costs.length - 1]);
        result = Math.min(result, matrix[2][costs.length - 1]);

        return result;
    }



    public static List<Integer> findAnagramsHashmap(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int windowSize = p.length();
      //  HashMap<Character, Integer> hashmapOne = getHashMap(p);
        char[] sortedString = p.toCharArray();
        Arrays.sort(sortedString);
        for (int i = 0; i < s.length(); i++) {
            if (i+windowSize>s.length())
            {
                break;
            }
            String newString = s.substring(i, i + windowSize);
           // HashMap<Character, Integer> hashmapTwo = getHashMap(newString);
            char[] sortedString2 = newString.toCharArray();
            Arrays.sort(sortedString2);
            if (Arrays.equals(sortedString, sortedString2)) {
                result.add(i);
            }
        }
        return result;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<p.length();i++){
            map[p.charAt(i) - 'a']++;
        }

        int windowStart = 0;
        int windowEnd = 0;
        while(windowEnd<s.length()){
            // valid anagram
            if(map[s.charAt(windowEnd) - 'a'] > 0){
                map[s.charAt(windowEnd++) - 'a']--;
                // window size equal to size of P
                if(windowEnd-windowStart ==  p.length()){
                    result.add(windowStart);
                }
            }
            // window is of size 0
            else if(windowStart == windowEnd){
                windowStart ++;
                windowEnd ++;
            }
            // decrease window size
            else{
                map[s.charAt(windowStart++) - 'a']++;
            }
        }
        return result;
    }
    public static HashMap<Character, Integer> getHashMap(String str) {
        HashMap<Character, Integer> toBeMatch = new HashMap<>();
        for (Character character : str.toCharArray()) {
            if (!toBeMatch.containsKey(character)) {
                toBeMatch.put(character, 1);
            } else {
                toBeMatch.put(character, toBeMatch.get(character) + 1);
            }
        }
        return toBeMatch;
    }

    static int solutiondd(int[][] times) {
        if (times == null || times.length == 0) {
            return 0;
        }
        int[][] generator = new int[3][times.length];

        for (int i = 0; i < times.length; i++) {
            if (i == 0) {
                generator[0][i] = times[i][0];
                generator[1][i] = times[i][1];
                generator[2][i] = times[i][2];
            } else {
                generator[0][i] = Math.min(generator[1][i - 1], generator[2][i - 1] + times[i][0]);
                generator[1][i] = Math.min(generator[0][i - 1], generator[2][i - 1] + times[i][1]);
                generator[2][i] = Math.min(generator[0][i - 1], generator[1][i - 1] + times[i][2]);
            }

        }
        int result = Math.min(generator[0][times.length - 1], generator[1][times.length - 1]);
        result = Math.min(result, generator[2][times.length - 1]);

        return result;
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


    public static String concatArray(int[] arr) {
        String max = "";

        // Declare a hash array of
// size 10 and initialize
// all the elements to zero
        int[] hash = new int[10];

// store the number of occurrences
// of the digits in the given array
// into the hash table
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

// Traverse the hash in descending
// order to print the required number
        for (int i = 9; i >= 0; i--) {
            // Print the number of
            // times a digits occurs
            for (int j = 0; j < hash[i]; j++)
                max += i;
        }
        return max;
    }

    public int[] arrangeZeroAndOne(int[] arr) {

        int left = 0, right = arr.length - 1;

        while (left < right) {

            while (arr[left] == 0 && left < right)
                left++;


            while (arr[right] == 1 && left < right)
                right--;


            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }

        return arr;
    }


    /**
     * Reverse Elements in a collection -
     * INPUT - A string collection ["Ram", "Sardar", "John", "Jacob"]
     * OUTPUT - A string collection ["Jacob", "John", "Sardar", "Ram"]
     * <p>
     * Constraints -
     * 1. Do not use any loop, for or while.
     * 2. Create a recursive functions to reverse the order.
     * 3. Do not use another collection object, just reverse the order in the same collection
     */


    public static String[] reverseThis(String[] strArray, int first, int last) {

        if (first >= last)
            return strArray;
        String holder;


        holder = strArray[first];
        strArray[first] = strArray[last];
        strArray[last] = holder;

        //return reverseThis(strArray, ++first, --last);
        return reverseThis(strArray, first + 1, last - 1);

    }


}
