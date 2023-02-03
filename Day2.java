package Leetcode_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class Day2 {

    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countnegativenumber(grid));

        int[][] mat = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        int[] ans = kweakestrows(mat,3);

        int[][] Q1380 = {{7,8},{1,2}};
        System.out.println(lucknumber(Q1380));
    }

    private static ArrayList<Integer> lucknumber(int[][] q1380) {
        ArrayList<Integer> res = new ArrayList<>();

        int m = q1380.length,n=q1380[0].length;
        for (int i=0;i<m;i++){
            Arrays.sort(q1380[i]);
        }
        int max=Integer.MIN_VALUE;
        for (int i=0;i<m;i++){

            if(q1380[i][0]>max){
                max = q1380[i][0];
            }
        }
        res.add(max);
        return res;
    }

    public static int[] kweakestrows(int[][] mat,int k){

        int m = mat.length,n=mat[0].length;
        int[] res = new int[mat.length];
        int[] kres = new int[k];
        int sum=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(mat[i][j]==1)sum+=1;
            }
            res[i] = sum;
            sum=0;
        }
        for (int i=0;i<k;i++){
            int min = Integer.MAX_VALUE;
            int minindex = 0;
            for (int j=0;j<mat.length;j++){
                if(res[j]<min){
                    min = res[j];
                    minindex = j;
                }
            }
            kres[i] = minindex;
            res[minindex] = Integer.MAX_VALUE;
        }
        return kres;
    }

    private static int countnegativenumber(int[][] grid) {
        int ans=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]<0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
