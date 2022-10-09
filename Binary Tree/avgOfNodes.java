import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class avgOfNodes {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Double temp = 0.0;
            // int div = 0;
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                temp += front.val;
                if (front.left != null) {
                    q.add(root.left);
                }
                if (front.right != null) {
                    q.add(root.right);
                }
            }
            list.add(temp / size);

        }
        return list;
    }
    public static void main(String[] args) {
        
    }
}
