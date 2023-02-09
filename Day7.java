package Leetcode_problems;

public class Day7 {
    public static void main(String[] args) {
        int[] encoded = {1,2,3};
        int[] nums = deXor(encoded,1);
        for (int e:nums){
            System.out.println(e);
        }

        int[] pref = {5,2,0,3,1};
        pref = findOriginalArray(pref);
        for (int e:pref){
            System.out.println(e);
        }

        int num = 17;
        System.out.println(noOfStepsto0(14));

        int n = 5, start1 =0; // nums size & start number
        System.out.println(xoroperation(n,start1));

        int start = 10 , goal = 7;
        System.out.println(minimumbitflips(start,goal));
    }

    private static int minimumbitflips(int start, int goal) {
        int count=0,n=start^goal;
        while (n>0){
            count += n&1;
            n>>=1;
        }
        return count;
    }

    private static int xoroperation(int n, int start) {
        int[] ans = new int[n];
        for (int i=0;i<n;i++){
            ans[i] = start + 2*i;
        }
        int num=0;
        for (int e:ans){
            num ^= e;
        }
        return num;
    }

    private static int noOfStepsto0(int num) {
        int count =0;
        while (num!=0){
            if (num%2==1){
                num-=1;
            }
            else if (num%2==0) {
                num=num/2;
            }
            count++;
        }
        return count;
    }

    private static int[] findOriginalArray(int[] pref) {
        int [] ans = new int[pref.length];
        for (int i= pref.length-1;i>0;i--)
            pref[i] = pref[i]^pref[i-1];
        return pref;
    }

    private static int[] deXor(int[] encoded, int first) {
        if (encoded.length==0) return null;
        int[] ans = new int[encoded.length+1];
        ans[0] = first;
        for (int i=0;i< encoded.length;i++){
            int num = encoded[i]^first;
            ans[i+1] = num;
            first = num;
        }
        return ans;
    }

}
