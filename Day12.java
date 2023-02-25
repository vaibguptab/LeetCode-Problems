package Leetcode_problems;

import java.util.*;

public class Day12 {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
//        System.out.println(Q35(arr,7));

        int[] nums = {3,0,1};
//        System.out.println(Q268(nums));

        int n = 5;
//        System.out.println(Q278(n));

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//        int[] ans = intersection(nums1,nums2);
//        for (int e: ans) System.out.print(e+" ");

        int[] prices = {2,4,1};
        System.out.println(Q121(prices));
    }

    private static int Q121(int[] prices) {
        if (prices.length==0) return 0;
        int n = Integer.MAX_VALUE;
        int index=0;
        for (int i=0;i<prices.length;i++) {
            n = Math.min(n,prices[i]);
            if (n==prices[i]) index = i;
        }
        if (index!= prices.length-1){
            int m = Integer.MIN_VALUE;
            for (int i = index; i < prices.length; i++) {
                m = Math.max(m, prices[i]);
            }
            return m-n;
        }

        else if (index== prices.length-1){
            int[] newa = new int[prices.length-1];
            for (int i=0;i< prices.length-1;i++) newa[i] = prices[i];
            return Q121(newa);
        }else
            return 0;
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int top = 0;
        int bottom = 0;
        ArrayList<Integer> h = new ArrayList<>();

        while (true){
            if (top >= nums1.length || bottom >= nums2.length){
                break;
            }
            if (nums1[top] == nums2[bottom]){
                h.add(nums1[top]);
                top ++;
                bottom ++;
            }
            else if (nums1[top] < nums2[bottom]){
                top ++;
            }
            else if (nums1[top] > nums2[bottom]){
                bottom ++;
            }
        }

        int[] g = new int[h.size()];
        for (int i = 0; i < h.size(); i++) {
            g[i] = h.get(i);
        }
        return g;
    }

    private static int Q278(int n) {
        int start = 1,end = n;
        int res = 0;
        while (start<=end) {
            int mid = start + (end-start)/2;
            if (isBadVersion(mid)){
                res = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return res;
    }
    public static boolean isBadVersion(int n){
        return n==4;
    }
    private static int Q268(int[] arr) {
        int n = arr.length;
        int sum = n*(n+1)/2;
        for (int e:arr) sum = sum - e;
        return sum;
    }

    private static int Q35(int[] arr, int k) {
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
}
