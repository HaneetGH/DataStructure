package com.technorapper.datastructure.ds;

public class DiffrentQuestions {

    public static void main(String[] args) {


        // Given string of number
        String s = "123";

        // Function Call
       // convert(s);


        int [][]a = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 } };

        printDiagonalSums(a, 4);
    }

    public static void convert(String s)
    {

        // Initialize a variable
        int num = 0;
        int n = s.length();

        // Iterate till length of the string
        for(int i = 0; i < n; i++)

            // Subtract 48 from the current digit
            num = num * 10 + ((int)s.charAt(i) - 48);

        // Print the answer
        System.out.print(num);
    }




    static void printDiagonalSums(int [][]mat,
                                  int n)
    {
        int principal = 0, secondary = 0;
        for (int i = 0; i < n; i++) {
            principal += mat[i][i];
            secondary += mat[i][n - i - 1];
        }

      int[] arr= {4,5,6,7,0,1,2};
        System.out.println(search(arr,6));
    }


    public static  int search(int[] nums, int target) {

        //first find the index of the minimum element
        int index = index(nums);

        //if no rotation is done, we can simply call binary serch on whole range of array
        if(index == 0){
            return binarySearch(nums, target, 0, nums.length-1);
        }

        //if target is less than nums[0], that means we have to search in the increasing array after pivot element
        if(target < nums[0]){
            return binarySearch(nums, target, index, nums.length-1);
        }
        else{
            //search in increasing array before the pivot element
            return binarySearch(nums, target, 0, index);
        }
    }

    public static int binarySearch(int[] nums, int target, int left, int right){

        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right=  mid-1;
            }
        }

        return -1;
    }
    public static int index(int[] nums){


        if(nums.length == 1 || nums[0] < nums[nums.length-1]){
            return 0;
        }

        int left = 0;
        int right = nums.length-1;

        while(left <= right){

            int mid = left + (right - left)/2;

            if(nums[mid] > nums[mid+1]){
                return mid+1;
            }
            if(nums[mid] < nums[mid-1]){
                return mid;
            }

            if(nums[mid] > nums[0]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }

}
