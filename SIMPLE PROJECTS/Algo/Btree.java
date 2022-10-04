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
        if (node == null){
            return List.of();
        }
        /*
		*else if node isn't empty, 
		*we create an ArrayList and an ArayDeque
		*and store in the latter the data of node
		*/
        List<Integer> response = new ArrayList<>();
        Queue<Btree> stack = new ArrayDeque<>();
        stack.add(node);
        while (!stack.isEmpty()) {
        /*
        *we put the first element of stack in
        *response
        */
            Btree state = stack.poll();
            response.add(state.data);
         /*
         *we take the value of state.left and 
         *state.right and put it in stack if 
         *they are not null
         */
            if (state.left != null){
                stack.add(state.left);
            }
            if (state.right != null){
                stack.add(state.right);
            }
		}
        return response;
    }

    public List<Integer> sortedTreeLevels() {
        return sortedTreeLevels(this);
    }
}
