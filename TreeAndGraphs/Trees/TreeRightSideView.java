package TreeAndGraphs.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeRightSideView {
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

        System.out.println(new TreeRightSideView().rightSideView(root));
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> nums = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len  = queue.size();
            int lastVal  = 0;
            System.out.println("current length "+ len);

            for(int i = 0; i < len; i++) {
                TreeNode curr = queue.remove();
                lastVal = curr.val;

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            nums.add(lastVal);
        }

        return nums;
    }
}
