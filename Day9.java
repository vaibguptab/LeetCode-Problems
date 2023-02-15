package Leetcode_problems;

import java.util.*;

public class Day9 {
    public static void main(String[] args) {
        String jewels = "aA",stones = "bbbb";
        System.out.println(Q771_A1(jewels,stones));
        System.out.println(Q771_A2(jewels,stones));

        int[] nums = {1,2,3,1,1,3};
        System.out.println(Q1512(nums));

        int[] num = {8,1,2,2,3};
        num = Q1365(num);
        for (int e:num) System.out.print(e + " ");
    }

    private static int[] Q1365(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] copy = nums.clone();

        Arrays.sort(copy);

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copy[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            copy[i] = map.get(nums[i]);
        }

        return copy;

    }

    private static int Q1512(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            res += map.get(n) - 1;  // addtional pair can be formed btw n and all previous v == n;
        }
        return res;
    }

    private static int Q771_A2(String jewels, String stones) {
        int ans =0;
        for (char c:jewels.toCharArray()){
            for (char c1:stones.toCharArray()){
                if (c==c1)
                    ans++;
            }
        }
        return ans;
    }

    private static int Q771_A1(String jewels, String stones) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<jewels.length();i++){
            if (map.containsKey(jewels.charAt(i))){
                int value = map.get(jewels.charAt(i));
                map.put(jewels.charAt(i),value+1);
            }else {
                map.put(jewels.charAt(i),i);
            }
        }
        int ans= 0;
        for (Character ch :stones.toCharArray()){
            if (map.containsKey(ch)){
                ans++;
            }
        }
        return ans;
    }
}
