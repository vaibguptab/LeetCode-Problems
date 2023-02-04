package Leetcode_problems;

import java.util.Stack;

public class Day3 {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxnestingdepth(s));

        String s2 = "((()))(())";
        System.out.println(removeoutermost(s2));
    }

    private static String removeoutermost(String s2) {
        int count=0;
        boolean flag=true;
        String s ="";
        for (int i=0;i<s2.length();i++) {
            if(s2.charAt(i)=='(')
                count++;
            else if (s2.charAt(i)==')')
                count--;
            if (count==1 && flag==true){
                flag=false;
                continue;
            }
            if(count==0 && flag==false) {
                flag = true;
                continue;
            }
                s+=s2.charAt(i);
        }

        return s;
    }

    //Approach 1
    private static int maxnestingdepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max=0;
        int count=0;
        for (int i=0;i<s.length();i++){

            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                max=Math.max(max,++count);
            } else if (s.charAt(i)==')') {
                stack.pop();
                count--;
            }
        }
        return max;
        }

        // Approach 2
        public int maxDepth(String s) {
            int maxDepth = 0;
            int depth = 0;

            for (char character : s.toCharArray()) {
                if (character == '(') {
                    maxDepth = Math.max(maxDepth, ++depth);
                } else if (character == ')') {
                    depth--;
                }
            }
            return maxDepth;
        }
    }
//}
