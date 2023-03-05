package Leetcode_problems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Day16 {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        arr = Reshape(arr,1,4);
        for (int i=0;i< arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
//                System.out.print(arr[i][j] + "");
            }
//            System.out.println();
        }

        String haystack = "sadbhutsad";
        String needle = "sad";
//        System.out.println(haystack.substring(0,0+3));
//        System.out.println(Q28(haystack,needle));

        int[] nums = {1,3,5,6};
//        System.out.println(Q35(nums,9));

        int[] nums1 = {10,20,30,40,50}, nums2 = {2,15,25,27,28,55,65,75,85};
        System.out.println(Q4(nums1,nums2));
    }

    private static double Q4(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 < N2) return Q4(nums2, nums1);	// Make sure A2 is the shorter one.

        int lo = 0, hi = N2 * 2;
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;   // Try Cut 2
            int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE: nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
            double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE: nums1[(mid1)/2];
            double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE : nums2[(mid2)/2];

            if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
            else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
            else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
        }
        return -1;
    }

    private static int Q35(int[] arr,int k) {
        int start = 0,end = arr.length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (arr[mid]==k) return mid;
            else if (arr[mid]<k) {
                start = mid+1;
            } else if (arr[mid] > k) {
                end = mid-1;
            }
        }
        return start;
    }

    private static int Q28(String haystack, String needle) {
        for (int i=0;i< haystack.length()- needle.length()+1 ;i++){
            if (haystack.charAt(i)==needle.charAt(0)){
                if (haystack.substring(i,i+ needle.length()).equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    private static int[][] Reshape(int[][] mat, int r, int c) {
        int rows = mat.length;
        int cols = mat[0].length;

        if((rows * cols) != (r * c)) return mat;

        int[][] output = new int[r][c];
        int output_rows = 0;
        int output_cols = 0;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                output[output_rows][output_cols] = mat[i][j];
                output_cols++;
                if(output_cols == c)
                {
                    output_cols = 0;
                    output_rows++;
                }
            }
        }

        return output;
    }
}
