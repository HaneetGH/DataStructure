package com.technorapper.datastructure.ds.newyear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArraysRelated {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) sum = 0;
        }

        return max;
    }


    //https://leetcode.com/problems/3sum/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        if (n > 0) {
            // sort the array so we have triplets in non-decreasing order
            Arrays.sort(nums);

            // if the last item of the array is less than 0, then no triplets exist
            if (nums[n - 1] < 0) return ans;

            for (int i = 0; i < n; i++) {
                int first = nums[i];
                int target = 0 - first;

                // if first is positive, then no triplets should exist
                if (first > 0) break;

                if (i == 0 || nums[i] != nums[i - 1]) {
                    // find 2 sum
                    int lo = i + 1;
                    int hi = n - 1;
                    while (lo < hi) {
                        int sum = nums[lo] + nums[hi];
                        if (sum == target) {
                            // add the triplet to ans
                            List<Integer> triplet = new ArrayList<>();
                            triplet.add(first);
                            triplet.add(nums[lo]);
                            triplet.add(nums[hi]);
                            ans.add(triplet);

                            // move lo and hi for more searches
                            while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                            while (lo < hi && nums[hi] == nums[hi - 1]) hi--;

                            // move lo and hi
                            lo++;
                            hi--;
                        } else if (sum < target) {
                            lo++;
                        } else {
                            hi--;
                        }
                    }
                }
            }
        }

        return ans;
    }

    static void minCost(int costs[][], int N) {

        // Corner Case
        if (N == 0)
            return;

        // Auxiliary 2D dp array
        int dp[][] = new int[N][3];

        // Base Case
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i = 1; i < N; i++) {

            // If current house is colored
            // with red the take min cost of
            // previous houses colored with
            // (blue and green)
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2])
                    + costs[i][0];

            // If current house is colored
            // with blue the take min cost of
            // previous houses colored with
            // (red and green)
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2])
                    + costs[i][1];

            // If current house is colored
            // with green the take min cost of
            // previous houses colored with
            // (red and blue)
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1])
                    + costs[i][2];
        }

        // Print the min cost of the
        // last painted house
        System.out.println(
                Math.min(dp[N - 1][0],
                        Math.min(dp[N - 1][1], dp[N - 1][2])));
    }

    static int maxProfit(int price[],
                         int n, int k) {

        int profit[][] = new int[k + 1][n + 1];
        for (int i = 0; i <= k; i++)
            profit[i][0] = 0;
        for (int j = 0; j <= n; j++)
            profit[0][j] = 0;
        for (int i = 1; i <= k; i++) {
            int prevDiff = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                prevDiff = Math.max(prevDiff,
                        profit[i - 1][j - 1] -
                                price[j - 1]);
                profit[i][j] = Math.max(profit[i][j - 1],
                        price[j] + prevDiff);
            }
        }

        return profit[k][n];
    }

    int solution(int[] costs) {
        int sizeofArray = costs.length;
        int inti = 3;
        int profitArray[][] = new int[inti + 1][sizeofArray + 1];

        for (int i = 0; i <= inti; i++)
            profitArray[i][0] = 0;

        for (int j = 0; j <= sizeofArray; j++)
            profitArray[0][j] = 0;

        for (int i = 1; i <= inti; i++) {

            int last = Integer.MIN_VALUE;

            for (int j = 0; j < sizeofArray; j++) {

                last = Math.max(last, profitArray[i - 1][j - 1] - costs[j - 1]);
                profitArray[i][j] = Math.max(profitArray[i][j - 1], costs[j] + last);
            }

        }

        return profitArray[inti][sizeofArray - 1];


    }

    // Driver code
    public static void main(String[] args) {


        int cost[][] = {{2, 9, 4}, {20, 7, 15}, {18, 12, 19}};
        int prcosts[] = {6, 5, 3, 7, 1, 4};
        //  maxProfit(cost, cost.length);
        maxProfit(prcosts, prcosts.length, 3);
    }


    public static void checkresult(float userresult) {
        float X = 15;
        float Y = 40;
        float Y_MAX = 100;
        float X_MIN = 0;
        float temp = 0;
        int result = 0;

        if (userresult < X) {
            temp = (userresult / (X - X_MIN));
            result = (int) (10 - temp);
        } else if (userresult >= X && userresult < Y) {
            temp = (userresult / (Y - X) * 10);
            result = (int) (10 - temp);
        } else if (userresult >= Y) {
            temp = (userresult / (Y_MAX - Y));
            result = (int) (10 - temp);
        }
        System.out.println("Result is:-" + result);
    }

    /*
    First I find the max height and its index in the array. If there are duplicates, I look for the first occurence.

    The max height and index helps split the problem into two halves left and right. It basically helped me find the stopping criteria for traversing the array (start -> max in forward direction and end to max in reverse direction).

    I keep storing the water trapped by incrementing the "water" variable if my current height is greater than the future height. So the water = currHeight - future height, and keep incrementing the futureheight (start or end) index till curr height is greater if not you reset it to the current height and repeat the same steps.

    Time: O(n)
    Space: O(1)
    */
    public static List<List<Integer>> ThreeSum(int[] nums, int val) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int newVal = val - nums[i];
            Set returnSet = createSetFromHere(nums[i], nums);
            for (int j = i; j < nums.length; j++) {
                int checkVal = newVal - nums[i + 1];

                if (returnSet.contains(checkVal)) {

                    smallList.add(nums[i]);
                    smallList.add(nums[i + 1]);
                    smallList.add(checkVal);
                    returnList.add(smallList);
                }

            }
        }
        return returnList;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int number = x;
        while (number != 0) {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number / 10;
        }
        return reverse == x;
    }

    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;
        int maximum = 0;

        for (int i = 0; i < s.length(); i++) {
            int left = i; // start with one letter
            int right = i;

            while (left - 1 >= 0 && right + 1 < s.length() &&
                    s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            if (left >= 0 && right < s.length() && right - left + 1 > maximum) {
                maximum = right - left + 1;
                start = left;
                end = right + 1;
            }

            left = i + 1; // start with two letter
            right = i;
            while (left - 1 >= 0 && right + 1 < s.length() &&
                    s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            if (left >= 0 && right < s.length() && right - left + 1 > maximum) {
                maximum = right - left + 1;
                start = left;
                end = right + 1;
            }
        }

        return s.substring(start, end);
    }

    private static Set createSetFromHere(int i, int[] nums) {
        Set set = new HashSet();
        for (int x = 0; x < nums.length; x++) {
            if (nums[x] != i)
                set.add(nums[x]);
        }
        return set;
    }

    public int solution1(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return A.length;
        }
        int startingIndex = 0;
        int endingIndex = 0;
        int[] locationVisitedCounter = new int[A.length];
        locationVisitedCounter[A[0] - 1] = 1;

        for (var i = 1; i < A.length; i++) {
            int locationIndex = A[i] - 1;

            locationVisitedCounter[locationIndex]++;

            if (A[i] == A[i - 1]) {
                continue;
            }

            endingIndex = i;

            while (locationVisitedCounter[A[startingIndex] - 1] > 1) {
                locationVisitedCounter[A[startingIndex] - 1]--;
                startingIndex++;
            }

        }

        return endingIndex - startingIndex + 1;
    }

    public int trap(int[] height) {

        int maxIndex = -1;
        int maxHeight = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }

        int start = 0;
        int water = 0;
        int curr = height[start];
        while (start < maxIndex) {
            if (curr > height[start + 1]) {
                water += (curr - height[start + 1]);
                start++;
            } else {
                start++;
                curr = height[start];
            }
        }

        int end = height.length - 1;
        curr = height[end];
        while (end > maxIndex) {
            if (curr > height[end - 1]) {
                water += (curr - height[end - 1]);
                end--;
            } else {
                end--;
                curr = height[end];
            }
        }

        return water;
    }
}
