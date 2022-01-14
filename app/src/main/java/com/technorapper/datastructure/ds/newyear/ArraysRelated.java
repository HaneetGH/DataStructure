package com.technorapper.datastructure.ds.newyear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysRelated {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);

            if(sum<0) sum = 0;
        }

        return max;
    }






    //https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
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

                if (i == 0 || nums[i] != nums[i-1]) {
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
                            while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                            while (lo < hi && nums[hi] == nums[hi-1]) hi--;

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

    // Driver code
    public static void main(String[] args) {


        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
}
