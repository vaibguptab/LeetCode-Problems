package Leetcode_problems;

import L_list.Node;

import java.util.ArrayList;

import static L_list.LL_take_Input.print;

public class Day5 {
    public static void main(String[] args) {
        Node<Integer> head = new Node<>(4);
        Node<Integer> node = new Node<>(5);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(9);
        head.next = node;
        node.next = node1;
        node1.next = node2;
        node2.next = null;
        delete(node);
        print(head);

        int[] num = {1,2,3};
        System.out.println(AllPermutation(num));

        int[] arr = {2,2,5,6,6,5};
        System.out.println(singlenumber(arr));
        
    }

    private static int singlenumber(int[] arr) {
        int k = 0;
        for (int e: arr) k ^= e;
        return k;
    }


    private static ArrayList<ArrayList<Integer>> AllPermutation(int[] num) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        backtrack(a,new ArrayList<Integer>(),num);
        return a;
    }

    private static void backtrack(ArrayList<ArrayList<Integer>> a, ArrayList<Integer> tempList, int[] num) {
        if (tempList.size()== num.length){
            a.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int e:num){
            if (tempList.contains(e)){
                continue;
            }
            tempList.add(e);
            backtrack(a,tempList,num);
            tempList.remove(tempList.size()-1);
        }
    }

    private static void delete(Node<Integer> node) {
        node.data=(node.next).data;
        node.next=(node.next).next;
    }
}
