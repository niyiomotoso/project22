package TreeAndGraphs.Trees;

public class MinimumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right  = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(6);

        MinimumDepthBinaryTree minimumDepthBinaryTree =new MinimumDepthBinaryTree();
        System.out.println(minimumDepthBinaryTree.minDepth(root));

    }

    int minDepth = 0;
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null ) {
            return 1 + dfs(root.right);
        }
        if (root.right == null) {
            return 1 + dfs(root.left);
        }


        return Math.min(1+ dfs(root.left), 1 + dfs(root.right));
    }
}
