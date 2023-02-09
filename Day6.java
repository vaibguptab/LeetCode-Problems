package Leetcode_problems;

public class Day6 {
    //Recursion Practice
    public static void main(String[] args) {
        String up = "baccadh";
        skip("",up);
        System.out.println(skip(up));

        //Skip A string Apple
        String s = "bcdapplefr";
        skipApple("" , s);
        System.out.println(5&5);
    }

    private static void skipApple(String p,String s) {
        if (s.isEmpty()) {
            System.out.println(p);
            return;
        }
        if (s.startsWith("Apple"))
            skipApple(p,s.substring(1));
        else
            skipApple(p,s.substring(1));
    }

    private static String skip(String up) {
        if (up.isEmpty()) return "";
        char ch = up.charAt(0);
        if (ch=='a')
            return skip(up.substring(1));
        else
            return ch + skip(up.substring(1));
    }

    private static void skip(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch=='a')
            skip(p,up.substring(1));
        else
            skip(p+ch,up.substring(1));
    }
}
