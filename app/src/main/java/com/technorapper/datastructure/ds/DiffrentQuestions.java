package com.technorapper.datastructure.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiffrentQuestions implements sample,sample2 {

    public static void main(String[] args) {


        int[] arr = {2, 5, 10, 12, 15, 19, 22, 24};
        System.out.println(getArray(arr, 25));

        String str1 = "blahaaaablah";
        String str2 = "blah";
        printIndex(str1, str2);

    }




        static void printIndex(String str, String s)
        {

            boolean flag = false;
            for (int i = 0; i < str.length() - s.length() + 1; i++) {
                if (str.substring(i, i + s.length()).equals(s)) {
                    System.out.print(i + " ");
                    flag = true;
                }
            }

            if (flag == false) {
                System.out.println("NONE");
            }
        }






    public static void convert(String s) {

        // Initialize a variable
        int num = 0;
        int n = s.length();

        // Iterate till length of the string
        for (int i = 0; i < n; i++)

            // Subtract 48 from the current digit
            num = num * 10 + ((int) s.charAt(i) - 48);

        // Print the answer
        System.out.print(num);
    }


    static void printDiagonalSums(int[][] mat,
                                  int n) {
        int principal = 0, secondary = 0;
        for (int i = 0; i < n; i++) {
            principal += mat[i][i];
            secondary += mat[i][n - i - 1];
        }

        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(arr, 6));
    }


    public static int search(int[] nums, int target) {

        //first find the index of the minimum element
        int index = index(nums);

        //if no rotation is done, we can simply call binary serch on whole range of array
        if (index == 0) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        //if target is less than nums[0], that means we have to search in the increasing array after pivot element
        if (target < nums[0]) {
            return binarySearch(nums, target, index, nums.length - 1);
        } else {
            //search in increasing array before the pivot element
            return binarySearch(nums, target, 0, index);
        }
    }

    public static int binarySearch(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int index(int[] nums) {


        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static boolean isNumber(String s) {

        int size = s.length(), eCount = 0, ECount = 0, signCount = 0, dotCount = 0, indexE = -1, indexSign1 = -1, indexSign2 = -1, indexDot = -1;
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            if (c == 'e') {
                eCount++;
                indexE = i;
                if (eCount + ECount > 1) {
                    return false;
                }
            }
            if (c == 'E') {
                ECount++;
                indexE = i;
                if (eCount + ECount > 1) {
                    return false;
                }
            }
            if (c == '-' || c == '+') {
                signCount++;
                if (indexSign1 == -1) {
                    indexSign1 = i;
                } else if (indexSign2 == -1) {
                    indexSign2 = i;
                    if (indexSign2 == size - 1) {
                        return false;
                    }
                }
                if (signCount > 2) {
                    return false;
                }
            }
            if (c == '.') {
                dotCount++;
                indexDot = i;
                if (dotCount > 1) {
                    return false;
                }
            }
        }

        // no first sign or first sign is 0
        if (indexSign2 != -1 && indexSign1 != -1 && indexSign1 != 0) {
            return false;
        }

        // check e or E
        if (indexE >= 0) {
            if (indexSign1 != -1 && indexSign1 != 0 && indexSign1 < indexE) {
                return false;
            }
            if (indexSign1 > indexE) {
                indexSign2 = indexSign1;
                indexSign1 = -1;
            }
            if (indexE == 0 || indexE == size - 1 || (indexSign2 != -1 && indexSign2 != indexE + 1)) {
                return false;
            }
            int indexECopy = indexE;
            if (indexSign1 == indexE + 1 || indexSign2 == indexE + 1) {
                indexECopy++;
            }
            if (indexECopy == size - 1) {
                return false;
            }
            for (int i = indexECopy + 1; i < size; i++) {
                char temp = s.charAt(i);
                if (temp < '0' || temp > '9') {
                    return false;
                }
            }
        } else {
            if (signCount > 1 || indexSign1 > 0) {
                return false;
            }
        }

        // check decimal
        int firstIndex = indexSign1 + 1, endIndex = indexE >= 0 ? indexE - 1 : size - 1;
        if (endIndex < firstIndex) {
            return false;
        }
        if (indexDot != -1 && (endIndex == firstIndex || indexDot < firstIndex || indexDot > endIndex)) {
            return false;
        }
        for (int i = firstIndex; i <= endIndex; i++) {
            char c = s.charAt(i);
            if (c != '.' && (c < '0' || c > '9')) {
                return false;
            }
        }

        return true;
    }


    public static void checkThis() {

        {
            int[] arr = {1, 3, 4, 6, 8, 10};
            Map<Integer, Integer> map = new HashMap<>();
            int length = arr[arr.length - 1] - arr.length;
            int count = 0;
            ArrayList<Integer> newArr = new ArrayList<>();
            int initial = arr[0];
            for (int i : arr) {
                map.put(i, 1);
            }

            while (initial != arr[arr.length - 1]) {
                if (!map.containsKey(initial)) {
                    newArr.add(initial);
                }
                initial++;
                count++;

            }


            for (int i : newArr) {
                System.out.println(i + ", ");
            }

        }
    }

    // Returns minimum possible pairwise
    // absolute difference of two arrays.
    static long findMinSum(long a[], long b[], long n) {
        // Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Find sum of absolute differences
        long sum = 0;
        for (int i = 0; i < n; i++)
            sum = sum + Math.abs(a[i] - b[i]);

        return sum;
    }


    static int[] getArray(int[] a, int sum) {
        int[] newArr = new int[2];
        Set<Integer> valSet = new HashSet<>();
        int temp;
        for (int i : a) {
            valSet.add(i);
        }

        for (int x : a) {
            temp = sum - x;
            if (valSet.contains(temp)) {
                newArr[0] = x;
                newArr[1] = temp;
                break;
            }
        }

        return newArr;
    }


    @Override
    public void check() {

    }
}


