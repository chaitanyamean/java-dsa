package BinaryTree;
import com.sun.source.tree.Tree;

import java.util.*;

public class BenchmarkBinaryTree {

    // build Tree Node
    public static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }



    // Build a perfect tree node 1
    //                          /  \

    static TreeNode buildTree(int n) {

        TreeNode root = new TreeNode(1);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int val = 2;

        while(val <= n) {
            TreeNode parent = q.poll();
            parent.left = new TreeNode(val++);
            parent.right = new TreeNode(val++);
            q.offer(parent.left);
            q.offer(parent.right);
        }
        return root;
    }


    // Build using ArrayDeque
    // find sum of all nodes
    static int bfsArrayDeque(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();

            for(int i =0; i<levelSize; i++) {
                TreeNode node = q.poll();
                sum = sum + node.val;

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }

            }


        }

        return sum;
    }

    static int bfsLinkedList(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int levelSize = q.size();

            for(int i =0; i<levelSize; i++) {
                TreeNode node = q.poll();
                sum = sum + node.val;

                if(node.left != null) {
                    q.offer(node.left);
                }

                if(node.right != null) {
                    q.offer(node.right);
                }

            }


        }

        return sum;
    }

    // Build using Linkedlist

    public static void main(String[] args) {

        TreeNode root = buildTree(1_000_000_00);

        // Warmup (let the JIT compiler kick in)
        for (int i = 0; i < 3; i++) {
            bfsArrayDeque(root);
            bfsLinkedList(root);
        }

        // Measure
        long t1 = System.nanoTime();
        long s1 = bfsArrayDeque(root);
        long t2 = System.nanoTime();
        long s2 = bfsLinkedList(root);
        long t3 = System.nanoTime();

        System.out.printf("ArrayDeque: %.2f ms (sum=%d)%n", (t2 - t1) / 1e6, s1);
        System.out.printf("LinkedList: %.2f ms (sum=%d)%n", (t3 - t2) / 1e6, s2);
        System.out.printf("LinkedList is %.1fx slower%n", (double)(t3 - t2) / (t2 - t1));

    }
}
