package Leetcode_problems;

import java.util.ArrayList;

public class Day15 {
    public static void main(String[] args) {
        String s = "abc";
        Permutations(s);

        String number = "23";
        System.out.println(LetterCombination(number));

        int dicesum = 4;
        NoOfDieRollWithTargetSum(dicesum);

        int row = 3,col=3;
//        System.out.println(count(row,col));
//        Printpaths(row,col);

//        PrintpathsDiagonal(row,col,"");

        boolean[][] maze = {
                {true,true,true},{true,true,true},{true,true,true}
        };
//        PrintpathsWithObstacle(0,0,"",maze);

        PrintpathsAnyDirection(0,0,maze,"");
    }

    private static void PrintpathsAnyDirection(int row, int col,boolean[][] maze,String p) {
        if (row== maze.length-1 && col==maze[0].length-1) {
            System.out.println(p);
            return;
        }
        if (!maze[row][col]) return;

        //i am considering this block in my path
        maze[row][col] = false;

        if (row<maze.length-1){
            PrintpathsAnyDirection(row+1,col,maze,p+'D');
        }
        if (col<maze[0].length-1) {
            PrintpathsAnyDirection(row,col+1,maze,p+'R');
        }
        if (row>0)
            PrintpathsAnyDirection(row-1,col,maze,p+'U');
        if (col>0)
            PrintpathsAnyDirection(row,col-1,maze,p+'L');

        //here this line is where the function will be over
        // so be4 the function gets removed, also remove the changes that were made by the function
        maze[row][col] = true;
    }

    private static void PrintpathsWithObstacle(int row, int col, String p,boolean[][] maze) {
        if (row== maze.length-1 && col==maze[0].length-1) {
            System.out.println(p);
            return;
        }
        if (!maze[row][col]) return;
        if (row<maze.length-1){
            PrintpathsWithObstacle(row+1,col,p+'D',maze);
        }
        if (col<maze[0].length-1) {
            PrintpathsWithObstacle(row,col+1,p+'R',maze);
        }
    }

    private static void PrintpathsDiagonal(int row, int col, String p) {
        if (row==1 && col==1) {
            System.out.print(p+" " );
            return;
        }
        if (row>1){
            PrintpathsDiagonal(row-1,col,p+'D');
        }
        if (col>1) {
            PrintpathsDiagonal(row,col-1,p+'R');
        }
        if (row>1 && col>1){
            PrintpathsDiagonal(row-1,col-1,p+'T');
        }
    }

    private static void Printpaths(int row, int col) {
        String p = "";
        Printpaths(row,col,p);
    }

    private static void Printpaths(int row, int col, String p) {
        if (row==1 && col==1) {
            System.out.println(p);
            return;
        }
        if (row>1){
            Printpaths(row-1,col,p+'D');
        }
        if (col>1) {
            Printpaths(row,col-1,p+'R');
        }
    }

    private static int count(int row, int col) {
        if (row==1 || col==1) return 1;

        int left = count(row-1,col);
        int right = count(row,col-1);

        return left+right;
    }

    static int[] dice = {1,2,3,4,5,6};
    private static void NoOfDieRollWithTargetSum(int sum) {
        String p = "";
        dieQhelper(p,sum);
    }

    private static void dieQhelper(String p, int sum) {
        if (sum==0){
            System.out.println(p);
            return;
        }

        for (int i=1;i<=6 && i<=sum;i++){
            dieQhelper(p+i,sum-i);
        }
    }

    static String[] digit = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static ArrayList<String> LetterCombination(String number) {
        ArrayList<String> ans = new ArrayList<>();
        if (number.length()==0) return ans;
        backtrack(number,0,digit,new StringBuilder(),ans);
        return ans;
    }

    private static void backtrack(String number, int i, String[] digit, StringBuilder sb, ArrayList<String> ans) {
        if (i== number.length()){
            ans.add(sb.toString());
            return;
        }
        String curr = digit[Integer.parseInt(String.valueOf(number.charAt(i)))];
        for (int k=0;k<curr.length();k++){
            sb.append(curr.charAt(k));
            backtrack(number,i+1,digit,sb,ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static void Permutations(String s) {
        String p = "";
        Permutations(p,s);
    }


    private static void Permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.print(p+" ");
            return;
        }
        Character ch = up.charAt(0);
        for (int i=0;i<=p.length();i++){
            String f = p.substring(0,i);
            String l = p.substring(i,p.length());
            Permutations(f+ch+l,up.substring(1));
        }
    }
}
