package TreeAndGraphs.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValueInTreeRow {
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

        System.out.println(new LargestValueInTreeRow().largestValues(root));
    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> nums = new ArrayList<>();
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxRowVal = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.remove();
                maxRowVal = Math.max(maxRowVal, curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }


            nums.add(maxRowVal);
        }

        return nums;
    }
}
