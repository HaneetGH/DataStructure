package com.technorapper.datastructure.ds;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class NextGreatest {

    /*
    Given a number n, find the smallest number that has same set of digits as n and is greater than n. If n is the greatest possible number with its set of digits, then print “not possible”.

    Examples:
    For simplicity of implementation, we have considered input number as a string.

    Input:  n = "218765"
    Output: "251678"

    Input:  n = "1234"
    Output: "1243"

    Input: n = "4321"
    Output: "Not Possible"

    Input: n = "534976"
    Output: "536479"



    algo
    1. start scan from right
    2. when found item smaller than current number
    3. swap that smaller item to 1 before the smamller item than smallest number in left to right scan
    4. sort them


     */
    // Utility function to swap two digit
    static void swap(char ar[], int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    // Given a number as a char array number[],
    // this function finds the next greater number.
    // It modifies the same array to store the result
    static void findNext(char ar[], int n) {
        int i;

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0) {
            System.out.println("Not possible");
        } else {
            int x = ar[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(ar, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(ar, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(ar[i]);
        }
    }




    public static void mergeTwoSortedList(int[] a, int[] b) {
        SortedSet<Integer> sortedSet = new TreeSet<>();

        for (Integer integer : a) {
            sortedSet.add(integer);
        }
        for (Integer integer : b) {
            sortedSet.add(integer);
        }


        System.out.println(sortedSet);


    }
    public static void main(String[] args) {
        int[] digits = {1, 4, 7, 8, 9, 13};
        int[] digits2 = {2, 4, 15, 18, 19, 20};
        int n = digits.length;
        //findNext(digits, n);
        mergeTwoSortedListWhile(digits, digits2);


    }

    public static void mergeTwoSortedListWhile(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        // Traverse both array
        while (i < n1 && j < n2) {
            // Check if current element of first
            // array is smaller than current element
            // of second array. If yes, store first
            // array element and increment first array
            // index. Otherwise do same with second array
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];


        System.out.println(arr3);


    }
}
