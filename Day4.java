package Leetcode_problems;

import L_list.Node;
import com.sun.source.tree.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import static L_list.LL_take_Input.takeinputof_On;
import static L_list.LL_take_Input.print;

public class Day4 {
    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,2,3};
        System.out.println(maxcount(nums));

        int[] num = {1,2,5,2,3};
        ArrayList<Integer> ans = findtarget(num,5);
        for (int e:ans){
            System.out.println(e);
        }

        int[][] matrix = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(matrix));

        int[] number = {4,5,2,1};
        int[] queries = {3,10,2,1};
        int[] ans1 = intersection(number,queries);

        Node<Integer> head = takeinputof_On();
        System.out.println(convertbinarytonumber(head));

        Node<Integer> head1 = takeinputof_On();
        head1 = middlenode(head1);
        print(head1);

        Node<Integer> head2 = takeinputof_On();
        head2 = reverseLL(head2);
        print(head2);
    }

    private static Node<Integer> reverseLL(Node<Integer> head) {
        if (head == null || head.next==null){
            return head;
        }
        Node<Integer> curr= head,prev=null;
        while (curr!=null){
            Node<Integer> temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private static Node<Integer> middlenode(Node<Integer> head1) {
        Node<Integer> slow = head1,fast =head1.next;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }

    private static int convertbinarytonumber(Node<Integer> head) {
        int ans=0;
        while (head!=null){
            if (ans!=0){
                ans= ans*2;
            }
            ans+= head.data*1;
            head = head.next;
        }
        return ans;
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;

    }


    public static int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0, lastNeg = cols - 1;
        for (int row = 0; row < rows; row++) {
            if (grid[row][0] < 0) {
                res+=cols;
                continue;
            }if (grid[row][cols - 1] > 0)
                continue;
            int l = 0, r = lastNeg;
            while (l <= r) {
                int m = l + (r - l)/2;
                if (grid[row][m] < 0) {
                    r = m - 1;
                } else
                    l = m + 1;
            }
            res += (cols - l); lastNeg = l;
        }
        return res;
    }

    private static ArrayList<Integer> findtarget(int[] nums, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i< nums.length;i++){
            if (nums[i]==k) ans.add(i);
        }
        return ans;
    }

    private static int maxcount(int[] nums) {
        int pos=0,neg=0;
        for (int i=0;i< nums.length;i++){
            if (nums[i]<0)neg++;
            if (nums[i]>0)pos++;
        }
        return Math.max(pos,neg);
    }
}
