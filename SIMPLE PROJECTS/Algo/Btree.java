package Algo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Btree {
    public int data;
    public Btree left;
    public Btree right;

    public Btree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Btree(Btree left, Btree right, int data) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    private List<Integer> sortedTreeLevels(Btree node) {
        if (node == null)
            return List.of();
        List<Integer> res = new ArrayList<>();
        Queue<Btree> stack = new ArrayDeque<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            Btree state = stack.poll();
            res.add(state.data);

            if (state.left != null)
                stack.add(state.left);
            if (state.right != null)
                stack.add(state.right);
        }

        return res;
    }

    private int maxSum(Btree node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return node.data;
        return node.data + Math.max(maxSum(node.left), maxSum(node.right));
    }

    public int maxSum() {
        return maxSum(this);
    }

    public List<Integer> sortedTreeLevels() {
        return sortedTreeLevels(this);
    }
}

