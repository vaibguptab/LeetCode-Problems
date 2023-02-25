package Leetcode_problems;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Day13 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
//        System.out.println(Q287(nums));

        String s1 = "aa",s2 = "aab";
//        System.out.println(Q383(s1,s2));

        int[] num = {1,1,2,3,3,4,4,8,8};
//        System.out.println(Q540(num));

        char[] s = {'h','e','l','l','o'};
        Q344(s);
        for (Character ch :s){
//            System.out.println(ch);
        }

        ArrayList<String> FizzBuzz = Q412(3);
        for(String str : FizzBuzz) System.out.println(str);
    }

    private static ArrayList<String> Q412(int n) {
        ArrayList<String> ans = new ArrayList<>(n);
        for (int i=1;i<=n;i++){
            if (i%3==0 && i%5==0) ans.add("FizzBuzz");
            else if (i%3==0) ans.add("Fizz");
            else if (i%5==0) ans.add("Buzz");
            else ans.add(String.valueOf(i));
        }
        return ans;
    }

    private static void Q344(char[] s) {
        int start = 0,end = s.length-1;
        while (start<end){
            char c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }

    private static int Q540(int[] num) {
        int start =0,end = num.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if ((mid%2==0 && num[mid]==num[mid+1]) || (mid%2==1 && num[mid]==num[mid-1])){
                start = mid+1;
            }
            else end = mid-1;
        }
        return num[start];
    }

    private static boolean Q383(String s1, String s2) {
        if (s1.length()>s2.length()) return false;
        int[] alphabet = new int[26];
        for (Character c : s2.toCharArray()){
            alphabet[c-'a']++;
        }
        for (Character ch : s1.toCharArray()){
            if (alphabet[ch-'a'] == 0) return false;
            alphabet[ch-'a']--;
        }
        return true;
    }

    private static int Q287(int[] nums) {
        if (nums.length==1 || nums.length==0) return -1;
        int n = nums.length;
        n = n*(n-1)/2;
        for (int e:nums){
            n = n-e;
            if (n==0) return e;
        }
        return -1;
    }
}
