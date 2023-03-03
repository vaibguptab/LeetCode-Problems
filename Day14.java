package Leetcode_problems;

public class Day14 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1};
        int days = 4;
        System.out.println(Q1011(arr,days));

        int[] arr2 = {7,1,5,3,6,4};
        System.out.println(Q121(arr2));
        System.out.println(Q121_2(arr2));
    }

    private static int Q121_2(int[] arr) {
        int i=0,j=1;
        int ans = Integer.MIN_VALUE;
        while (j<arr.length){
            if (arr[j]<arr[i]){
                i++;
                j=i+1;
            }
            else {
                if(arr[j]-arr[i]>0 && arr[j]-arr[i]>ans){
                    ans = arr[j]-arr[i];
                    j++;
                } else if (ans>arr[j]-arr[i]) {
                    j++;
                }
            }
        }
        return ans;
    }

    private static int Q121(int[] prices){
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }

    private static int Q1011(int[] arr, int days) {
        int start =0,end=0;
        for (int e :arr) end+=e;
        int res=-1;
        while (start<=end){
            int mid = start+(end-start)/2;
            if (isValid(arr,arr.length,days,mid)){
                res = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return res;
    }
    private static boolean isValid(int[] arr,int n,int days,int max){
        int totaldays = 1;
        int sum =0;
        for (int i=0;i<n;i++){
            sum += arr[i];
            if (sum>max){
                sum = arr[i];
                totaldays++;
            }
            if (arr[i]>max) return false;
        }
        if (totaldays>days) return false;
        else return true;
    }

}
