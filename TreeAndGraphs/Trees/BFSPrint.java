package TreeAndGraphs.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BFSPrint {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right  = new TreeNode(5);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(4);

        root.left.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(6);

        new BFSPrint().bfs(root);
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len  = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.remove();
                System.out.println(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
    }
}
