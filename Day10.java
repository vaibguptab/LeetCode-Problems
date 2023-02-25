package Leetcode_problems;

import java.util.ArrayList;
import java.util.Collections;

public class Day10 {
    public static void main(String[] args) {
        int[] nums = {1,2,0,0};
        int k=34;
        ArrayList<Integer> ans = Q989(nums,k);
        for (int e: ans) System.out.print(e+" ");

        String a = "1010",b = "1011";
        System.out.println(Addbinary(a,b));

    }

    private static String Addbinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;

        while (i>=0||j>=0){
            int sum = carry;
            if (i>=0) sum+=a.charAt(i) -'0';
            if (j>=0) sum+=b.charAt(i) -'0';
            sb.append(sum%2);
            carry = sum/2;
            i--;
            j--;
        }
        if (carry!=0) sb.append(carry);
        return sb.reverse().toString();
    }

    private static ArrayList<Integer> Q989(int[] A, int K) {
        int N = A.length;
        int cur = K;
        ArrayList<Integer> ans = new ArrayList<>();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }
}
