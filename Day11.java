package Leetcode_problems;

import javax.swing.tree.TreeNode;

//  Binary Search by Aditya verma
public class Day11 {
    public static void main(String[] args) {
        int[] arr1 = {20,17,15,14,13,12,10,9,8,4};
//        System.out.println(descendingsorted(arr1,4));

        int[] arr2 = {2,4,10,10,10,18,20};
//        System.out.println(firstoccurence(arr2,10));
//        System.out.println(lastoccurence(arr2,10));
//        System.out.println(lastoccurence(arr2,10) - firstoccurence(arr2,10) + 1);

        int[] arr7 = {10,12,2,4,6,8};
//        System.out.println(rotatedtimes(arr7));
//        System.out.println(finelementinRotatedSortedArray(arr7,12));

        int []arr9 = {5,10,30,20,40};
//        System.out.println(nearlysorted(arr9,40));

        int[] arr10 = {1,2,3,4,8,10,12,19};
//        System.out.println(floorOfelement(arr10,13));
//        System.out.println(ceilOfelement(arr10,13));

        Character[] arr12 = {'a','c','f','h'};
//        System.out.println(nextAlphabet(arr12,'f'));

        int[] arr15 = {1,3,8,10,15};
//        System.out.println(minimundifference(arr15,12));

        int[] arr17 = {1};
//        System.out.println(peakelement(arr17));
//        System.out.println(searchinbitonic(arr17,3));

        int[][] matrix = {{-4,-3,-1,3,5},{-3,-2,2,4,6},{-1,1,3,5,8},{3,4,7,8,9}};
        searchinsortedmatrix(matrix,3);
//        System.out.println(num[0]+" "+num[1]);

        // Flipkart Question
        //Allocate Minimum number of pages
        int[] arr = {10,20,30,40};
//        System.out.println(allocateminnumberofpage(arr,2));
    }

    private static int allocateminnumberofpage(int[] arr, int s) {
        if (arr.length<s) return -1;
        int start = 0;
        int end = 0;
        for (int e:arr) end+=e;
        int res = -1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (isvalid(arr,arr.length,s,mid)){
                res = mid;
                end = mid-1;
            }else start = mid+1;
        }
        return res;
    }
    public static boolean isvalid(int[] arr,int size,int k,int max){
        int student=1 ;
        int sum = 0;
        for (int i=0;i<size;i++){
            sum +=arr[i];
            if (sum>max) {
                student++;
                sum = arr[i];
            }
        }
        if (student>k){
            return false;
        }
         return true;
    }

    private static void searchinsortedmatrix(int[][] matrix, int k) {
        int i=0,j=matrix[0].length-1;
        int[] ans = new int[2];
        while (i>=0 && i< matrix.length && j>=0 && j<matrix[0].length){
            if (matrix[i][j] == k){
                System.out.println(i+","+j);
                j--;
            }
            else if (matrix[i][j] > k) j--;
            else if (matrix[i][j] < k) {
                i++;
            }
        }
    }

    private static int searchinbitonic(int[] arr, int k) {
        int index = peakelement(arr);
        return Math.max(BS(arr,0,index-1,k) ,BSdesc(arr,index,arr.length-1,k));

    }

    private static int BSdesc(int[] arr, int start, int end, int k) {
        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid]==k) return mid;
            else if (arr[mid]<k) {
                end = mid-1;
            }else start = mid+1;
        }
        return -1;
    }

    private static int peakelement(int[] arr) {
        int start = 0,end = arr.length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (mid>0 && mid<arr.length-1){
                if (arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
                else if (arr[mid-1] > arr[mid]) {
                    end = mid-1;
                }else start = mid+1;
            } else if (mid==0) {
                if (arr[0]>arr[1]) return 0;
                else return 1;
            } else if (mid== arr.length-1) {
                if (arr[arr.length-1]>arr[arr.length-2]) return arr.length-1;
                else return arr.length-2;
            }
        }
        return -1;
    }

    private static int minimundifference(int[] arr, int k) {
        int start = 0,end = arr.length-1;
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (arr[mid]==k) return arr[mid];
            else if (arr[mid]<k) {
                start = mid+1;
            }else end = mid-1;
        }
        if (arr[start]-k < arr[end]-k) return arr[start];
        else return arr[end];
    }

    private static char nextAlphabet(Character[] arr, char k) {
        int start = 0,end = arr.length-1;
        Character res = '#';
        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid] == k) start = mid+1;
            if (arr[mid]>k) {
                res = arr[mid];
                end = mid - 1;
            }
            if (arr[mid]<k){
                start = mid+1;
            }
        }
        return res;
    }

    private static int floorOfelement(int[] arr, int k) {
        int start = 0,end = arr.length-1;
        int res = Integer.MIN_VALUE;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid] == k) return mid;
            if (arr[mid]>k) end = mid-1;
            if (arr[mid]<k){
                res = Math.max(res,mid);
                start = mid+1;
            }
        }
        return res;
    }
    private static int ceilOfelement(int[] arr, int k) {
        int start = 0,end = arr.length-1;
        int res = Integer.MAX_VALUE;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid] == k) return mid;
            if (arr[mid]>k) {
                res = Math.min(res,mid);
                end = mid - 1;
            }
            if (arr[mid]<k){
                res = Math.max(res,mid);
                start = mid+1;
            }
        }
        return res;
    }

    private static int nearlysorted(int[] arr, int k) {
        int start = 0,end = arr.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (k==arr[mid]) return mid;
            if (mid-1>=start && arr[mid-1]==k) return mid-1;
            if (mid+1<=end && arr[mid+1]==k) return mid+1;
            if (arr[mid]<k) start = mid+2;
            if (arr[mid]>k) end = mid-2;
        }
        return -1;
    }

    public static int finelementinRotatedSortedArray(int[] arr,int k){
        int index = rotatedtimes(arr);
        return Math.max(BS(arr,0,index-1,k) ,BS(arr,index,arr.length-1,k));
    }
    public static int BS(int []arr,int start,int end,int k){
        while (start<=end){
            int mid = start + (end-start)/2;
            if (arr[mid]==k) return mid;
            else if (arr[mid]>k) {
                end = mid-1;
            }else start = mid+1;
        }
        return -1;
    }

    private static int rotatedtimes(int[] arr) {
        int start = 0,end = arr.length-1;
        while (start<=end){
            int mid = start +(end-start)/2;
            if (arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]) return mid;
            else if (arr[mid]<arr[mid+1] && arr[mid]>arr[mid-1]) end = mid-1;
            else if (arr[mid]>arr[mid+1] && arr[mid]<arr[mid-1]) start = mid+1;
            else return mid+1;
        }
        return -1;
    }

    private static int lastoccurence(int[] arr, int k) {
        int start = 0,end = arr.length-1;
        int res=0;
        while (start<=end){
            int mid = start + (end - start)/2;
            if (arr[mid] == k) {
                res = mid;
                start = mid+1;
            } else if (arr[mid] < k) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return res;
    }

    private static int firstoccurence(int[] arr, int k) {
        int start = 0,end = arr.length-1;
        int res=0;
        while (start<=end){
            int mid = start + (end - start)/2;
            if (arr[mid] == k) {
                res = mid;
                end = mid-1;
            } else if (arr[mid] < k) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return res;
    }

    private static int descendingsorted(int[] arr1, int i) {
        int start = 0,end = arr1.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if (i==arr1[mid]) return mid;
            else if (arr1[mid] > i) {
                start = mid+1;
            }
            else
                end = mid-1;
        }
        return -1;
    }
}
