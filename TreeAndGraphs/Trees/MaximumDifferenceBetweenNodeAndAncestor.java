package TreeAndGraphs.Trees;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static void main(String[] args) {

    }

    public int maxAncestorDiff(TreeNode root) {
         dfs(root, root.val, root.val);

         return maxDiff;
    }

    int maxDiff = 0;
    private void dfs(TreeNode root, int currMin, int currMax) {
        if (root == null)
            return;

       maxDiff = Math.max(currMax - root.val,  Math.abs(currMin - root.val));

       currMax = Math.max(root.val, currMax);
       currMin = Math.min(root.val, currMin);

       dfs(root.left, currMin, currMax);
       dfs(root.right, currMin, currMax);
    }
}
