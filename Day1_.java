package Leetcode_problems;

import java.util.Arrays;

public class Day1_ {

    public static void main(String[] args) throws ArrayStoreException {
        int[][] arr = {{1,5},{7,3},{3,5}};
//        System.out.println(richest(arr));

        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        System.out.println(largestlocal(grid));

        int[][] matrix = {{1,2,4},{3,3,1}};
        System.out.println(deletegreatest(matrix));

        int[][] Q832 = {{1,1,0},{1,0,1},{0,0,0}};
        Q832 = flipimage(Q832);
        for (int i=0;i< Q832.length;i++){
            for (int j=0;j<Q832[0].length;j++){
                System.out.print(Q832[i][j] + " ");
            }
            System.out.println();
        }

        int[][] Q1572 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(matrixdiagonalsum(Q1572));
    }

    private static int matrixdiagonalsum(int[][] q1572) {
        int n=q1572.length;
        int sum =0;
        for (int i=0;i<n;i++){
            sum += q1572[i][i] + q1572[i][n-1-i];
        }
        if(n%2==1){
            sum = sum - q1572[n/2][n/2];
        }
        return sum;
    }

    private static int[][] flipimage(int[][] q832) {
        int n=q832.length;
        int[][] result = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=n-1;j>=0;j--){
                if(q832[i][j]==1)
                    result[i][n-1-j] = 0;
                else
                    result[i][n-1-j] = 1;
            }
        }
        return q832;
    }

    private static int deletegreatest(int[][] matrix) {
        for (int i=0;i< matrix.length;i++){
            Arrays.sort(matrix[i]);
        }
        int ans=0;
        for (int i=0;i<matrix[0].length;i++){
            int maxi = Integer.MIN_VALUE;
            for (int j=0;j< matrix.length;j++){
                maxi = Math.max(maxi,matrix[j][i]);
            }
            ans += maxi;
        }
        return ans;
    }

    private static int[][] largestlocal(int[][] grid) throws ArrayStoreException {
        if(grid.length<=2){
             throw new ArrayStoreException();
        }
        int n = grid.length;
        int[][] result = new int[n-2][n-2];

        for (int i=0;i<n-2;i++){
            for (int j=0;j<n-2;j++){
                result[i][j] = findmax(grid,i,j);
            }
        }
        return result;
    }

    private static int findmax(int[][] grid, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int x=i;x<i+3;x++){
            for (int y=j;y<j+3;y++){
                max = Math.max(max,grid[x][y]);
            }
        }
        return max;
    }

    private static int richest(int[][] arr) {
        int result = Integer.MIN_VALUE;
        for (int i =0;i<arr.length;i++){
            int num = arr[i][0];
            for (int j=1;j<arr[0].length;j++){
                num += arr[i][j];

            }result = Math.max(result,num);
        }
        return result;
    }
}
